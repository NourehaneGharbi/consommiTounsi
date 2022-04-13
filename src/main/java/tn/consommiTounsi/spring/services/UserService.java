package tn.consommiTounsi.spring.services;
import java.util.List;
import java.util.Optional;

import tn.consommiTounsi.spring.entity.User;
public interface UserService {
	

	List<User> retrieveAllUser();

	User addUser(User r);

	User updateUser(User r);

	Optional<User> retrieveUser(Long id);

	void removeUser(Long id);

}


