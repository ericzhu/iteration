package com.el.ecom.controller.admin;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.el.ecom.entity.ProductCategory;
import com.el.ecom.service.ProductCategoryService;

@Controller("adminProductCategoryController")
@RequestMapping("/admin/product_category")
public class ProductCategoryController {

   @Resource(name="productCategoryService")
   private ProductCategoryService productCategoryService;
   
   @RequestMapping(value = "/list", method = RequestMethod.GET)
   public String list(ModelMap model) {
      
      List<ProductCategory> productCategoryList = productCategoryService.findAll();
      
      System.out.println(productCategoryList.size());
      
      return "/admin/product_category/list";
   }

}
