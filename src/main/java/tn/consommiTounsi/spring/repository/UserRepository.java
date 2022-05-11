package tn.consommiTounsi.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import tn.consommiTounsi.spring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {

	//User findByUsername(String username);
	User findByEmail(String email);

	User findByUsername(String username);
	Boolean existsByUsername(String username);
	Boolean existsByEmail(String email);
	


}