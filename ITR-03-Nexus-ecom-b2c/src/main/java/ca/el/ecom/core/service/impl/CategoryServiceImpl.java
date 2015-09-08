package ca.el.ecom.core.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Service;

import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.repository.db.CategoryRepository;
import ca.el.ecom.core.repository.db._BaseRepository;
import ca.el.ecom.core.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends _BaseServiceImpl<Category, Long> implements CategoryService{


   @Override
   public List<Category> findRoots() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<Category> findRoots(Integer count) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<Category> findRoots(Integer count, boolean useCache) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<Category> findParents(Category category, boolean recursive, Integer count) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<Category> findParents(Long categoryId, boolean recursive, Integer count, boolean useCache) {
      // TODO Auto-generated method stub
      return null;
   }
   
   @Inject
   @Named("categoryRepositoryJpa")
   private CategoryRepository categoryRepository;
   
   @Override
   protected _BaseRepository<Category, Long> getBaseRepository() {
      return categoryRepository;
   }

}
