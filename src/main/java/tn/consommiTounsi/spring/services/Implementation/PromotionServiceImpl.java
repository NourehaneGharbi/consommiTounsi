package tn.consommiTounsi.spring.services.Implementation;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Promotion;
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
	
	@Override
	public List<Promotion> retrieveAllPromotions() {
		// TODO Auto-generated method stub
		return promotionRepository.findAll();
	}

	@Override
	public Promotion addPromotion(Promotion p, Long id) {
		// TODO Auto-generated method stub	
		Stock stock = stockRepository.findById(id).get();
		double newPrix = stock.getProduit().getPrix()*p.getValeurPromotion()/100;
		p.setNewProductPrice(newPrix);
		p.setStock(stock);
		stock.getProduit().setPrixPromotion(newPrix);;
		stockRepository.save(stock);
		return promotionRepository.save(p);	  
	}

	
	@Override
	public Promotion updatePromotion(Promotion p) {
		// TODO Auto-generated method stub	
		return promotionRepository.save(p);
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
	

	public List<String> demandePromotion(){
		List<Stock> stocks = stockServiceImpl.retrieveAllStocks();
	    ArrayList<String> p = new ArrayList<>();
		Date aujourdhui = new Date(System.currentTimeMillis());
		for(int i=0; i<stocks.size(); i++){
	    	if((stocks.get(i).getDateExpiration().getDate()-aujourdhui.getDate())<6){
	    	//	System.out.println(stocks.get(i).getProduit().getLibelleProduit());
	    		p.add(stocks.get(i).getProduit().getLibelleProduit());
	    	}			
		}
		
		return p;
	
	}

}
