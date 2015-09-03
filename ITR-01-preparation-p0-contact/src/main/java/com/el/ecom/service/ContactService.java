package com.el.ecom.service;

import java.util.List;

import com.el.ecom.model.entity.Contact;

public interface ContactService {
   
   List<Contact> findAll();

   Contact findById(Long id);

   Contact save(Contact contact);
}
