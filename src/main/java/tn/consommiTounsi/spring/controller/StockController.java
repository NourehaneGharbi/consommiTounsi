package tn.consommiTounsi.spring.controller;


import java.sql.Date;
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

import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.services.Implementation.StockServiceImpl;

@RestController
public class StockController {

	@Autowired
	StockServiceImpl stockServiceImpl;
	
	 // URL : http://localhost:8081/SpringMVC/retrieveAllStocks
    @GetMapping("/retrieveAllStocks")
    public List<Stock> retrieveAllStocks() {
		return stockServiceImpl.retrieveAllStocks();
	}
    
    // URL : http://localhost:8081/SpringMVC/addStock
    @PostMapping("/addStock")
  //  @RequestMapping(value = "/SpringMVC/addStock", method = RequestMethod.POST, consumes = "application/json")
    public Stock addStock(@RequestBody Stock s) {
		return stockServiceImpl.addStock(s);
	}

    // URL : http://localhost:8081/SpringMVC/updateStock
    @PutMapping("/updateStock")
    public Stock updateStock(@RequestBody Stock s) {
		return stockServiceImpl.updateStock(s);
	}

    
    // URL : http://localhost:8081/SpringMVC/removeStock/2
    @DeleteMapping("/removeStock/{idStock}")
    public void removeStock(@PathVariable("idStock")Long id) {
    	stockServiceImpl.removeStock(id);	
	}
    
   
    // URL : http://localhost:8081/SpringMVC/findStockById/2
    @GetMapping("/findStockById/{id}")
    public Optional<Stock> findStockById(@PathVariable("id")Long id) {
		return stockServiceImpl.findById(id);
	}
    
    // URL: http://localhost:8081/SpringMVC/updateStockById/1
    @PutMapping("/updateStockById/{id}/{quantite}/{quantiteMin}/{libelleStock}")
    public Stock updateStockById(@PathVariable("id")Long id, @PathVariable("quantite")Integer quantite, 
    		@PathVariable("quantiteMin")Integer quantiteMin, @PathVariable("libelleStock")String libelleStock) {
    	return stockServiceImpl.updateStockById(id, quantite, quantiteMin, libelleStock);
    }
    
    // URL : http://localhost:8081/SpringMVC/findByDateExpiration/2
    @GetMapping("/findByDateExpiration/{dateExpiration}")
    public Optional<Stock> findByDateExpiration(@PathVariable("dateExpiration")Date dateExpiration) {
		return stockServiceImpl.findBydateExpiration(dateExpiration);
	}
    
 
}
