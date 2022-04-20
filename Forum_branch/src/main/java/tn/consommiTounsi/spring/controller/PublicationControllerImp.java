package tn.consommiTounsi.spring.controller;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.Inflater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;



import tn.consommiTounsi.spring.entity.Comments;
//import tn.consommiTounsi.spring.entity.ImageT;
import tn.consommiTounsi.spring.entity.Publication;
import tn.consommiTounsi.spring.entity.User;
import tn.consommiTounsi.spring.repository.CommentsRepository;
import tn.consommiTounsi.spring.repository.PublicationRepository;
import tn.consommiTounsi.spring.repository.UserRepository;
import tn.consommiTounsi.spring.services.IPublicationService;
import tn.consommiTounsi.spring.services.IUserService;

@RestController
@RequestMapping("/pi")
@CrossOrigin("*")
public class PublicationControllerImp implements IPublicationController {
	
	@Autowired
	IPublicationService pub_service;
	@Autowired
	UserRepository user_rep;
	@Autowired
	PublicationRepository pub_rep;
	@Autowired
	CommentsRepository com_rep;

	@GetMapping("/RetrievePublication")
	public List<Publication> retrieveAllPublications(){
		List<Publication> pub = pub_service.RetrievePublication();
		return pub;
	}
	
	@PostMapping("/AddPublication/{id}")
	public String AddPub(@RequestBody Publication pub,@PathVariable("id") int id) throws Exception{	
		return pub_service.AddPublication(id, pub);
		
		
		
	}
	
	@PutMapping("/UpdatePublication/{id}/{user_id}")
	public String UpdatePub(@PathVariable("id") int id ,@RequestBody Publication pub,@PathVariable("user_id") int user_id) {
		pub.setId(id);
		user_rep.findById(user_id).map(u ->{
			pub.setUser(u);
			this.pub_service.UpdatePublicationById(pub, id);	
			return u;
		});
		return "pub Update successfully";
	}
	
	@DeleteMapping("remove-publication/{id}")
	public void DeletePub(@PathVariable("id") int id){
		this.pub_service.DeletePublication(id);
	}
	
	@GetMapping("RetrievePublication/{id}")
	public Publication getPubByID(@PathVariable(value = "id")int id){
		
		
		return pub_service.GetPubById(id);
		
	}
	
	@GetMapping("RetrieveComments/{id}")
	public List<Comments> retrieveCOmmentsById(@PathVariable(value = "id")int id){
		
		return com_rep.RelevantComments(id);
	}
	
	
	
	

}
