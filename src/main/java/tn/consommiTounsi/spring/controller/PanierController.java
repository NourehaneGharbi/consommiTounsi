package tn.consommiTounsi.spring.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.consommiTounsi.spring.entity.Panier;
import tn.consommiTounsi.spring.services.PanierServiceImpl;




@RestController
@RequestMapping("/Panier")
public class PanierController {
	@Autowired
	private  PanierServiceImpl or;
	@PostMapping("/Add")
	public ResponseEntity<?> Add(@RequestBody Panier pa){
		return new ResponseEntity<>(or.Ajout(pa),HttpStatus.OK);

	}
	@GetMapping("/All")
	public ResponseEntity<?> Affich()
	{
		return new ResponseEntity<>(or.GetAll(),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value= "/Delete/{IdPanier}")
	@ResponseBody
	public String DeletePanier(@PathVariable int IdPanier) {
		or.Delete(IdPanier);
		return "Panier has been deleted successfully";
	}

	
@PutMapping("/update/{IdPanier}")
public ResponseEntity<Object> Update(@PathVariable(value = "IdPanier") int IdPanier,@RequestBody Panier pa) {
	pa.setIdPanier(IdPanier);
	Panier panier = or.Update(pa, IdPanier);
    if(panier == null) {
        return ResponseEntity.ok().body(new String("Not Found"));
    }
    return ResponseEntity.ok().body(panier);
}
//SORTBY


@GetMapping("/{field}")
public List<Panier> getPanierWithSort(@PathVariable String field){
	List<Panier> p = or.findPanierWithSorting(field);
	return p ;
}

//PAGINATION


@GetMapping("/pagination/{offset}/{pageSize}")
public Page<Panier> getPaniersWithPagination(@PathVariable int offset,@PathVariable int pageSize){
	Page <Panier> p = or.findPanierWithPagination(offset, pageSize);
	return p;
}

}
