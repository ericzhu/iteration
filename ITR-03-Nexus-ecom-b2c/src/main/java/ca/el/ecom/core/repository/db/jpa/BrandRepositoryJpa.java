package ca.el.ecom.core.repository.db.jpa;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import ca.el.ecom.core.model.entity.Brand;
import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.query.Filter;
import ca.el.ecom.core.query.Sort;
import ca.el.ecom.core.repository.db.BrandRepository;

@Repository("brandRepositoryJpa")
public class BrandRepositoryJpa extends _BaseRepositoryJpa<Brand, Long> implements BrandRepository {

   @Override
   public List<Brand> findList(Category category, Integer count, List<Filter> filters, List<Sort> sorts) {
      CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();

      CriteriaQuery<Brand> criteriaQuery = criteriaBuilder.createQuery(Brand.class);

      Root<Brand> root = criteriaQuery.from(Brand.class);

      criteriaQuery.select(root);
      if (category != null) {
         criteriaQuery.where(criteriaBuilder.equal(root.join("categories"), category));
      }

      return super.findList(criteriaQuery, null, count, filters, sorts);
   }

}
