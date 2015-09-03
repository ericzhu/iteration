package com.el.ecom.service;

import java.io.Serializable;
import java.util.List;

import com.el.ecom.entity._BaseEntity;
import com.el.ecom.query.Filter;
import com.el.ecom.query.Page;
import com.el.ecom.query.Pageable;
import com.el.ecom.query.Sort;

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
