package ca.el.ecom.extension.web.business.controller;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.Set;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.util.Assert;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import ca.el.ecom.core.util.Setting;
import ca.el.ecom.core.util.SettingUtils;
import ca.el.ecom.extension.common.utils.DateEditor;
import ca.el.ecom.extension.common.utils.Message;
import ca.el.ecom.extension.common.utils.StringEditor;

public class BaseController {
   private final Logger           logger                               = LoggerFactory.getLogger(BaseController.class);

   protected static final String  ERROR_VIEW                           = "/business/common/error";

   protected static final Message ERROR_MESSAGE                        = Message.error("admin.message.error");

   protected static final Message SUCCESS_MESSAGE                      = Message.success("admin.message.success");

   private static final String    CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME = "constraintViolations";

   @Inject
   @Named("validator")
   private Validator              validator;

   @InitBinder
   protected void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
      binder.registerCustomEditor(Date.class, new DateEditor(true));
      binder.registerCustomEditor(String.class, "password", new StringEditor(true));
   }

   protected boolean isValid(Object target, Class<?>... groups) {
      Assert.notNull(target);

      Set<ConstraintViolation<Object>> constraintViolations = validator.validate(target, groups);
      if (constraintViolations.isEmpty()) {
         return true;
      }
      RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
      requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations, RequestAttributes.SCOPE_REQUEST);
      return false;
   }

   protected boolean isValid(Collection<Object> targets, Class<?>... groups) {
      Assert.notEmpty(targets);

      for (Object target : targets) {
         if (!isValid(target, groups)) {
            return false;
         }
      }
      return true;
   }

   protected boolean isValid(Class<?> type, String property, Object value, Class<?>... groups) {
      Assert.notNull(type);
      Assert.hasText(property);

      Set<?> constraintViolations = validator.validateValue(type, property, value, groups);
      if (constraintViolations.isEmpty()) {
         return true;
      }
      RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
      requestAttributes.setAttribute(CONSTRAINT_VIOLATIONS_ATTRIBUTE_NAME, constraintViolations, RequestAttributes.SCOPE_REQUEST);
      return false;
   }

   protected boolean isValid(Class<?> type, Map<String, Object> properties, Class<?>... groups) {
      Assert.notNull(type);
      Assert.notEmpty(properties);

      for (Map.Entry<String, Object> entry : properties.entrySet()) {
         if (!isValid(type, entry.getKey(), entry.getValue(), groups)) {
            return false;
         }
      }
      return true;
   }

   protected String currency(BigDecimal amount, boolean showSign, boolean showUnit) {
      Setting setting = SettingUtils.get();
      String price = setting.setScale(amount).toString();
      if (showSign) {
         price = setting.getCurrencySign() + price;
      }
      if (showUnit) {
         price += setting.getCurrencyUnit();
      }
      return price;
   }
}
