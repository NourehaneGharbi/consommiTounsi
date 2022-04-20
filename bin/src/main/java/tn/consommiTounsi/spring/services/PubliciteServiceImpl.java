package tn.consommiTounsi.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Publicite;
import tn.consommiTounsi.spring.repository.PubliciteRepository;
@Service
public class PubliciteServiceImpl {
	
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


}
