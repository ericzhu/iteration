package ca.el.ecom.core.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import ca.el.ecom.core.BaseIntegrationTests;
import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.service.CategoryService;

public class CategoryServiceImplTest extends BaseIntegrationTests {

   @Inject
   CategoryService categoryService;
   
   @Test
   public void test_findTree() {
      List<Category> tree = categoryService.findTree();
      
      for(Category c : tree) {
         System.out.println(c.getName());
      }
   }

}
