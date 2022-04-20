package tn.consommiTounsi.spring.services;

import java.util.List;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Panier;
import tn.consommiTounsi.spring.repository.PanierRepository;


@Service
public class PanierServiceImpl {
	private final PanierRepository repo;
	
	public PanierServiceImpl(PanierRepository repo) {
		this.repo=repo;
	}
	
	
public Panier Ajout(Panier pa){
	repo.save(pa);
	return pa ;
}


public List<Panier> GetAll(){
	return repo.findAll();
}


public void Delete(int idPanier ) {
	repo.deleteById(idPanier);
}


public Panier Update(Panier pa, int idPanier) {
	return repo.save(pa);
}


public List<Panier> findPanierWithSorting(String field){
	return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	
}


public Page<Panier> findPanierWithPagination(int offset,int pageSize){
	Page<Panier> p = repo.findAll(PageRequest.of(offset, pageSize));
	return p ;
}

}
