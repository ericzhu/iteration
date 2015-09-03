package com.el.ecom.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

import com.el.ecom.entity._BaseEntity;
import com.el.ecom.query.Filter;
import com.el.ecom.query.Page;
import com.el.ecom.query.Pageable;
import com.el.ecom.query.Sort;

public interface _BaseRepository<T extends _BaseEntity<ID>, ID extends Serializable> {
   
   T find(ID id);

   T find(ID id, LockModeType lockModeType);

   List<T> findList(Integer first, Integer count, List<Filter> filters, List<Sort> sorts);

   Page<T> findPage(Pageable pageable);

   Long count(Filter... filters);

   void persist(T entity);

   T merge(T entity);

   void remove(T entity);

   void refresh(T entity);

   void refresh(T entity, LockModeType lockModeType);

   ID getIdentifier(T entity);

   boolean isLoaded(T entity);

   boolean isLoaded(T entity, String attributeName);

   boolean isManaged(T entity);

   void detach(T entity);

   void lock(T entity, LockModeType lockModeType);

   void clear();

   void flush();
}
