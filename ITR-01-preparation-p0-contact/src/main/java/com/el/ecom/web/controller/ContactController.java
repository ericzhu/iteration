package com.el.ecom.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.el.ecom.model.entity.Contact;
import com.el.ecom.service.ContactService;

@RequestMapping("/contacts")
@Controller
public class ContactController {

   private ContactService contactService;
   
   @RequestMapping(method = RequestMethod.GET)
   public String list(Model uiModel) {
      List<Contact> contacts = contactService.findAll();
      uiModel.addAttribute("contacts", contacts);
      return "contacts/list";
   }
   
   @Autowired
   public void setContactService(ContactService contactService) {
      this.contactService = contactService;
   }
}
