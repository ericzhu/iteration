package ca.el.ecom.core.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang.builder.CompareToBuilder;

@MappedSuperclass
public abstract class _SortableEntity<ID extends Serializable> extends _BaseEntity<ID> implements Comparable<_SortableEntity<ID>> {

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
   public int compareTo(_SortableEntity<ID> entity) {
      return new CompareToBuilder().append(getSortOrder(), entity.getSortOrder()).append(getId(), entity.getId()).toComparison();
   }

}
