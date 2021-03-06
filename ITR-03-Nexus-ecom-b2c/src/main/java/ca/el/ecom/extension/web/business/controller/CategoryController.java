package ca.el.ecom.extension.web.business.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

   @RequestMapping(value="/list", method = RequestMethod.GET)
   public String list(Model uiModel) {
      uiModel.addAttribute("categoryTree", categoryService.findTree());
      return "category/list";
   }
}
