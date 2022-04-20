package tn.consommiTounsi.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.Orders;
import tn.consommiTounsi.spring.entity.OrdersRequest;
import tn.consommiTounsi.spring.entity.Panier;
import tn.consommiTounsi.spring.repository.OrdersRepository;
import tn.consommiTounsi.spring.repository.PanierRepository;

@Service
public class OrdersServiceImpl {
	
	@Autowired
	OrdersRepository repo;
	
	@Autowired
	PanierRepository panierepo ;
	
	public OrdersServiceImpl(OrdersRepository repo) {
		this.repo=repo;
	}
	
	
public Orders Ajout(Orders r){
	repo.save(r);
	return r ;
}


public List<Orders> GetAll(){
	return repo.findAll();
}

public void Delete(int idCmd ) {
	repo.deleteById(idCmd);
}


public Orders Update(Orders d, int idCmd) {
	
	 
	return repo.save(d);
}


//SORTBY
public List<Orders> findOrderWithSorting(String field){
	return repo.findAll(Sort.by(Sort.Direction.ASC,field));
	}


public Page<Orders> findOrderWithPagination(int offset,int pageSize){
		Page<Orders> p = repo.findAll(PageRequest.of(offset, pageSize));
	return p ;
}


public Orders addOrder(OrdersRequest ordersrequest) {
	
	Panier panier = panierepo.findById(ordersrequest.idPanier) ;
	Orders or=new Orders();
	or.setIdUser(ordersrequest.idUser);
	or.setPayType(ordersrequest.payType);
	or.setPanier(panier);
	return repo.save(or);


}

}

