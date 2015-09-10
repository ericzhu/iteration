package ca.el.ecom.core.repository.db;

import java.util.List;

import ca.el.ecom.core.model.entity.Brand;
import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.query.Filter;
import ca.el.ecom.core.query.Sort;

public interface BrandRepository extends _BaseRepository<Brand, Long> {
   List<Brand> findList(Category category, Integer count, List<Filter> filters, List<Sort> sorts);
}
