package ca.el.ecom.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "t_category")
public class Category extends _BaseEntity<Long> implements Serializable {

   private static final long serialVersionUID = -315498149355627163L;

   private String            name;

   @Column(name = "name")
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
