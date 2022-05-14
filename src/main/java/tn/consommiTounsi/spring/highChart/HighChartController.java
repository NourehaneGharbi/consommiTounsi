package tn.consommiTounsi.spring.highChart;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.consommiTounsi.spring.entity.Rayons;
import tn.consommiTounsi.spring.entity.StatBestProd;
import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.repository.RayonsRepository;
import tn.consommiTounsi.spring.services.Implementation.RayonsServiceImpl;
import tn.consommiTounsi.spring.services.Implementation.StockServiceImpl;
import tn.consommiTounsi.spring.services.Interfaces.RayonsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class HighChartController {

	@Autowired
	RayonsService rayonsServiceImpl;
	
	
	 // URL: http://localhost:8081/SpringMVC/bestProduit
	@GetMapping("/bestProduit")
    public List<StatBestProd> nbrVenteProdRayons() {
    	 return rayonsServiceImpl.nbrVenteProdCommande();
    }
	
}
