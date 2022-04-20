package tn.consommiTounsi.spring.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import tn.consommiTounsi.spring.entity.Produit;


import tn.consommiTounsi.spring.repository.ProduitRepository;


@Service
public class ProduitServiceImpl {
	private final ProduitRepository repo;
	public ProduitServiceImpl(ProduitRepository repo) {
		this.repo=repo;
}
	public Produit Ajout(Produit f){
		repo.save(f);
		return f ;
	}
	public List<Produit> GetAll(){
		return repo.findAll();
	}
	public void Delete(int idProd) {
		repo.deleteById(idProd);
	}
	public Produit Update(Produit f, int idProd) {
		return repo.save(f);
}
	
	public Optional<Produit> findByNomProduit(String nomProd) {
		
		return repo.findByNomProd(nomProd);
	}

	}
	
	
	
	
	
	
	
	
	

