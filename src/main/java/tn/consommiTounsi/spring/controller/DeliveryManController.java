package tn.consommiTounsi.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.consommiTounsi.spring.dao.APIResponse;
import tn.consommiTounsi.spring.entity.Colis;
import tn.consommiTounsi.spring.entity.DeliveryMan;
import tn.consommiTounsi.spring.repository.ColisRepository;
import tn.consommiTounsi.spring.repository.DeliveryManRepository;
import tn.consommiTounsi.spring.services.DeliveryManServiceImpl;
@RestController
@RequestMapping("/DeliveryMan")
public class DeliveryManController {
	@Autowired
	private DeliveryManServiceImpl DelivMan;
	
	@Autowired
	private DeliveryManRepository delivrepo;
	
	@Autowired
	private ColisRepository colisrepo;
	
	
	
	//ADD_DELIVERYMAN
	
	@PostMapping("/Add")
	public ResponseEntity<?> Add(@RequestBody DeliveryMan d) {
		return new ResponseEntity<>(DelivMan.AddDeliveryMan(d),HttpStatus.OK);
		
	}
	
	
	//@PostMapping("/AddWithColis")
//	public DeliveryMan AddC(@Validated @RequestBody DeliveryMan d) {
		//DeliveryMan del=DelivMan.AddDeliveryManCOLIS(d);
		//return del;
		
	//}
	
	//SHOW_ALL_DELIVERYMAN

	
	@GetMapping("/All")	
	public ResponseEntity<?> Show()
	{
		return new ResponseEntity<>(DelivMan.GetAll(),HttpStatus.OK);
	}
	
	//OU
	
	@GetMapping("/FindAllColis")

	public List<DeliveryMan> findAllColis(){
		   return delivrepo.findAll();
	}

	
	//EDIT DELIVERYMAN
	
	@PutMapping("/Edit/{deliveryMan_id}")
	public ResponseEntity<Object> UpdateDeliveryMan(@PathVariable(value = "deliveryMan_id") int deliveryMan_id,@RequestBody DeliveryMan d) {
		d.setDeliveryMan_id(deliveryMan_id);
		DeliveryMan deliv = DelivMan.UpdateDeliveryMan(d, deliveryMan_id);
	    if(deliv == null) {
	        return ResponseEntity.ok().body(new String("Not Found"));
	    }
	    return ResponseEntity.ok().body(deliv);
	}
	
	
	
	
	/*@RequestMapping(value = "/Delete/{DeliveryMan_id}", method = RequestMethod.DELETE)
      @ResponseBody
	public String deleteStudent(@PathVariable int DeliveryMan_id) {
		DelivMan.DeleteDeliveryMan(DeliveryMan_id);
		//return "DeliveryMan has been deleted successfully";
	}*/	
	
	
	
	//DELETE ONE DELIVERYMAN 
	
	@DeleteMapping(value = "/Delete/{deliveryMan_id}")
	@ResponseBody
	public String DeleteDeliveryMan(@PathVariable int deliveryMan_id) {
		DelivMan.DeleteDeliveryMan(deliveryMan_id);
		return "DeliveryMan has been deleted successfully";
	}
	
	
	//DELETE ALL
	
	@DeleteMapping(value = "/DeleteAll")
	@ResponseBody
	public String DeleteAll() {
		DelivMan.retriveAll();
		return "List of DeliveryMan has been deleted successfully";
	}
	
	
	//@RequestMapping(value="/Edit/{DeliveryMan_id}", method = RequestMethod.PUT)
	//public String UpdateDeliveryMan(@PathVariable int DeliveryMan_id, @RequestBody DeliveryMan d) {

	    //DelivMan.UpdateDeliveryMan(d, DeliveryMan_id);
	   // return "DeliveryMan has been updated successfully";

	//}
	
	


	//@GetMapping("/DeliveryMan/{id}") 

	//public DeliveryMan getUserById(@PathVariable("DeliveryMan_id") int DeliveryMan_id){
		  
	//}
/*	
@RequestMapping(value = "/DeliveryManSearchBy/{deliveryMan_id}")
public DeliveryMan getUserById(@PathVariable("deliveryMan_id") int deliveryMan_id){ 
	return DelivMan.getUserById(deliveryMan_id);
			}
	
*/

//@RequestMapping(value = "/DeliveryManSearchByy/{Workload}")
//public List<DeliveryMan> getUserByWorkload(@PathVariable ("Workload") int Workload){ 
//return DelivMan.getUserByWorkload(Workload);
//		}

	
	
//SORTBY


@GetMapping("/{field}")
  public List<DeliveryMan> getUsersWithSort(@PathVariable String field){
	List<DeliveryMan> allUsers = DelivMan.findUsersWithSorting(field);
	return allUsers;
}


//PAGINATION


@GetMapping("/pagination/{offset}/{pageSize}")
  public Page<DeliveryMan> getUsersWithPagination(@PathVariable int offset,@PathVariable int pageSize){
	Page <DeliveryMan> allUsers = DelivMan.findUsersWithPagination(offset, pageSize);
	return allUsers;
}



//Affect
@PostMapping("/AffectColis")
public DeliveryMan AffectColis(@RequestBody Colis request){
	
	return delivrepo.save(request.getDeliveryMan());
}



}
