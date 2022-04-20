package tn.consommiTounsi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Publicite;

@Repository
public interface PubliciteRepository extends JpaRepository<Publicite, Integer> {

}
