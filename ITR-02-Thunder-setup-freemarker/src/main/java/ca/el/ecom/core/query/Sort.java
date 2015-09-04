package ca.el.ecom.core.query;

import java.io.Serializable;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

public class Sort implements Serializable {

   private static final long serialVersionUID = 2119088439960830394L;
   
   public enum Direction {
      asc,
      desc
   }

   private static final Direction DEFAULT_DIRECTION = Direction.desc;

   private String property;

   private Direction direction = DEFAULT_DIRECTION;

   public Sort() {}

   public Sort(String property, Direction direction) {
      this.property = property;
      this.direction = direction;
   }

   public static Sort asc(String property) {
      return new Sort(property, Direction.asc);
   }

   public static Sort desc(String property) {
      return new Sort(property, Direction.desc);
   }

   public String getProperty() {
      return property;
   }

   public void setProperty(String property) {
      this.property = property;
   }

   public Direction getDirection() {
      return direction;
   }

   public void setDirection(Direction direction) {
      this.direction = direction;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj == null) {
         return false;
      }
      if (this.getClass() != obj.getClass()) {
         return false;
      }
      if (this == obj) {
         return true;
      }
      Sort other = (Sort)obj;
      return new EqualsBuilder().append(getProperty(), other.getProperty()).append(getDirection(), other.getDirection()).isEquals();
   }

   @Override
   public int hashCode() {
      return new HashCodeBuilder(17, 37).append(getProperty()).append(getDirection()).toHashCode();
   }

}
