package ca.el.ecom.core.service;

import java.util.List;

import ca.el.ecom.core.model.entity.Category;

public interface CategoryService extends _BaseService<Category, Long> {
   List<Category> findRoots();

   List<Category> findRoots(Integer count);

   List<Category> findRoots(Integer count, boolean useCache);

   List<Category> findParents(Category category, boolean recursive, Integer count);

   List<Category> findParents(Long categoryId, boolean recursive, Integer count, boolean useCache);
}
