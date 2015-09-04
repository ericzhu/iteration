package ca.el.ecom.core.service.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.repository.db.CategoryRepository;
import ca.el.ecom.core.repository.db._BaseRepository;
import ca.el.ecom.core.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends _BaseServiceImpl<Category, Long> implements CategoryService{

   @Inject
   @Named("categoryRepositoryJpa")
   private CategoryRepository categoryRepository;
   
   @Override
   protected _BaseRepository<Category, Long> getBaseRepository() {
      return categoryRepository;
   }

}
