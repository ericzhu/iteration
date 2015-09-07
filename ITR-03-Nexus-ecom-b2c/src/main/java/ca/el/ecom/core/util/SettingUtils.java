package ca.el.ecom.core.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import ca.el.ecom.extension.common.utils.CommonConstants;
import ca.el.ecom.extension.common.utils.TypeConvertUtilsBean;

public class SettingUtils {

   private static final CacheManager  cacheManager  = CacheManager.create();

   private static final BeanUtilsBean beanUtilsBean = new BeanUtilsBean(new TypeConvertUtilsBean());

   @SuppressWarnings("unchecked")
   public static Setting get() {
      Ehcache cache = cacheManager.getEhcache(Setting.CACHE_NAME);
      net.sf.ehcache.Element cacheElement = cache.get(Setting.CACHE_KEY);

      if (cacheElement == null) {
         Setting setting = new Setting();
         try {
            File ecomXmlSettingFile = new ClassPathResource(CommonConstants.ECOM_XML_PATH).getFile();
            Document document = new SAXReader().read(ecomXmlSettingFile);
            List<Element> elements = document.selectNodes("/ecom/setting");
            for (Element element : elements) {

               try {
                  String name = element.attributeValue("name");
                  String value = element.attributeValue("value");
                  beanUtilsBean.setProperty(setting, name, value);
               }
               catch (IllegalAccessException e) {
                  throw new RuntimeException(e);
               }
               catch (InvocationTargetException e) {
                  throw new RuntimeException(e);
               }
            }
         }
         catch (IOException | DocumentException e) {
            throw new RuntimeException(e);
         }

         cache.put(new net.sf.ehcache.Element(Setting.CACHE_KEY, setting));
         cacheElement = cache.get(Setting.CACHE_KEY);
      }

      return (Setting)cacheElement.getObjectValue();
   }

   @SuppressWarnings("unchecked")
   public static void set(Setting setting) {
      Assert.notNull(setting);

      try {
         File ecomXmlSettingFile = new ClassPathResource(CommonConstants.ECOM_XML_PATH).getFile();
         Document document = new SAXReader().read(ecomXmlSettingFile);
         List<Element> elements = document.selectNodes("/ecom/setting");
         for (Element element : elements) {
            try {
               String name = element.attributeValue("name");
               String value = beanUtilsBean.getProperty(setting, name);
               Attribute attribute = element.attribute("value");
               attribute.setValue(value);
            }
            catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
               throw new RuntimeException(e.getMessage(), e);
            }
         }

         XMLWriter xmlWriter = null;
         try {
            OutputFormat outputFormat = OutputFormat.createPrettyPrint();
            outputFormat.setEncoding("UTF-8");
            outputFormat.setIndent(true);
            outputFormat.setIndent("   ");
            outputFormat.setNewlines(true);
            xmlWriter = new XMLWriter(new FileOutputStream(ecomXmlSettingFile), outputFormat);
            xmlWriter.write(document);
            xmlWriter.flush();
         }
         catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
         }
         finally {
            try {
               xmlWriter.close();
            }
            catch (Exception e) {

            }
         }
         Ehcache cache = cacheManager.getEhcache(Setting.CACHE_NAME);
         cache.put(new net.sf.ehcache.Element(Setting.CACHE_KEY, setting));
      }
      catch (IOException | DocumentException e) {
         throw new RuntimeException(e.getMessage(), e);
      }

   }
}
