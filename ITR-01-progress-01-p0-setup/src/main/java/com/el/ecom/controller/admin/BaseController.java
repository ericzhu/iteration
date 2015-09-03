package com.el.ecom.controller.admin;

import java.util.Date;

import javax.annotation.Resource;
import javax.validation.Validator;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.el.ecom.common.DateEditor;
import com.el.ecom.common.Message;
import com.el.ecom.common.StringEditor;

public class BaseController {

   protected static final String  ERROR_VIEW      = "/admin/common/error";
   protected static final Message ERROR_MESSAGE   = Message.error("admin.message.error");
   protected static final Message SUCCESS_MESSAGE = Message.success("admin.message.success");

   @Resource(name = "validator")
   private Validator              validator;

   @InitBinder
   protected void initBinder(WebDataBinder binder) {
      binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
      binder.registerCustomEditor(Date.class, new DateEditor(true));
      binder.registerCustomEditor(String.class, "password", new StringEditor(true));
   }

}
