package com.el.ecom.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.el.ecom.model.entity.Contact;

public interface ContactRepository extends CrudRepository<Contact, Long> {

}
