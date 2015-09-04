package com.el.ecom.web.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.el.ecom.model.entity.Contact;
import com.el.ecom.service.ContactService;
import com.el.ecom.web.util.Message;
import com.el.ecom.web.util.UrlUtil;

@RequestMapping("/contacts")
@Controller
public class ContactController {

   private final Logger   logger = LoggerFactory.getLogger(ContactController.class);

   private ContactService contactService;
   private MessageSource  messageSource;

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
      logger.info("updating contact");

      if (bindingResult.hasErrors()) {
         uiModel.addAttribute("message", new Message("error", messageSource.getMessage("contact_save_fail", new Object[] {}, locale)));
         uiModel.addAttribute("contact", contact);
         return "contacts/edit";
      }

      uiModel.asMap().clear();
      redirectAttributes.addFlashAttribute("message", new Message("success", messageSource.getMessage("contact_save_success", new Object[] {}, locale)));
      contactService.save(contact);

      return "redirect:/contacts/" + UrlUtil.encodeUrlPathSegment(contact.getId().toString(), httpServletRequest);
   }

   @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
   public String updateForm(@PathVariable("id") Long id, Model uiModel) {

      Contact contact = contactService.findById(id);
      uiModel.addAttribute("contact", contact);

      return "contacts/edit";
   }

   @RequestMapping(params = "form", method = RequestMethod.GET)
   public String createForm(Model uiModel) {
      uiModel.addAttribute("contact", new Contact());
      return "contacts/create";
   }

   @RequestMapping(params = "form", method = RequestMethod.POST)
   public String create(Contact contact, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model uiModel, HttpServletRequest httpServletRequest, Locale locale) {
      
      if(bindingResult.hasErrors()) {
         uiModel.addAttribute("message", new Message("error", messageSource.getMessage("contact_save_fail", new Object[]{}, locale)));
         uiModel.addAttribute("contact", contact);
         return "contacts/create";
      }
      
      contact = contactService.save(contact);
      System.out.println(contact.toString());
      redirectAttributes.addFlashAttribute("message", new Message("success", messageSource.getMessage("contact_save_success", new Object[]{}, locale)));
      
      return "redirect:/contacts/" + UrlUtil.encodeUrlPathSegment(contact.getId().toString(), httpServletRequest);
   }

   @Autowired
   public void setContactService(ContactService contactService) {
      this.contactService = contactService;
   }

   @Autowired
   public void setMessageSource(MessageSource messageSource) {
      this.messageSource = messageSource;
   }

}


































