package ca.el.ecom.extension.web.business.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.service.BrandService;
import ca.el.ecom.core.service.CategoryService;
import ca.el.ecom.core.service.PromotionService;

@Controller("businessCategoryController")
@RequestMapping("/category")
public class CategoryController {

   @Inject
   private CategoryService  categoryService;

   @Inject
   private BrandService     brandService;

   @Inject
   private PromotionService promotionService;

   @RequestMapping(method = RequestMethod.GET)
   public String list(Model uiModel) {
      
      
      List<Category> categoryList = categoryService.findAll();
      uiModel.addAttribute("categoryList", categoryList);
      System.out.println(categoryList.size());
      return "category/list";
   }
}
