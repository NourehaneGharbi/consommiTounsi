package tn.consommiTounsi.spring.services.Implementation;


import java.sql.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Stock;

import tn.consommiTounsi.spring.repository.StockRepository;

import tn.consommiTounsi.spring.services.Interfaces.StockService;

@Service
public class StockServiceImpl implements StockService{

	@Autowired
	StockRepository stockRepository;

	   
	@Override
	public List<Stock> retrieveAllStocks() {
		List<Stock> stocks = stockRepository.findAll();
		Date aujourduit = new Date(System.currentTimeMillis());
		for(int i=0;i<stocks.size();i++){
			if(stocks.get(i).getDateExpiration().getDate()<aujourduit.getDate()){
				removeStock(stocks.get(i).getIdStock());
			}
		}
		return stocks;
	}

	@Override
	public Stock addStock(Stock s) {
		// TODO Auto-generated method stub
		//s.setDateExpiration(dateExpiration);
		return stockRepository.save(s);
	}

	@Override
	public Stock updateStock(Stock s) {
		// TODO Auto-generated method stub
		return stockRepository.save(s);
	}

	
	@Override
	public void removeStock(Long id) {
		// TODO Auto-generated method stub
		stockRepository.deleteById(id);
	}

	@Override
	public Stock updateStockById(Long id, Integer quantite, Integer quantiteMin, String libelleStock) {
		// TODO Auto-generated method stub
		Stock s= stockRepository.findById(id).get();
		s.setQuantite(quantite);
		s.setQuantiteMin(quantiteMin);
		s.setLibelleStock(libelleStock);
		return stockRepository.save(s);
	}

	@Override
	public Optional<Stock> findById(Long id) {
		// TODO Auto-generated method stub
		return stockRepository.findById(id);
	}

	@Override
	public Optional<Stock> findBydateExpiration(Date dateExpiration) {
		// TODO Auto-generated method stub
		return stockRepository.findByDateExpiration(dateExpiration);
	}
	
	

}
