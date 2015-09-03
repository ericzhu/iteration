package com.el.ecom.web.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.el.ecom.model.entity.Contact;
import com.el.ecom.service.ContactService;

@RequestMapping("/contacts")
@Controller
public class ContactController {

   private final Logger   logger = LoggerFactory.getLogger(ContactController.class);

   private ContactService contactService;

   @RequestMapping(method = RequestMethod.GET)
   public String list(Model uiModel) {
      List<Contact> contacts = contactService.findAll();
      logger.info("No. of contacts: " + contacts.size());
      uiModel.addAttribute("contacts", contacts);
      return "contacts/list";
   }

   @RequestMapping(value = "/{id}", method = RequestMethod.GET)
   public String show(@PathVariable("id") Long id, Model uiModel) {

      Contact contact = contactService.findById(id);
      uiModel.addAttribute("contact", contact);

      return "contacts/show";
   }

   @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.POST)
   public String update(Contact contact,
      BindingResult bindingResult,
      Model uiModel,
      HttpServletRequest httpServletRequest,
      RedirectAttributes redirectAttributes,
      Locale locale) {
      
      
      
      return "";
   }

   @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
   public String updateForm(@PathVariable("id") Long id, Model uiModel) {

      Contact contact = contactService.findById(id);
      uiModel.addAttribute("contact", contact);

      return "contacts/update";
   }

   @Autowired
   public void setContactService(ContactService contactService) {
      this.contactService = contactService;
   }
}
