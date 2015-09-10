package ca.el.ecom.core.integration;

import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;

import org.junit.Assert;
import org.junit.Test;

import ca.el.ecom.core.BaseIntegrationTests;
import ca.el.ecom.core.model.entity.Brand;
import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.model.entity.Promotion;
import ca.el.ecom.core.query.Sort;
import ca.el.ecom.core.service.BrandService;
import ca.el.ecom.core.service.CategoryService;
import ca.el.ecom.core.service.PromotionService;

public class JpaIntegrationTest extends BaseIntegrationTests {

   @Inject
   @Named("entityManagerFactory")
   EntityManagerFactory entityManagerFactory;

   @PersistenceContext
   EntityManager        entityManager;

   @Inject
   CategoryService      categoryService;

   @Inject
   PromotionService     promotionService;

   @Inject
   BrandService         brandService;

   @Test
   public void test_entityManagerFactory_injected() {
      Assert.assertNotNull(entityManagerFactory);
   }

   @Test
   public void test_entityManagerFactory_query() {
      List<Category> categoryList = entityManager.createQuery("from Category", Category.class).getResultList();
      Assert.assertEquals(3, categoryList.size());
   }

   @Test
   public void test_categoryService_integration() {
      List<Category> categoryList = categoryService.findAll();
      for (Category c : categoryList) {
         System.out.println(c.getName());
      }
   }

   @Test
   public void test_categoryService_sort() {
      Sort sort = Sort.asc("name");
      List<Category> categoryList = categoryService.findList(null, null, Arrays.asList(sort));

      for (Category c : categoryList) {
         System.out.println(c.getName());
      }
      System.out.println(categoryService.count());

   }

   @Test
   public void test_PromotionService() {
      List<Promotion> promotions = promotionService.findAll();
      System.out.println(promotions.size());
   }   
}
