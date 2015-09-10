package ca.el.ecom.core.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import ca.el.ecom.core.model.entity.Promotion;
import ca.el.ecom.core.repository.db.PromotionRepository;
import ca.el.ecom.core.repository.db._BaseRepository;
import ca.el.ecom.core.service.PromotionService;

@Service("promotionServiceImpl")
public class PromotionServiceImpl extends _BaseServiceImpl<Promotion, Long> implements PromotionService {

   @Inject
   private PromotionRepository promotionRepository;
   
   @Override
   protected _BaseRepository<Promotion, Long> getBaseRepository() {
      return promotionRepository;
   }

}
