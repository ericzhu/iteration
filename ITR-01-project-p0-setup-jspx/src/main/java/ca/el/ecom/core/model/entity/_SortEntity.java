package ca.el.ecom.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;

import org.apache.commons.lang.builder.CompareToBuilder;

public class _SortEntity<ID extends Serializable> extends _BaseEntity<ID> implements Comparable<_SortEntity<ID>> {

   private static final long  serialVersionUID    = 1L;

   public static final String ORDER_PROPERTY_NAME = "sortOrder";
   public static final String ORDER_ASC           = ORDER_PROPERTY_NAME + " asc";
   public static final String ORDER_DESC          = ORDER_PROPERTY_NAME + " desc";

   private Integer            sortOrder;

   @Column(name = "sort_order")
   public Integer getSortOrder() {
      return sortOrder;
   }

   public void setSortOrder(Integer sortOrder) {
      this.sortOrder = sortOrder;
   }

   @Override
   public int compareTo(_SortEntity<ID> entity) {
      return new CompareToBuilder().append(getSortOrder(), entity.getSortOrder()).append(getId(), entity.getId()).toComparison();
   }

}
