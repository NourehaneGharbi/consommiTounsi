package tn.consommiTounsi.spring.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Optional;

import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tn.consommiTounsi.spring.entity.Produit;
import tn.consommiTounsi.spring.repository.ProduitRepository;
import tn.consommiTounsi.spring.services.ProduitServiceImpl;
import org.springframework.data.domain.Sort;




@RestController
	@RequestMapping("/Produit")
public class ProduitController {
	
	@Autowired 
	ProduitRepository produitrepository;
	
	@Autowired
	private  ProduitServiceImpl prod;
	@PostMapping("/Add")
	public ResponseEntity<?> Add(@Valid @RequestBody Produit p){
		return new ResponseEntity<>(prod.Ajout(p),HttpStatus.OK);

	}
	
	@GetMapping("/All")
	public ResponseEntity<?> Affich()
	{
		return new ResponseEntity<>(prod.GetAll(),HttpStatus.OK);
	}
	
	@DeleteMapping(value= "/Delete/{idProd}")
	@ResponseBody
	public String DeleteProduit(@PathVariable int idProd) {
		prod.Delete(idProd);
		return "Product has been deleted successfully";
	}
	@PutMapping("/update/{idProd}")
	public ResponseEntity<Object> Update(@PathVariable(value = "idProd") int idProd,@RequestBody Produit p) {
		p.setIdProd(idProd);
		Produit pr = prod.Update(p, idProd);
	    if(pr == null) {
	        return ResponseEntity.ok().body(new String("Not Found"));
	    }
	    return ResponseEntity.ok().body(pr);
	}
	
	@GetMapping("/findByNomProduit/{nomProd}")
    public Optional<Produit> findByNomProduit(@PathVariable("nomProd")String nomProd) {
		return prod.findByNomProduit(nomProd);
	}
	
	
	

    @GetMapping
    
    Page<Produit> getProduit(
            @RequestParam Optional<Integer> page,
            @RequestParam Optional<String> sortBy
    ) {
    	
        return produitrepository.findAll(
                PageRequest.of(
                        page.orElse(0),
                        2,
                        Sort.Direction.ASC, sortBy.orElse("idProd")
                )
        );
    }
	
	
	
	}
	
	
	

