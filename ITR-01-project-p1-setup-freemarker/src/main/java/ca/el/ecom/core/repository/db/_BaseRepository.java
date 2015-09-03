package ca.el.ecom.core.repository.db;

import java.io.Serializable;
import java.util.List;

import javax.persistence.LockModeType;

import ca.el.ecom.core.model.entity._BaseEntity;
import ca.el.ecom.core.query.Filter;
import ca.el.ecom.core.query.Page;
import ca.el.ecom.core.query.Pageable;
import ca.el.ecom.core.query.Sort;

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
