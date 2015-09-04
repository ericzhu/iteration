package com.el.ecom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.el.ecom.model.entity.Contact;
import com.el.ecom.repository.jpa.ContactRepository;
import com.el.ecom.service.ContactService;
import com.google.common.collect.Lists;

@Repository
@Service("contactService")
@Transactional
public class ContactServiceImpl implements ContactService {

   private ContactRepository contactRepository;

   @Override
   @Transactional(readOnly=true)
   public List<Contact> findAll() {
      return Lists.newArrayList(contactRepository.findAll());
   }

   @Override
   @Transactional(readOnly=true)
   public Contact findById(Long id) {
      return contactRepository.findOne(id);
   }

   @Override
   public Contact save(Contact contact) {
      return contactRepository.save(contact);
   }

   @Autowired
   public void setContactRepository(ContactRepository contactRepository) {
      this.contactRepository = contactRepository;
   }
}
