package tn.consommiTounsi.spring.highChart;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tn.consommiTounsi.spring.entity.Rayons;
import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.repository.RayonsRepository;
import tn.consommiTounsi.spring.services.Implementation.RayonsServiceImpl;
import tn.consommiTounsi.spring.services.Implementation.StockServiceImpl;

@Controller
public class HighChartController {

	@Autowired
	RayonsServiceImpl rayonsServiceImpl;
	
	Date date = new Date(System.currentTimeMillis());
	
	@GetMapping("/displayBarGraph")
	public String barGraph(Model model) {
		List<Rayons> rayons = rayonsServiceImpl.retrieveAllRayons();
		Map<String, Integer> surveyMap = new LinkedHashMap<>();
		
		for(int i=0; i<rayons.size(); i++){		
			//Date dateCrea = stocks.get(i).getDateCreationStock();
		//	int mois =	stocks.get(i).getDateCreationStock().;
	
			surveyMap.put(rayons.get(i).getLibelleProdVentMax(), rayons.get(i).getNbrCmdProd());	
			model.addAttribute("surveyMap", surveyMap);
		}
		
		return "barGraph";
	}

	@GetMapping("/displayPieChart")
	public String pieChart(Model model) {
		model.addAttribute("pass", 50);
		model.addAttribute("fail", 50);
		return "pieChart";
	}
}
