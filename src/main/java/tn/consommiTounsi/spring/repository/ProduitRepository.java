package tn.consommiTounsi.spring.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.consommiTounsi.spring.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Integer>{
	
	public Optional<Produit> findByNomProd(String nomProd);

}
