package ca.el.ecom.extension.common.utils;

import java.beans.PropertyEditorSupport;

import org.apache.commons.lang.StringUtils;

public class StringEditor extends PropertyEditorSupport {
   private boolean emptyAsNull;

   public StringEditor(boolean emptyAsNull) {
      this.emptyAsNull = emptyAsNull;
   }

   @Override
   public String getAsText() {
      Object value = getValue();
      return value != null ? value.toString() : StringUtils.EMPTY;
   }

   @Override
   public void setAsText(String text) {
      if (emptyAsNull && StringUtils.isEmpty(text)) {
         setValue(null);
      }
      else {
         setValue(text);
      }
   }
}
