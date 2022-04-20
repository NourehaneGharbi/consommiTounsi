package tn.consommiTounsi.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.consommiTounsi.spring.entity.Rayons;
import tn.consommiTounsi.spring.services.RayonsServiceImpl;

@RestController
@RequestMapping("/pi")
public class RayonsController {
	@Autowired
	private  RayonsServiceImpl Ray;
	@PostMapping("/Ajout")
	public ResponseEntity<?> Add(@RequestBody Rayons r){
		return new ResponseEntity<>(Ray.Ajout(r),HttpStatus.OK);

	}
	@GetMapping("/All")
	public ResponseEntity<?> Affich()
	{
		return new ResponseEntity<>(Ray.GetAll(),HttpStatus.OK);
	}


}
