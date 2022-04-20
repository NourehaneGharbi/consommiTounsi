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

import tn.consommiTounsi.spring.entity.Claim;
import tn.consommiTounsi.spring.services.ClaimServiceImpl;

@RestController
@RequestMapping("/Claim")
public class ClaimController {
	@Autowired
	private ClaimServiceImpl ClaimSrv;
	
	//Add_method
	
	@PostMapping("/Add")
	public ResponseEntity<?> Add(@RequestBody Claim c)
	{
		return new ResponseEntity<>(ClaimSrv.AddClaim(c),HttpStatus.OK);
	}
	
	
	//SHOW_Method
	
	@GetMapping("/All")
	public ResponseEntity<?> Show()
	{
		return new ResponseEntity<>(ClaimSrv.GetAll(),HttpStatus.OK);
	}

	
	//DELETE_Method
	
	@DeleteMapping(value = "/Delete/{claim_id}")
	@ResponseBody
	public String DeleteClaim(@PathVariable int claim_id){
		ClaimSrv.DeleteClaim(claim_id);
		return "Claim has been deleted successfully";
	}
	
	//Edit_Method
	
	 @PutMapping("/Edit/{claim_id}")
	 public ResponseEntity<Object> UpdatedClaim(@PathVariable(value="claim_id")int claim_id,@RequestBody Claim c){
		c.setClaim_id(claim_id);
		Claim claim = ClaimSrv.UpdateClaim(c, claim_id);
		if(claim == null) {
			return ResponseEntity.ok().body(new String("Not Found"));
			}
		return ResponseEntity.ok().body(claim);
	 }
}
