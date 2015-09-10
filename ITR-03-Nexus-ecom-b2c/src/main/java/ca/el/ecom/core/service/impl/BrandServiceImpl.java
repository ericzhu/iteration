package ca.el.ecom.core.service.impl;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ca.el.ecom.core.model.entity.Brand;
import ca.el.ecom.core.model.entity.Category;
import ca.el.ecom.core.query.Filter;
import ca.el.ecom.core.query.Sort;
import ca.el.ecom.core.repository.db.BrandRepository;
import ca.el.ecom.core.repository.db.CategoryRepository;
import ca.el.ecom.core.repository.db._BaseRepository;
import ca.el.ecom.core.service.BrandService;

@Service("brandServiceImpl")
public class BrandServiceImpl extends _BaseServiceImpl<Brand, Long> implements BrandService {

   @Inject
   private BrandRepository    brandRepository;

   @Inject
   private CategoryRepository categoryRepository;

   @Override
   @Transactional(readOnly = true)
   public List<Brand> findList(Category category, Integer count, List<Filter> filters, List<Sort> sorts) {
      return brandRepository.findList(category, count, filters, sorts);
   }

   @Override
   @Transactional(readOnly = true)
   @Cacheable(value = "brand", condition = "#useCache")
   public List<Brand> findList(Long categoryId, Integer count, List<Filter> filters, List<Sort> sorts, boolean useCache) {
      Category category = categoryRepository.find(categoryId);

      if (category == null) {
         return Collections.emptyList();
      }

      return findList(category, count, filters, sorts);
   }

   @Override
   protected _BaseRepository<Brand, Long> getBaseRepository() {
      return brandRepository;
   }

   @Override
   @Transactional
   @CacheEvict(value = "brand", allEntries = true)
   public Brand save(Brand brand) {
      return super.save(brand);
   }

   @Override
   @Transactional
   @CacheEvict(value = "brand", allEntries = true)
   public Brand update(Brand brand) {
      return super.update(brand);
   }

   @Override
   @Transactional
   @CacheEvict(value = "brand", allEntries = true)
   public Brand update(Brand brand, String... ignoreProperties) {
      return super.update(brand, ignoreProperties);
   }

   @Override
   @Transactional
   @CacheEvict(value = "brand", allEntries = true)
   public void delete(Long id) {
      super.delete(id);
   }

   
   @Transactional
   @CacheEvict(value = "brand", allEntries = true)
   public void delete(List<Long> ids) {
      super.delete(ids);
   }

   @Override
   @Transactional
   @CacheEvict(value = "brand", allEntries = true)
   public void delete(Brand brand) {
      super.delete(brand);
   }
}
