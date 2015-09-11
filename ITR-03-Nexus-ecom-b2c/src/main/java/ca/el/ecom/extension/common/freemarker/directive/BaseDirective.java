package ca.el.ecom.extension.common.freemarker.directive;

import java.beans.PropertyDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;

import ca.el.ecom.core.query.Filter;
import ca.el.ecom.core.query.Sort;
import ca.el.ecom.core.query.Sort.Direction;
import ca.el.ecom.extension.common.utils.FreeMarkerUtilsBean;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

public abstract class BaseDirective implements TemplateDirectiveModel {

   private static final String USE_CACHE_PARAMETER_NAME = "useCache";
   private static final String ID_PARAMETER_NAME        = "id";
   private static final String COUNT_PARAMETER_NAME     = "count";
   private static final String ORDER_BY_PARAMETER_NAME  = "orderBy";
   private static final String ORDER_BY_ITEM_SEPARATOR  = "\\s*,\\s*";
   private static final String ORDER_BY_FIELD_SEPARATOR = "\\s+";

   protected boolean useCache(Environment env, Map<String, TemplateModel> params) throws TemplateModelException {
      Boolean useCache = FreeMarkerUtilsBean.getParameter(USE_CACHE_PARAMETER_NAME, Boolean.class, params);
      return useCache != null ? useCache : true;
   }

   protected Long getId(Map<String, TemplateModel> params) throws TemplateModelException {
      return FreeMarkerUtilsBean.getParameter(ID_PARAMETER_NAME, Long.class, params);
   }

   protected Integer getCount(Map<String, TemplateModel> params) throws TemplateModelException {
      return FreeMarkerUtilsBean.getParameter(COUNT_PARAMETER_NAME, Integer.class, params);
   }

   protected List<Filter> getFilters(Map<String, TemplateModel> params, Class<?> type, String... ignoreProperties) throws TemplateModelException {
      List<Filter> filters = new ArrayList<Filter>();
      PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(type);
      for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
         String propertyName = propertyDescriptor.getName();
         Class<?> propertyType = propertyDescriptor.getPropertyType();

         if (!ArrayUtils.contains(ignoreProperties, propertyName) && params.containsKey(propertyName)) {
            Object value = FreeMarkerUtilsBean.getParameter(propertyName, propertyType, params);
            filters.add(Filter.eq(propertyName, value));
         }
      }
      return filters;
   }

   protected List<Sort> getSorts(Map<String, TemplateModel> params, String... ignoreProperties) throws TemplateModelException {
      String orderBy = StringUtils.trim(FreeMarkerUtilsBean.getParameter(ORDER_BY_PARAMETER_NAME, String.class, params));
      List<Sort> sorts = new ArrayList<>();
      if (StringUtils.isNotEmpty(orderBy)) {
         String[] orderByItems = orderBy.split(ORDER_BY_ITEM_SEPARATOR);
         for (String orderByItem : orderByItems) {
            if (StringUtils.isNotEmpty(orderByItem)) {
               String property = null;
               Direction direction = null;
               String[] orderBys = orderByItem.split(ORDER_BY_FIELD_SEPARATOR);
               if (orderBys.length == 1) {
                  property = orderBys[0];
               } else if (orderBys.length >= 2) {
                  property = orderBys[0];
                  try {
                     direction = Direction.valueOf(orderBys[1]);
                  } catch (IllegalArgumentException e) {
                     continue;
                  }
               } else {
                  continue;
               }
               if (!ArrayUtils.contains(ignoreProperties, property)) {
                  sorts.add(new Sort(property, direction));
               }
            }
         }
      }
      return sorts;
   }
   
   protected void setLocalVariable(String name, Object value, Environment env, TemplateDirectiveBody body) throws TemplateException, IOException {
      
   }

}
