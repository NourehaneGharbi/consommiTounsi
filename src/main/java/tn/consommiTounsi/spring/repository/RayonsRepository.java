package tn.consommiTounsi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Rayons;

@Repository
public interface RayonsRepository extends JpaRepository<Rayons, Long>{

}
