package tn.consommiTounsi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Produit;

@Repository
public interface ProduitRepository extends JpaRepository<Produit, Long>{

}
