package tn.consommiTounsi.spring.services.Interfaces;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import tn.consommiTounsi.spring.entity.Stock;


public interface StockService {

	List<Stock> retrieveAllStocks();

	Stock addStock(Stock s);

	Stock updateStock(Stock s);
	
	Stock updateStockById(Long id, Integer quantite, Integer quantiteMin, String libelleStock);

	//Stock retrieveStock(Long id);
	
	Optional < Stock > findById(Long id);
	
	Optional < Stock > findBydateExpiration(Date dateExpiration);

	void removeStock(Long id);
	
}
