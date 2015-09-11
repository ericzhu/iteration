package ca.el.ecom.extension.common.utils;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.DateConverter;

/**
 * Extends ConvertUtilsBean by add the enumeration support
 *
 */
public class TypeConvertUtilsBean extends ConvertUtilsBean {
   @Override
   public String convert(Object value) {
      if (value != null) {
         Class<?> type = value.getClass();
         if (type.isEnum() && super.lookup(type) == null) {
            super.register(new EnumConverter(type), type);
         }
         else if (type.isArray() && type.getComponentType().isEnum()) {
            if (super.lookup(type) == null) {
               ArrayConverter arrayConverter = new ArrayConverter(type, new EnumConverter(type.getComponentType()), 0);
               arrayConverter.setOnlyFirstToString(false);
               super.register(arrayConverter, type);
            }
            Converter converter = super.lookup(type);
            return ((String)converter.convert(String.class, value));
         }
      }
      return super.convert(value);
   }

   @SuppressWarnings("rawtypes")
   @Override
   public Object convert(String value, Class clazz) {
      if (clazz.isEnum() && super.lookup(clazz) == null) {
         super.register(new EnumConverter(clazz), clazz);
      }
      return super.convert(value, clazz);
   }

   @SuppressWarnings("rawtypes")
   @Override
   public Object convert(String[] values, Class clazz) {
      if (clazz.isArray() && clazz.getComponentType().isEnum() && super.lookup(clazz.getComponentType()) == null) {
         super.register(new EnumConverter(clazz.getComponentType()), clazz.getComponentType());
      }
      return super.convert(values, clazz);
   }

   @SuppressWarnings("rawtypes")
   @Override
   public Object convert(Object value, Class targetType) {
      if (super.lookup(targetType) == null) {
         if (targetType.isEnum()) {
            super.register(new EnumConverter(targetType), targetType);
         }
         else if (targetType.isArray() && targetType.getComponentType().isEnum()) {
            ArrayConverter arrayConverter = new ArrayConverter(targetType, new EnumConverter(targetType.getComponentType()), 0);
            arrayConverter.setOnlyFirstToString(false);
            super.register(arrayConverter, targetType);
         }
      }
      return super.convert(value, targetType);
   }

   @PostConstruct
   public void registerCustomConverter() {
      DateConverter dateConverter = new DateConverter();
      dateConverter.setPatterns(CommonConstants.DATE_FORMAT_PATTERNS);
      this.register(dateConverter, Date.class);
   }
}
