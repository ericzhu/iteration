package ca.el.ecom.core.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import ca.el.ecom.core.BaseIntegrationTests;
import ca.el.ecom.core.model.entity.Brand;
import ca.el.ecom.core.service.BrandService;

public class BrandServiceImplTest extends BaseIntegrationTests{
   @Inject
   BrandService         brandService;
   
   @Test
   public void test_BrandService() {
      List<Brand> brands = brandService.findAll();
      Assert.assertEquals(17, brands.size());
   }
}
