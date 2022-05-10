package com.ecommerce.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ecommerce.dao.PubliciteRepository;
import com.ecommerce.modal.Publicite;


@Service
public class PubliciteServiceImpl {
	@Autowired
	
	private final PubliciteRepository repo;
	
	public PubliciteServiceImpl(PubliciteRepository repo) {
		this.repo=repo;
	}
public Publicite Ajout(Publicite p){
	repo.save(p);
	return p ;
}
public List<Publicite> GetAll(){
	return repo.findAll();
}

public void Delete(int idPub ) {
	repo.deleteById(idPub);
}
public Publicite Update(Publicite p, int idPub) {
	return repo.save(p);
}

		
		
	
	
	
	


@Autowired
private PubliciteRepository rep;
 
public List<Publicite> listAll() {
    return rep.findAll(Sort.by("typePub").ascending());
}
 


}
