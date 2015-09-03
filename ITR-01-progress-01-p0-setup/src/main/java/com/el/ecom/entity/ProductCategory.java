package com.el.ecom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "t_product_category")
public class ProductCategory extends _SortEntity<Long> {

   private static final long serialVersionUID = -4533040201625108577L;

   private String            name;

   @NotEmpty
   @Length(max = 200)
   @Column(nullable = false)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }
}
