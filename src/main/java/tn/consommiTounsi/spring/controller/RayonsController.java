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

import tn.consommiTounsi.spring.entity.Rayons;
import tn.consommiTounsi.spring.entity.Stock;
import tn.consommiTounsi.spring.services.Implementation.RayonsServiceImpl;

@RestController
public class RayonsController {

	@Autowired
	RayonsServiceImpl rayonsServiceImpl;
	
	
	 // URL : http://localhost:8081/SpringMVC/retrieveAllRayons
    @GetMapping("/retrieveAllRayons")
    public List<Rayons> retrieveAllRayons() {
		return rayonsServiceImpl.retrieveAllRayons();
	}
    // URL : http://localhost:8081/SpringMVC/addRayons
    @PostMapping("/addRayons")
  //  @RequestMapping(value = "/SpringMVC/addCategorieProduit", method = RequestMethod.POST, consumes = "application/json")
    public Rayons addRayons(@RequestBody Rayons r) {
		return rayonsServiceImpl.addRayons(r);
	}

    // URL : http://localhost:8081/SpringMVC/updateRayons
    @PutMapping("/updateRayons")
    public Rayons updateRayons(@RequestBody Rayons r) {
		return rayonsServiceImpl.updateRayons(r);
	}

    
    // URL : http://localhost:8081/SpringMVC/removeRayons/2
    @DeleteMapping("/removeRayons/{idRayons}")
    public void removeRayons(@PathVariable("idRayons")Long id) {
		rayonsServiceImpl.removeRayons(id);		
	}
    
   
    // URL : http://localhost:8081/SpringMVC/findRayonsById/2
    @GetMapping("/findRayonsById/{id}")
    public Optional<Rayons> findRayonsById(@PathVariable("id")Long id) {
		return rayonsServiceImpl.findById(id);
	}
    
    // URL: http://localhost:8081/SpringMVC/updateRayonsById/1
    @PutMapping("/updateRayonsById/{id}/{type}")
    public Rayons updateRayonsById(@PathVariable("id")Long id, @PathVariable("type")String type) {
    	return rayonsServiceImpl.updateRayonsById(id, type); 	 
    }
    
    // URL: http://localhost:8081/SpringMVC/nbrVenteProdStock
    @GetMapping("/nbrVenteProdStock")
    public List<Stock> nbrVenteProdStock() {
    	 return rayonsServiceImpl.nbrVenteProdStock();
    }
    
    // URL: http://localhost:8081/SpringMVC/nbrVenteProdCommande
    @GetMapping("/nbrVenteProdCommande")
    public List<Rayons> nbrVenteProdRayons() {
    	 return rayonsServiceImpl.nbrVenteProdCommande();
    }

}
