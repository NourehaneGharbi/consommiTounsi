package tn.consommiTounsi.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twilio.twiml.fax.Receive.MediaType;

import tn.consommiTounsi.spring.entity.Promotion;
import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.services.Implementation.PromotionServiceImpl;

@RestController
@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PromotionController {

	@Autowired
	PromotionServiceImpl promotionServiceImpl;
	
	
	 // URL : http://localhost:8081/SpringMVC/retrieveAllPromotions
    @GetMapping("/retrieveAllPromotions")
    public List<Promotion> retrieveAllPromotions() {
		return promotionServiceImpl.retrieveAllPromotions();
	}
    // URL : http://localhost:8081/SpringMVC/addPromotion
   // @PutMapping("/addPromotion/{idPromotion}")
    @RequestMapping(value = "/addPromotion/{idPromotion}", method = RequestMethod.PUT, consumes = "application/json")
    public Promotion addPromotion(@RequestBody Promotion p, @PathVariable("idPromotion")Long idPromotion) {
		return promotionServiceImpl.updatePromotion(p, idPromotion);
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
    
    
    // URL: http://localhost:8081/SpringMVC/updatePrmotionById/1
    @RequestMapping(value = "/updatePromotionById/{idPromotion}", method = RequestMethod.PUT, consumes = "application/json" )
    @ResponseBody
    public Promotion updatePromotion(@RequestBody Promotion p, @PathVariable("idPromotion")Long idPromotion) {
    	return promotionServiceImpl.updatePromotion(p, idPromotion);
    }
}
