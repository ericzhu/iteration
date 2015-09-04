package com.el.ecom.entity.listener;

import java.util.Date;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.el.ecom.entity._BaseEntity;

public class EntityListener {
   
   @PrePersist
   public void prePersit(_BaseEntity<?> entity) {
      entity.setCreateDate(new Date());
      entity.setModifyDate(new Date());
      entity.setVersion(null);
   }
   
   @PreUpdate
   public void preUpdate(_BaseEntity<?> entity) {
      entity.setModifyDate(new Date());
   }
   
}
