package ca.el.ecom.core.service;

import java.io.Serializable;
import java.util.List;

import ca.el.ecom.core.model.entity._BaseEntity;
import ca.el.ecom.core.query.Filter;
import ca.el.ecom.core.query.Page;
import ca.el.ecom.core.query.Pageable;
import ca.el.ecom.core.query.Sort;

public interface _BaseService<T extends _BaseEntity<ID>, ID extends Serializable> {
   
   T find(ID id);

   List<T> findAll();

   List<T> findList(List<ID> ids);

   List<T> findList(Integer count, List<Filter> filters, List<Sort> sorts);

   List<T> findList(Integer first, Integer count, List<Filter> filters, List<Sort> sorts);

   Page<T> findPage(Pageable pageable);

   long count();

   long count(Filter... filters);

   boolean exists(ID id);

   boolean exists(Filter... filters);

   T save(T entity);

   T update(T entity);

   T update(T entity, String... ignoreProperties);

   void delete(ID id);

   void delete(List<ID> ids);

   void delete(T entity);
}
