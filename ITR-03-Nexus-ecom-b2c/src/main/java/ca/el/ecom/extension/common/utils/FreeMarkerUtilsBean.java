package ca.el.ecom.extension.common.utils;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.util.Assert;

import freemarker.core.Environment;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.DeepUnwrap;

public final class FreeMarkerUtilsBean implements ApplicationContextAware {

   private static ApplicationContext   applicationContext;
   private static TypeConvertUtilsBean typeConvertUtilsBean;

   private FreeMarkerUtilsBean() {}

   @PostConstruct
   private void init() {
      FreeMarkerUtilsBean.typeConvertUtilsBean = applicationContext.getBean(TypeConvertUtilsBean.class);
   }

   @SuppressWarnings("unchecked")
   public static <T> T getArgument(int index, Class<T> type, List<?> arguments) throws TemplateModelException {
      Assert.notNull(type);
      Assert.notNull(arguments);

      if (index >= 0 && index < arguments.size()) {
         Object argument = arguments.get(index);
         Object value;
         if (argument != null) {
            if (argument instanceof TemplateModel) {
               value = DeepUnwrap.unwrap((TemplateModel)argument);
            }
            else {
               value = argument;
            }
            if (value != null) {
               return (T)typeConvertUtilsBean.convert(value, type);
            }
         }
      }
      return null;
   }
   
   @SuppressWarnings("unchecked")
   public static <T> T getParameter(String name, Class<T> type, Map<String, TemplateModel> params) throws TemplateModelException {
      Assert.hasText(name);
      Assert.notNull(type);
      Assert.notNull(params);
      
      TemplateModel templateModel = params.get(name);
      
      if (templateModel != null) {
         Object value = DeepUnwrap.unwrap(templateModel);
         if (value != null) {
            return (T) typeConvertUtilsBean.convert(value, type);
         }
      }
      
      return null;
   }
   
   public static TemplateModel getVariable(String name, Environment env) throws TemplateModelException {
      Assert.hasText(name);
      Assert.notNull(env);
      return env.getVariable(name);
   }
   
   public static void setVariable(String name, Object value, Environment env) throws TemplateException {
      if (value instanceof TemplateModel) {
         env.setVariable(name, (TemplateModel) value);
      } else {
         env.setVariable(name, env.getObjectWrapper().wrap(value));
      }
   }
   

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      FreeMarkerUtilsBean.applicationContext = applicationContext;
   }
}
