package ca.el.ecom.extension.common.utils;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class DateEditor extends PropertyEditorSupport {
   private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

   private boolean             emptyAsNull;

   private String              dateFormat          = DEFAULT_DATE_FORMAT;

   public DateEditor(boolean emptyAsNull) {
      this.emptyAsNull = emptyAsNull;
   }

   public DateEditor(boolean emptyAsNull, String dateFormat) {
      this.emptyAsNull = emptyAsNull;
      this.dateFormat = dateFormat;
   }

   @Override
   public String getAsText() {
      Date value = (Date)getValue();
      return value != null ? DateFormatUtils.format(value, dateFormat) : StringUtils.EMPTY;
   }

   @Override
   public void setAsText(String text) {
      if (text != null) {
         String value = text.trim();
         if (emptyAsNull && StringUtils.isEmpty(text)) {
            setValue(null);
         }
         else {
            try {
               setValue(DateUtils.parseDate(value, CommonConstants.DATE_FORMAT_PATTERNS));
            }
            catch (ParseException e) {
               setValue(null);
            }
         }
      }
      else {
         setValue(null);
      }
   }
}
