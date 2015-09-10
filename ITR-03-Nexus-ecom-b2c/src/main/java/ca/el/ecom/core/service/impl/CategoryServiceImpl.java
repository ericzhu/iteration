package ca.el.ecom.core.service.impl;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.repository.db.CategoryRepository;
import ca.el.ecom.core.repository.db._BaseRepository;
import ca.el.ecom.core.service.CategoryService;

@Service("categoryService")
public class CategoryServiceImpl extends _BaseServiceImpl<Category, Long> implements CategoryService {

   @Inject
   @Named("categoryRepositoryJpa")
   private CategoryRepository categoryRepository;

   @Override
   @Transactional(readOnly = true)
   public List<Category> findRoots() {
      return categoryRepository.findRoots(null);
   }

   @Override
   @Transactional(readOnly = true)
   public List<Category> findRoots(Integer count) {
      return categoryRepository.findRoots(count);
   }

   @Override
   @Transactional(readOnly = true)
   @Cacheable(value = "category", condition = "#useCache")
   public List<Category> findRoots(Integer count, boolean useCache) {
      return categoryRepository.findRoots(count);
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

   @Override
   protected _BaseRepository<Category, Long> getBaseRepository() {
      return categoryRepository;
   }

   @Override
   public List<Category> findTree() {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<Category> findChildren(Category category, boolean recursive, Integer count) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public List<Category> findChildren(Long categoryId, boolean recursive, Integer count, boolean useCache) {
      // TODO Auto-generated method stub
      return null;
   }

}
