package com.el.ecom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Min;

import org.apache.commons.lang.builder.CompareToBuilder;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.NumericField;
import org.hibernate.search.annotations.Store;

@MappedSuperclass
public abstract class _SortEntity<ID extends Serializable> extends _BaseEntity<ID> implements Comparable<_SortEntity<ID>> {

   private static final long  serialVersionUID    = 1L;

   public static final String ORDER_PROPERTY_NAME = "sortOrder";
   public static final String ORDER_ASC           = ORDER_PROPERTY_NAME + " asc";
   public static final String ORDER_DESC          = ORDER_PROPERTY_NAME + " desc";

   private Integer            sortOrder;

   @Field(store = Store.YES, index = Index.YES, analyze = Analyze.NO)
   @NumericField
   @Min(0)
   @Column(name = "sort_order")
   public Integer getSortOrder() {
      return sortOrder;
   }

   public void setSortOrder(Integer sortOrder) {
      this.sortOrder = sortOrder;
   }

   @Override
   public int compareTo(_SortEntity<ID> entity) {
      if (entity == null) {
         return 1;
      }
      return new CompareToBuilder().append(getSortOrder(), entity.getSortOrder()).append(getId(), entity.getId()).toComparison();
   }
}