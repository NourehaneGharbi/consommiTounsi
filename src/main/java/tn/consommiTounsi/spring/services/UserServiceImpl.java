package tn.consommiTounsi.spring.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.consommiTounsi.spring.entity.User;
import tn.consommiTounsi.spring.repository.UserRepository;

@Service

public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> retrieveAllUser() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User addUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return userRepository.save(u);
	}

	@Override
	public Optional<User> retrieveUser(Long id) {
		// TODO Auto-generated method stub
		 return userRepository.findById(id);
		//return u;
	}

	@Override
	public void removeUser(Long id) {
		// TODO Auto-generated method stub
		userRepository.deleteById(id);
	}
	

}
