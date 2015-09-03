package com.el.ecom.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.el.ecom.entity.ProductCategory;
import com.el.ecom.repository.ProductCategoryRepository;
import com.el.ecom.repository._BaseRepository;
import com.el.ecom.service.ProductCategoryService;

@Service("productCategoryService")
public class ProductCategoryServiceImpl extends _BaseServiceImpl<ProductCategory, Long> implements ProductCategoryService {

   @Resource(name = "productCategoryRepository")
   private ProductCategoryRepository productCategoryRepository;

   @Override
   protected _BaseRepository<ProductCategory, Long> getBaseRepository() {
      return productCategoryRepository;
   }

}
