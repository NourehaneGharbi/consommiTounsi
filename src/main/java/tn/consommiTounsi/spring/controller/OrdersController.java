package tn.consommiTounsi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.consommiTounsi.spring.entity.Orders;
import tn.consommiTounsi.spring.entity.OrdersRequest;
import tn.consommiTounsi.spring.services.OrdersServiceImpl;

@RestController
@RequestMapping("/Orders")
public class OrdersController {
	@Autowired
	private  OrdersServiceImpl or;
	@PostMapping("/Add")
	public ResponseEntity<?> Add(@RequestBody Orders r){
		return new ResponseEntity<>(or.Ajout(r),HttpStatus.OK);

	}
	@GetMapping("/All")
	public ResponseEntity<?> Affich()
	{
		return new ResponseEntity<>(or.GetAll(),HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping(value= "/Delete/{idCmd}")
	@ResponseBody
	public String DeleteOrder(@PathVariable int idCmd) {
		or.Delete(idCmd);
		return "Order has been deleted successfully";
	}

	
@PutMapping("/update/{idCmd}")
public ResponseEntity<Object> Update(@PathVariable(value = "idCmd") int idCmd,@RequestBody Orders d) {
	d.setIdCmd(idCmd);
	Orders order = or.Update(d, idCmd);
    if(order == null) {
        return ResponseEntity.ok().body(new String("Not Found"));
    }
    return ResponseEntity.ok().body(order);
}

//SORTBY


@GetMapping("/{field}")
public List<Orders> getOrdersWithSort(@PathVariable String field){
	List<Orders> p = or.findOrderWithSorting(field);
	return p ;
}

//PAGINATION


@GetMapping("/pagination/{offset}/{pageSize}")
public Page<Orders> getOrdersWithPagination(@PathVariable int offset,@PathVariable int pageSize){
	Page <Orders> p = or.findOrderWithPagination(offset, pageSize);
	return p;
}
		


@PostMapping("/SaveOrders")
public Orders addOrders(@RequestBody OrdersRequest ordersrequest){
	return or.addOrder(ordersrequest);
	
}
}
