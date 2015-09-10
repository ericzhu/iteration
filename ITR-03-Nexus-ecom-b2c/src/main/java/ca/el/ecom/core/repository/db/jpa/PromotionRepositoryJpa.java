package ca.el.ecom.core.repository.db.jpa;

import org.springframework.stereotype.Repository;

import ca.el.ecom.core.model.entity.Promotion;
import ca.el.ecom.core.repository.db.PromotionRepository;

@Repository("promotionRepositoryJpa")
public class PromotionRepositoryJpa extends _BaseRepositoryJpa<Promotion, Long> implements PromotionRepository {

}
