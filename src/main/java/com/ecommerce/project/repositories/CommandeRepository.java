package com.ecommerce.project.repositories;

import com.ecommerce.project.models.Commande;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommandeRepository extends CrudRepository<Commande,Integer> {

    @Query(value="SELECT * FROM commande c WHERE user.id = userId ", nativeQuery = true)
    List<Commande> findCommandeByUserId(long userId) ;
}

