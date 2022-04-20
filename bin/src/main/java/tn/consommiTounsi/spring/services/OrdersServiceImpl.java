package tn.consommiTounsi.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Publicite;
import tn.consommiTounsi.spring.repository.PubliciteRepository;

@Service
public class OrdersServiceImpl {
	private final PubliciteRepository repo;
	public OrdersServiceImpl(PubliciteRepository repo) {
		this.repo=repo;
	}
public Publicite Ajout(Publicite r){
	repo.save(r);
	return r ;
}
public List<Publicite> GetAll(){
	return repo.findAll();
}

public void Delete(int idCmd ) {
	repo.deleteById(idCmd);
}
public Publicite Update(Publicite d, int idCmd) {
	return repo.save(d);
}

}

