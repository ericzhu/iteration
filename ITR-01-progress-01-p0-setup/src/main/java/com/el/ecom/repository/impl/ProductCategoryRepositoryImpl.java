package com.el.ecom.repository.impl;

import org.springframework.stereotype.Repository;

import com.el.ecom.entity.ProductCategory;
import com.el.ecom.repository.ProductCategoryRepository;

@Repository("productCategoryRepository")
public class ProductCategoryRepositoryImpl extends _BaseRepositoryImpl<ProductCategory, Long> implements ProductCategoryRepository {

}
