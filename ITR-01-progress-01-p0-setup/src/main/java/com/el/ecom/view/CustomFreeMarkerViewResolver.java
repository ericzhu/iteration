package com.el.ecom.view;

import org.springframework.web.servlet.view.AbstractTemplateViewResolver;
import org.springframework.web.servlet.view.AbstractUrlBasedView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;

import com.el.ecom.utils.FreeMarkerUtils;

public class CustomFreeMarkerViewResolver extends AbstractTemplateViewResolver {

   public CustomFreeMarkerViewResolver() {
      setViewClass(requiredViewClass());
   }

   @Override
   protected Class<?> requiredViewClass() {
      return FreeMarkerView.class;
   }

   @Override
   protected AbstractUrlBasedView buildView(String viewName) throws Exception {
      return super.buildView(FreeMarkerUtils.process(viewName));
   }
}
