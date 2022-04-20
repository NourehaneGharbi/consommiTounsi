package tn.consommiTounsi.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
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

import tn.consommiTounsi.spring.entity.Colis;
import tn.consommiTounsi.spring.entity.ColisRequest;
import tn.consommiTounsi.spring.services.ColisServiceImpl;

@RestController
@RequestMapping("/Colis")
public class ColisController {
	@Autowired
	private ColisServiceImpl ColiSer;
	
	
	@PostMapping("/Add")
  public ResponseEntity<?> Add(@RequestBody Colis c){
		return new ResponseEntity<>(ColiSer.AddColis(c),HttpStatus.OK);
		
	}
	
	@GetMapping("/All")
	public ResponseEntity<?> Show()
	{
		return new ResponseEntity<>(ColiSer.GetAll(),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/Delete/{colis_id}")
	@ResponseBody
	public String DeleteColis(@PathVariable int colis_id){
		ColiSer.DeleteColis(colis_id);
		return "Colis has been deleted successfully";
	}
	
	
	///DELELTE ALLLLLLLLLLLLLLLLLLL
	
	@DeleteMapping(value = "/DeleteAll")
	@ResponseBody
	public String DeleteAll() {
		ColiSer.retriveAll();
		return "List of Colis has been deleted successfully";
	}
	
	
	
	
	
	
	//EDIT COLIS
	
	@PutMapping("/Edit/{colis_id}")
	public ResponseEntity<Object> UpdateColis(@PathVariable(value="colis_id") int colis_id,@RequestBody Colis c){
		c.setColis_id(colis_id);
		Colis coli = ColiSer.UpdateColis(c, colis_id);
		if(coli == null) {
			return ResponseEntity.ok().body(new String("Not Found"));
			
		}
		return ResponseEntity.ok().body(coli);
		
	}
	
	
	
	//AffectColis
	
	
	@PostMapping("/SaveColis")
	public Colis addColis(@RequestBody ColisRequest colisrequest){
		return ColiSer.addColis(colisrequest);
		
	}
 
	
}
