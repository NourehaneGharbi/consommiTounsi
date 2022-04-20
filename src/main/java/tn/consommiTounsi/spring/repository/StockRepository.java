package tn.consommiTounsi.spring.repository;

import java.sql.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Long>{

	public Optional<Stock> findByDateExpiration(Date dateExpiration);
	
}
