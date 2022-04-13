package tn.consommiTounsi.spring.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.consommiTounsi.spring.entity.User;
import tn.consommiTounsi.spring.services.UserServiceImpl;


@RestController
public class UserController {
	
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	
	// URL : http://localhost:8081/SpringMVC/retrieveAllUser
    @GetMapping("/retrieveAllUser")
    public List<User> retrieveAllUser() {
    	return userServiceImpl.retrieveAllUser();
		
	}
    // URL : http://localhost:8081/SpringMVC/addUser
    @PostMapping("/addUser")
  //  @RequestMapping(value = "/SpringMVC/addCategorieProduit", method = RequestMethod.POST, consumes = "application/json")
    public User addUser(@RequestBody User u) {
    	return userServiceImpl.addUser(u);		
	}

    // URL : http://localhost:8081/SpringMVC/updateUser
    @PutMapping("/updateUser")
    public User updateUser(@RequestBody User u) {
    	return userServiceImpl.updateUser(u);		
	}


    // URL : http://localhost:8081/SpringMVC/removeUser/2
    @DeleteMapping("/removeUser/{idUser}")
    public void removeUser(@PathVariable("idUser")Long id) {
    	userServiceImpl.removeUser(id);
	}
    
    
    // URL : http://localhost:8081/SpringMVC/retrieveUser/2
    @GetMapping("/retrieveUser/{idUser}")
    public Optional<User> retrieveUser(@PathVariable("idUser")Long id) {
   
    	return userServiceImpl.retrieveUser(id);
	
	}

	
	

}
