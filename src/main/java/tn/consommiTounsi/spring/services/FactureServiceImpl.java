package tn.consommiTounsi.spring.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Facture;
import tn.consommiTounsi.spring.repository.FactureRepository;


@Service
public class FactureServiceImpl {
	private final FactureRepository repo;
	
	
	public FactureServiceImpl(FactureRepository repo) {
		this.repo=repo;
}
	
	
	public Facture Ajout(Facture f){
		repo.save(f);
		return f ;
	}
	
	
	public List<Facture> GetAll(){
		return repo.findAll();
	}
	
	
	public void Delete(int idFact ) {
		repo.deleteById(idFact);
	}
	
	
	public Facture Update(Facture f, int idFact) {
		return repo.save(f);
}
	
	//SORTBY
	public List<Facture> findFactureWithSorting(String field){
		return repo.findAll(Sort.by(Sort.Direction.ASC,field));
		
	}
	

	public Page<Facture> findFactureWithPagination(int offset,int pageSize){
		
		Page<Facture> f = repo.findAll(PageRequest.of(offset, pageSize));
		return f ;
	}
	
}
