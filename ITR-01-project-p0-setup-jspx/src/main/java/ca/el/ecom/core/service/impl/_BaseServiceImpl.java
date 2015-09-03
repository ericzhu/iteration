package ca.el.ecom.core.service.impl;

import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang.ArrayUtils;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import ca.el.ecom.core.model.entity._BaseEntity;
import ca.el.ecom.core.query.Filter;
import ca.el.ecom.core.query.Page;
import ca.el.ecom.core.query.Pageable;
import ca.el.ecom.core.query.Sort;
import ca.el.ecom.core.repository.db._BaseRepository;
import ca.el.ecom.core.service._BaseService;

public abstract class _BaseServiceImpl<T extends _BaseEntity<ID>, ID extends Serializable> implements _BaseService<T, ID> {
   
   private static final String[] UPDATE_IGNORE_PROPERTIES = new String[] { _BaseEntity.CREATE_DATE_PROPERTY_NAME, _BaseEntity.UPDATE_DATE_PROPERTY_NAME, _BaseEntity.VERSION_PROPERTY_NAME };

   protected abstract _BaseRepository<T, ID> getBaseRepository();

   @Transactional(readOnly = true)
   @Override
   public T find(ID id) {
      return getBaseRepository().find(id);
   }

   @Transactional(readOnly = true)
   @Override
   public List<T> findAll() {
      return findList(null, null, null, null);
   }

   @Transactional(readOnly = true)
   @Override
   public List<T> findList(List<ID> ids) {
      List<T> result = new ArrayList<T>();
      if (ids != null) {
         for (ID id : ids) {
            T entity = find(id);
            if (entity != null) {
               result.add(entity);
            }
         }
      }
      return result;
   }

   @Transactional(readOnly = true)
   @Override
   public List<T> findList(Integer count, List<Filter> filters, List<Sort> sorts) {
      return findList(null, count, filters, sorts);
   }

   @Transactional(readOnly = true)
   @Override
   public List<T> findList(Integer first, Integer count, List<Filter> filters, List<Sort> sorts) {
      return getBaseRepository().findList(first, count, filters, sorts);
   }

   @Transactional(readOnly = true)
   @Override
   public Page<T> findPage(Pageable pageable) {
      return getBaseRepository().findPage(pageable);
   }

   @Transactional(readOnly = true)
   @Override
   public long count() {
      return count(new Filter[] {});
   }

   @Transactional(readOnly = true)
   @Override
   public long count(Filter... filters) {
      return getBaseRepository().count(filters);
   }

   @Transactional(readOnly = true)
   @Override
   public boolean exists(ID id) {
      return getBaseRepository().find(id) != null;
   }

   @Transactional(readOnly = true)
   @Override
   public boolean exists(Filter... filters) {
      return getBaseRepository().count(filters) > 0;
   }

   @Transactional
   @Override
   public T save(T entity) {
      Assert.notNull(entity);
      Assert.isTrue(entity.isNew());

      getBaseRepository().persist(entity);
      return entity;
   }

   @Transactional
   @Override
   public T update(T entity) {
      Assert.notNull(entity);
      Assert.isTrue(!entity.isNew());

      // if the entity is detached, which means not managed by the entityManager,
      // we first find the persistent entity from the datastore, then update the properties
      // of the persistent one with the properties in the new one
      if (!getBaseRepository().isManaged(entity)) {
         T persistant = getBaseRepository().find(getBaseRepository().getIdentifier(entity));
         if (persistant != null) {
            copyProperties(entity, persistant, UPDATE_IGNORE_PROPERTIES);
         }
         return persistant;
      }
      return entity;
   }

   @Transactional
   @Override
   public T update(T entity, String... ignoreProperties) {
      Assert.notNull(entity);
      Assert.isTrue(!entity.isNew());
      Assert.isTrue(!getBaseRepository().isManaged(entity));

      T persistant = getBaseRepository().find(getBaseRepository().getIdentifier(entity));
      if (persistant != null) {
         copyProperties(entity, persistant, (String[])ArrayUtils.addAll(ignoreProperties, UPDATE_IGNORE_PROPERTIES));
      }
      return update(persistant);
   }

   @Transactional
   @Override
   public void delete(ID id) {
      delete(getBaseRepository().find(id));
   }

   @Transactional
   @Override
   public void delete(List<ID> ids) {
      if (ids != null) {
         for (ID id : ids) {
            delete(getBaseRepository().find(id));
         }
      }
   }

   @Transactional
   @Override
   public void delete(T entity) {
      if (entity != null) {
         getBaseRepository().remove(getBaseRepository().isManaged(entity) ? entity : getBaseRepository().merge(entity));
      }
   }

   protected void copyProperties(T source, T target, String... ignoreProperties) {
      Assert.notNull(source);
      Assert.notNull(target);

      PropertyDescriptor[] propertyDescriptors = PropertyUtils.getPropertyDescriptors(target);
      for (PropertyDescriptor propertyDescriptor : propertyDescriptors) {
         String propertyName = propertyDescriptor.getName();
         Method readMethod = propertyDescriptor.getReadMethod();
         Method writeMethod = propertyDescriptor.getWriteMethod();
         if (ArrayUtils.contains(ignoreProperties, propertyName)
            || readMethod == null
            || writeMethod == null
            || !getBaseRepository().isLoaded(source, propertyName)) {
            continue;
         }
         try {
            Object sourceValue = readMethod.invoke(source);
            writeMethod.invoke(target, sourceValue);
         }
         catch (IllegalAccessException e) {
            throw new RuntimeException(e.getMessage(), e);
         }
         catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage(), e);
         }
         catch (InvocationTargetException e) {
            throw new RuntimeException(e.getMessage(), e);
         }
      }
   }
}
