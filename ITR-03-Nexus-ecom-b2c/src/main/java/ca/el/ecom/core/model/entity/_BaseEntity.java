package ca.el.ecom.core.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;
import javax.persistence.Version;

@MappedSuperclass
public abstract class _BaseEntity<ID extends Serializable> implements Serializable {

   private static final long  serialVersionUID          = 1L;

   public static final String ID_PROPERTY_NAME          = "id";
   public static final String CREATE_DATE_PROPERTY_NAME = "createDate";
   public static final String UPDATE_DATE_PROPERTY_NAME = "updateDate";
   public static final String VERSION_PROPERTY_NAME     = "version";

   private ID                 id;
   private Date               createDate;
   private Date               updateDate;
   private Long               version;

   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   public ID getId() {
      return id;
   }

   public void setId(ID id) {
      this.id = id;
   }

   @Column(name = "create_date", nullable = false, updatable = false)
   public Date getCreateDate() {
      return createDate;
   }

   public void setCreateDate(Date createDate) {
      this.createDate = createDate;
   }

   @Column(name = "update_date", nullable = false)
   public Date getUpdateDate() {
      return updateDate;
   }

   public void setUpdateDate(Date updateDate) {
      this.updateDate = updateDate;
   }

   @Version
   @Column(name = "version", nullable = false)
   public Long getVersion() {
      return version;
   }

   public void setVersion(Long version) {
      this.version = version;
   }

   @Transient
   public boolean isNew() {
      return getId() == null;
   }

   @Override
   public String toString() {
      return String.format("Entity of type %s with id: %s", getClass().getName(), getId());
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (this == obj) {
         return true;
      }
      if (!_BaseEntity.class.isAssignableFrom(obj.getClass())) {
         return false;
      }
      _BaseEntity<?> other = (_BaseEntity<?>)obj;
      return getId() != null ? getId().equals(other.getId()) : false;
   }

   @Override
   public int hashCode() {
      int hashCode = 17;
      hashCode += getId() != null ? getId().hashCode() * 31 : 0;
      return hashCode;
   }
}
