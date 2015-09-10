package ca.el.ecom.core.service;

import java.util.List;

import ca.el.ecom.core.model.entity.Brand;
import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.query.Filter;
import ca.el.ecom.core.query.Sort;

public interface BrandService extends _BaseService<Brand, Long> {
   List<Brand> findList(Category category, Integer count, List<Filter> filters, List<Sort> sorts);

   List<Brand> findList(Long categoryId, Integer count, List<Filter> filters, List<Sort> sorts, boolean useCache);
}
