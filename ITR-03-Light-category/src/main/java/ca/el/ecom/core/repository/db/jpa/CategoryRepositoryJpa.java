package ca.el.ecom.core.repository.db.jpa;

import org.springframework.stereotype.Repository;

import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.repository.db.CategoryRepository;

@Repository("categoryRepositoryJpa")
public class CategoryRepositoryJpa extends _BaseRepositoryJpa<Category, Long> implements CategoryRepository {

}
