package tn.consommiTounsi.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.Orders;
import tn.consommiTounsi.spring.entity.Panier;

@Repository
public interface PanierRepository extends JpaRepository<Panier, Integer> {

	public Panier findById(final int idPanier);
}
