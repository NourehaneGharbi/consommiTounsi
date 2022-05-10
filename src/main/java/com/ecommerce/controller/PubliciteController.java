package com.ecommerce.controller;


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

import com.ecommerce.impl.PubliciteServiceImpl;
import com.ecommerce.modal.Publicite;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import javax.servlet.http.HttpServletResponse;





@RestController
@RequestMapping("/Publicite")
public class PubliciteController {
	
	@Autowired
	private  PubliciteServiceImpl or;
	@PostMapping("/Add")
	public ResponseEntity<?> Add(@RequestBody Publicite p){
		return new ResponseEntity<>(or.Ajout(p),HttpStatus.OK);

	}
	@GetMapping("/All")
	public ResponseEntity<?> Affich()
	{
		return new ResponseEntity<>(or.GetAll(),HttpStatus.OK);
	}
	
	
	@DeleteMapping(value= "/Delete/{idPub}")
	@ResponseBody
	public String DeletePublicite(@PathVariable int idPub) {
		or.Delete(idPub);
		return "Order has been deleted successfully";
	}

	
@PutMapping("/update/{idPub}")
public ResponseEntity<Object> Update(@PathVariable(value = "idPub") int idPub,@RequestBody Publicite p) {
	p.setIdPub(idPub);
	Publicite publicite = or.Update(p, idPub);
    if(publicite == null) {
        return ResponseEntity.ok().body(new String("Not Found"));
    }
    return ResponseEntity.ok().body(publicite);
}



}
