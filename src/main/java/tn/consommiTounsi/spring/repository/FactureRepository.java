package tn.consommiTounsi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Facture;
@Repository
public interface FactureRepository extends JpaRepository<Facture, Integer>  {

}
