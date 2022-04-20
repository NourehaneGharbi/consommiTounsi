package tn.consommiTounsi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Long>{

}
