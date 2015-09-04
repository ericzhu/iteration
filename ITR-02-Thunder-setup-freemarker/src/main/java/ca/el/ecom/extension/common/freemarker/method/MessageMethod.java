package ca.el.ecom.extension.common.freemarker.method;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.servlet.support.RequestContextUtils;

import ca.el.ecom.extension.common.utils.FreeMarkerUtilsBean;
import freemarker.template.SimpleScalar;
import freemarker.template.TemplateMethodModelEx;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;
import freemarker.template.utility.DeepUnwrap;

public class MessageMethod implements TemplateMethodModelEx, ApplicationContextAware {

   private ApplicationContext applicationContext;

   @Inject
   private HttpServletRequest httpServletRequest;

   @SuppressWarnings("rawtypes")
   @Override
   public Object exec(List arguments) throws TemplateModelException {
      Locale locale = RequestContextUtils.getLocale(httpServletRequest);
      String code = FreeMarkerUtilsBean.getArgument(0, String.class, arguments);
      if (StringUtils.isNotEmpty(code)) {
         String message;
         if (arguments.size() > 1) {
            Object[] args = new Object[arguments.size() - 1];
            for (int i = 1; i < arguments.size(); i++) {
               Object argument = arguments.get(i);
               if (argument != null && argument instanceof TemplateModel) {
                  args[i - 1] = DeepUnwrap.unwrap((TemplateModel)argument);
               }
               else {
                  args[i - 1] = argument;
               }
            }
            message = applicationContext.getMessage(code, args, locale);
         }
         else {
            message = applicationContext.getMessage(code, null, locale);
         }
         return new SimpleScalar(message);
      }
      return null;
   }

   @Override
   public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
      this.applicationContext = applicationContext;
   }

}
