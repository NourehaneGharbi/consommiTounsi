package tn.consommiTounsi.spring.services.Implementation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.emailDemo.EmailSenderService;
import tn.consommiTounsi.spring.entity.Promotion;
import tn.consommiTounsi.spring.entity.Rayons;
import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.repository.PromotionRepository;
import tn.consommiTounsi.spring.repository.StockRepository;
import tn.consommiTounsi.spring.services.Interfaces.PromotionService;

@Service
public class PromotionServiceImpl implements PromotionService{

	@Autowired
	PromotionRepository promotionRepository;
	
	@Autowired
	StockServiceImpl stockServiceImpl;
	
	@Autowired
	StockRepository stockRepository;
	
	@Autowired
	EmailSenderService emailSenderService;
	
	@Override
	public List<Promotion> retrieveAllPromotions() {
		return promotionRepository.findAll();
	}

	@Override
	public Promotion updatePromotion(Promotion p, Long id) {	
		 Promotion pro = promotionRepository.findById(id).get();
		   pro.setNewProductPrice(pro.getStock().getProduit().getPrix()*p.getValeurPromotion()/100);
		   pro.setDatePromotionDebut(p.getDatePromotionDebut());
		   pro.setDatePromotionFin(p.getDatePromotionFin());
		   pro.setValeurPromotion(p.getValeurPromotion());
		   return promotionRepository.save(pro);
	}

	
	public Promotion updatePromotionById(Long id) {
		// TODO Auto-generated method stub
		Promotion p= promotionRepository.findById(id).get();
		return promotionRepository.save(p);
	}
	
	@Override
	public Optional<Promotion> findById(Long id) {
		// TODO Auto-generated method stub
		return promotionRepository.findById(id);
	}

	@Override
	public void removePromotion(Long id) {
		// TODO Auto-generated method stub
		promotionRepository.deleteById(id);
	}
	

	
	public void genererPromotions() throws UnsupportedEncodingException, MessagingException{
		LocalDate aujourdhui =LocalDate.now();
		//	Optional<User> user = userRepository.findById(id);
		List<Promotion> promotions1 = promotionRepository.findAll();
		
			List<Stock> stocks = stockServiceImpl.retrieveAllStocks();
		   // String toAddress = user.;
			    List<Promotion> promotions = stocks.stream()
						  .filter(s -> (s.getDateExpiration().toLocalDate().isBefore(aujourdhui.plusDays(7))))
						  .map(s->{
				   Promotion p = new Promotion();
				   p.setStock(s);
				   p.setNewProductPrice(s.getProduit().getPrix());
				   p.setDatePromotionDebut(java.sql.Date.valueOf(aujourdhui));
				   p.setDatePromotionFin(java.sql.Date.valueOf(aujourdhui.plusDays(7)));
				   p.setValeurPromotion(10);
				   return p;
			   }) .collect(Collectors.toList());
			    
			    for(int i=0;i<promotions1.size();i++){
			    	for(int x=0;x<promotions.size();x++){
			    		if(promotions1.get(i).getStock().getIdStock()!=promotions.get(x).getStock().getIdStock()){
			    			 promotionRepository.save(promotions.get(x));
			    			 if(!promotions.isEmpty()){
			 			    	String libelle = String.join(
			 							  ",", promotions.stream()
			 							  .map(s -> s.getStock().getProduit().getLibelleProduit())
			 							  .collect(Collectors.toList()));
			 			    	emailSenderService.sendMail(libelle);
			 	            }
						}
			    	}	
				}
			   
			    
	}

}
