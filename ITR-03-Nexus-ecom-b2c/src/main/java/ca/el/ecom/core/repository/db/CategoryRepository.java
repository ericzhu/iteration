package ca.el.ecom.core.repository.db;

import java.util.List;

import ca.el.ecom.core.model.entity.Category;

public interface CategoryRepository extends _BaseRepository<Category, Long> {

   List<Category> findRoots(Integer count);

   List<Category> findParents(Category category, boolean recursive, Integer count);

   List<Category> findChildren(Category category, boolean recursive, Integer count);
}
