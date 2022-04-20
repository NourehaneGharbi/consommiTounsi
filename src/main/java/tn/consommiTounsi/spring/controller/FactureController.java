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

import tn.consommiTounsi.spring.entity.Facture;
import tn.consommiTounsi.spring.services.FactureServiceImpl;




    @RestController
	@RequestMapping("/Facture")
	public class FactureController {
		@Autowired
		private  FactureServiceImpl fa;
		@PostMapping("/Add")
		public ResponseEntity<?> Add(@RequestBody Facture f){
			return new ResponseEntity<>(fa.Ajout(f),HttpStatus.OK);

		}
		@GetMapping("/All")
		public ResponseEntity<?> Affich()
		{
			return new ResponseEntity<>(fa.GetAll(),HttpStatus.OK);
		}
		@DeleteMapping(value= "/Delete/{idFact}")
		@ResponseBody
		public String DeleteFacture(@PathVariable int idFact) {
			fa.Delete(idFact);
			return "Facture has been deleted successfully";
		}
		@PutMapping("/update/{idFact}")
		public ResponseEntity<Object> Update(@PathVariable(value = "idFact") int idFact,@RequestBody Facture f) {
			f.setIdFact(idFact);
			Facture fact = fa.Update(f, idFact);
		    if(fact == null) {
		        return ResponseEntity.ok().body(new String("Not Found"));
		    }
		    return ResponseEntity.ok().body(fact);
		}
		//SORTBY


		@GetMapping("/{field}")
		public List<Facture> getFactureWithSort(@PathVariable String field){
			List<Facture> f = fa.findFactureWithSorting(field);
			return f ;
		}

		//PAGINATION


		@GetMapping("/pagination/{offset}/{pageSize}")
		public Page<Facture> getFactureWithPagination(@PathVariable int offset,@PathVariable int pageSize){
			Page <Facture> f = fa.findFactureWithPagination(offset, pageSize);
			return f;
		}
}
