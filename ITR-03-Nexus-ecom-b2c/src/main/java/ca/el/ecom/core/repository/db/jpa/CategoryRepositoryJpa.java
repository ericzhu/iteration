package ca.el.ecom.core.repository.db.jpa;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.springframework.stereotype.Repository;

import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.repository.db.CategoryRepository;

@Repository("categoryRepositoryJpa")
public class CategoryRepositoryJpa extends _BaseRepositoryJpa<Category, Long> implements CategoryRepository {

   @Override
   public List<Category> findRoots(Integer count) {
      String jpql = "select c from Category c where c.parent is null order by c.sortOrder asc";
      TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);
      if (count != null && count > 0) {
         query.setMaxResults(count);
      }
      return query.getResultList();
   }

   @Override
   public List<Category> findParents(Category category, boolean recursive, Integer count) {
      if (category == null || category.getParent() == null) {
         return Collections.emptyList();
      }

      TypedQuery<Category> query = null;

      if (recursive) {
         String jpql = "select c from Category c where Category.id in (:ids) order by c.grade asc";
         query = entityManager.createQuery(jpql, Category.class).setParameter("ids", Arrays.asList(category.getParentIds()));
      }
      else {
         String jpql = "select c from Category where c = :category";
         query = entityManager.createQuery(jpql, Category.class).setParameter("category", category.getParent());
      }

      if (count != null && count > 0) {
         query.setMaxResults(count);
      }

      return query.getResultList();
   }

   @Override
   public List<Category> findChildren(Category category, boolean recursive, Integer count) {

      TypedQuery<Category> query = null;

      if (recursive) {
         if (category != null) {
            String jpql = "select c from Category c where c.treePath like :treePath order by c.grade asc, c.sortOrder asc";
            query = entityManager.createQuery(jpql, Category.class).setParameter("treePath",
               "%" + Category.TREE_PATH_SEPARATOR + category.getId() + Category.TREE_PATH_SEPARATOR + "%");
         }
         else {
            String jpql = "select c from Category c order by c.grade asc, c.sortOrder asc";
            query = entityManager.createQuery(jpql, Category.class);
         }
         if (count != null) {
            query.setMaxResults(count);
         }
         List<Category> result = query.getResultList();
         sort(result);
         return result;
      }
      else {
         String jpql = "select productCategory from ProductCategory productCategory where productCategory.parent = :parent order by productCategory.order asc";
         query = entityManager.createQuery(jpql, Category.class).setParameter("parent", category);
         if (count != null && count > 0) {
            query.setMaxResults(count);
         }
         return query.getResultList();
      }
   }

   protected void sort(List<Category> categoryList) {
      if (CollectionUtils.isEmpty(categoryList)) {
         return;
      }

      final Map<Long, Integer> orderMap = new HashMap<Long, Integer>();

      for (Category category : categoryList) {
         orderMap.put(category.getId(), category.getSortOrder());
      }

      Collections.sort(categoryList, new Comparator<Category>() {

         @Override
         public int compare(Category category1, Category category2) {
            Long[] ids1 = (Long[])ArrayUtils.add(category1.getParentIds(), category1.getId());
            Long[] ids2 = (Long[])ArrayUtils.add(category2.getParentIds(), category2.getId());
            Iterator<Long> iterator1 = Arrays.asList(ids1).iterator();
            Iterator<Long> iterator2 = Arrays.asList(ids2).iterator();
            CompareToBuilder compareToBuilder = new CompareToBuilder();

            while (iterator1.hasNext() && iterator2.hasNext()) {
               Long id1 = iterator1.next();
               Long id2 = iterator2.next();
               Integer order1 = orderMap.get(id1);
               Integer order2 = orderMap.get(id2);
               compareToBuilder.append(order1, order2).append(id1, id2);

               if (!iterator1.hasNext() || !iterator2.hasNext()) {
                  compareToBuilder.append(category1.getGrade(), category2.getGrade());
               }
            }
            return compareToBuilder.toComparison();
         }

      });
   }
}
