package tn.consommiTounsi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Commande;

@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
