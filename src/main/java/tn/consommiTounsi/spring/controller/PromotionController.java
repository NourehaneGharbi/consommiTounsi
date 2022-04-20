package tn.consommiTounsi.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tn.consommiTounsi.spring.entity.Promotion;
import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.services.Implementation.PromotionServiceImpl;

@RestController
public class PromotionController {

	@Autowired
	PromotionServiceImpl promotionServiceImpl;
	
	
	 // URL : http://localhost:8081/SpringMVC/retrieveAllPromotions
    @GetMapping("/retrieveAllPromotions")
    public List<Promotion> retrieveAllPromotions() {
		return promotionServiceImpl.retrieveAllPromotions();
	}
    // URL : http://localhost:8081/SpringMVC/addPromotion
    @PostMapping("/addPromotion/{id}")
  //  @RequestMapping(value = "/SpringMVC/addCategorieProduit", method = RequestMethod.POST, consumes = "application/json")
    public Promotion addPromotion(@RequestBody Promotion p, @PathVariable("id")Long id) {
		return promotionServiceImpl.addPromotion(p, id);
	}

    // URL : http://localhost:8081/SpringMVC/updatePromotion
    @PutMapping("/updatePromotion")
    public Promotion updatePromotion(@RequestBody Promotion p) {
		return promotionServiceImpl.updatePromotion(p);
	}

    
    // URL : http://localhost:8081/SpringMVC/removePromotion/2
    @DeleteMapping("/removePromotion/{idPromotion}")
    public void removePromotion(@PathVariable("idPromotion")Long id) {
    	promotionServiceImpl.removePromotion(id);	
	}
    
   
    // URL : http://localhost:8081/SpringMVC/findPromotionById/2
    @GetMapping("/findPromotionById/{id}")
    public Optional<Promotion> findPromotionById(@PathVariable("id")Long id) {
		return promotionServiceImpl.findById(id);
	}
    
 // URL : http://localhost:8081/SpringMVC/demandePromotion
    @GetMapping("/demandePromotion")
    public List<String> demandePromotion() {
		 return promotionServiceImpl.demandePromotion();
	}
    
    // URL: http://localhost:8081/SpringMVC/updatePromotionById/1
    @PutMapping("/updatePromotionById/{id}")
    public Promotion updatePromotionById(@PathVariable("id")Long id) {
    	return promotionServiceImpl.updatePromotionById(id);
    }
}
