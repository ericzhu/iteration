package ca.el.ecom.core.model.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "category")
public class Category extends _SortableEntity<Long> implements Serializable {

   private static final long  serialVersionUID    = -315498149355627163L;

   public static final String TREE_PATH_SEPARATOR = ",";

   private String             name;
   private String             seoTitle;
   private String             seoKeywords;
   private String             seoDescription;
   private String             treePath;
   private Integer            grade;
   private Category           parent;
   private Set<Category>      children            = new HashSet<Category>();
   private Set<Brand>         brands              = new HashSet<Brand>();
   private Set<Promotion>     promotions          = new HashSet<Promotion>();

   @NotEmpty
   @Length(max = 200)
   @Column(name = "name", nullable = false)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @Length(max = 200)
   @Column(name = "seo_title")
   public String getSeoTitle() {
      return seoTitle;
   }

   public void setSeoTitle(String seoTitle) {
      this.seoTitle = seoTitle;
   }

   @Length(max = 200)
   @Column(name = "seo_keywords")
   public String getSeoKeywords() {
      return seoKeywords;
   }

   public void setSeoKeywords(String seoKeywords) {
      this.seoKeywords = seoKeywords;
   }

   @Length(max = 200)
   @Column(name = "seo_description")
   public String getSeoDescription() {
      return seoDescription;
   }

   public void setSeoDescription(String seoDescription) {
      this.seoDescription = seoDescription;
   }

   @Column(name = "tree_path", nullable = false)
   public String getTreePath() {
      return treePath;
   }

   public void setTreePath(String treePath) {
      this.treePath = treePath;
   }

   @Column(name = "grade", nullable = false)
   public Integer getGrade() {
      return grade;
   }

   public void setGrade(Integer grade) {
      this.grade = grade;
   }

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "parent_id")
   public Category getParent() {
      return parent;
   }

   public void setParent(Category parent) {
      this.parent = parent;
   }

   @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
   @OrderBy("sortOrder asc")
   public Set<Category> getChildren() {
      return children;
   }

   public void setChildren(Set<Category> children) {
      this.children = children;
   }

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "category_brand", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "brand_id"))
   @OrderBy("sortOrder asc")
   public Set<Brand> getBrands() {
      return brands;
   }

   public void setBrands(Set<Brand> brands) {
      this.brands = brands;
   }

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "category_promotion", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "promotion_id"))
   @OrderBy("sortOrder asc")
   public Set<Promotion> getPromotions() {
      return promotions;
   }

   public void setPromotions(Set<Promotion> promotions) {
      this.promotions = promotions;
   }

   @Transient
   public Long[] getParentIds() {
      String[] parentIds = StringUtils.split(getTreePath(), TREE_PATH_SEPARATOR);
      Long[] result = new Long[parentIds.length];
      for (int i = 0; i < parentIds.length; i++) {
         result[i] = Long.valueOf(parentIds[i]);
      }
      return result;
   }
}