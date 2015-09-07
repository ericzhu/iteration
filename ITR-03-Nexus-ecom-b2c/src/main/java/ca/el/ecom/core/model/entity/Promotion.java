package ca.el.ecom.core.model.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "promotion")
public class Promotion extends _SortableEntity<Long> {

   private static final long serialVersionUID = -7909782734817620608L;

   private String            name;
   private String            title;
   private String            image;
   private Date              beginDate;
   private Date              endDate;
   private BigDecimal        minimumPrice;
   private BigDecimal        maximumPrice;
   private Integer           minimumQuantity;
   private Integer           maximumQuantity;
   private String            priceExpression;
   private String            pointExpression;
   private Boolean           isFreeShipping;
   private Boolean           isCouponAllowed;
   private String            introduction;
   private Set<Category>     categories;

   @NotEmpty
   @Length(max = 200)
   @Column(name = "name", nullable = false)
   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   @NotEmpty
   @Length(max = 200)
   @Column(name = "title", nullable = false)
   public String getTitle() {
      return title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   @Length(max = 200)
   @Pattern(regexp = "^(?i)(http:\\/\\/|https:\\/\\/|\\/).*$")
   @Column(name = "image")
   public String getImage() {
      return image;
   }

   public void setImage(String image) {
      this.image = image;
   }

   public Date getBeginDate() {
      return beginDate;
   }

   public void setBeginDate(Date beginDate) {
      this.beginDate = beginDate;
   }

   public Date getEndDate() {
      return endDate;
   }

   public void setEndDate(Date endDate) {
      this.endDate = endDate;
   }

   @Min(0)
   @Digits(integer = 12, fraction = 3)
   @Column(precision = 21, scale = 6)
   public BigDecimal getMinimumPrice() {
      return minimumPrice;
   }

   public void setMinimumPrice(BigDecimal minimumPrice) {
      this.minimumPrice = minimumPrice;
   }

   @Min(0)
   @Digits(integer = 12, fraction = 3)
   @Column(precision = 21, scale = 6)
   public BigDecimal getMaximumPrice() {
      return maximumPrice;
   }

   public void setMaximumPrice(BigDecimal maximumPrice) {
      this.maximumPrice = maximumPrice;
   }

   @Min(0)
   public Integer getMinimumQuantity() {
      return minimumQuantity;
   }

   public void setMinimumQuantity(Integer minimumQuantity) {
      this.minimumQuantity = minimumQuantity;
   }

   @Min(0)
   public Integer getMaximumQuantity() {
      return maximumQuantity;
   }

   public void setMaximumQuantity(Integer maximumQuantity) {
      this.maximumQuantity = maximumQuantity;
   }

   public String getPriceExpression() {
      return priceExpression;
   }

   public void setPriceExpression(String priceExpression) {
      this.priceExpression = priceExpression;
   }

   public String getPointExpression() {
      return pointExpression;
   }

   public void setPointExpression(String pointExpression) {
      this.pointExpression = pointExpression;
   }

   @NotNull
   @Column(name = "is_free_shipping", nullable = false)
   public Boolean getIsFreeShipping() {
      return isFreeShipping;
   }

   public void setIsFreeShipping(Boolean isFreeShipping) {
      this.isFreeShipping = isFreeShipping;
   }

   @NotNull
   @Column(name = "is_coupon_allowed", nullable = false)
   public Boolean getIsCouponAllowed() {
      return isCouponAllowed;
   }

   public void setIsCouponAllowed(Boolean isCouponAllowed) {
      this.isCouponAllowed = isCouponAllowed;
   }

   @Lob
   @Column(name = "introduction")
   public String getIntroduction() {
      return introduction;
   }

   public void setIntroduction(String introduction) {
      this.introduction = introduction;
   }

   @ManyToMany(mappedBy = "promotions", fetch = FetchType.LAZY)
   @OrderBy("sorOrder asc")
   public Set<Category> getCategories() {
      return categories;
   }

   public void setCategories(Set<Category> categories) {
      this.categories = categories;
   }
}
