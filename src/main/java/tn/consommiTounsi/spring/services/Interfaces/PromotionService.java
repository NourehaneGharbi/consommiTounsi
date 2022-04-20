package tn.consommiTounsi.spring.services.Interfaces;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import tn.consommiTounsi.spring.entity.Promotion;
import tn.consommiTounsi.spring.entity.Stock;

public interface PromotionService {

	List<Promotion> retrieveAllPromotions();

	Promotion addPromotion(Promotion p, Long id);

	Promotion updatePromotion(Promotion p);
	
//	Promotion updatePromotionById(Long id, Integer quantite, Integer quantiteMin, String libelleStock);

	//Stock retrieveStock(Long id);
	
	Optional < Promotion > findById(Long id);
	
	void removePromotion(Long id);
}
