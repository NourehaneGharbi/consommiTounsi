package com.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.modal.Publicite;



@Repository
public interface PubliciteRepository extends JpaRepository<Publicite, Integer> {

}
