package ca.el.ecom.core.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "brand")
public class Brand extends _SortableEntity<Long> {

   private static final long serialVersionUID = -1329525469025359160L;

   public enum Type {
      text,
      image
   }

   private String        name;
   private Type          type;
   private String        logo;
   private String        url;
   private String        introduction;
   private Set<Category> categories = new HashSet<Category>();

   @NotEmpty
   @Length(max = 200)
   @Column(name = "name", nullable = false)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @NotNull
   @Enumerated(EnumType.STRING)
   @Column(name = "type", nullable = false)
   public Type getType() {
      return type;
   }

   public void setType(Type type) {
      this.type = type;
   }

   @Length(max = 200)
   @Pattern(regexp = "^(?i)(http:\\/\\/|https:\\/\\/|\\/).*$")
   @Column(name = "logo")
   public String getLogo() {
      return logo;
   }

   public void setLogo(String logo) {
      this.logo = logo;
   }

   @Length(max = 200)
   @Pattern(regexp = "^(?i)(http:\\/\\/|https:\\/\\/|ftp:\\/\\/|mailto:|\\/|#).*$")
   @Column(name = "url")
   public String getUrl() {
      return url;
   }

   public void setUrl(String url) {
      this.url = url;
   }

   @Column(name = "introduction")
   public String getIntroduction() {
      return introduction;
   }

   public void setIntroduction(String introduction) {
      this.introduction = introduction;
   }

   @ManyToMany(mappedBy = "brands")
   @OrderBy("sortOrder asc")
   public Set<Category> getCategories() {
      return categories;
   }

   public void setCategories(Set<Category> categories) {
      this.categories = categories;
   }

}
