package tn.consommiTounsi.spring.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import javax.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.consommiTounsi.spring.entity.ERole;
import tn.consommiTounsi.spring.entity.Role;
import tn.consommiTounsi.spring.entity.User;
import tn.consommiTounsi.spring.repository.RoleRepository;
import tn.consommiTounsi.spring.repository.UserRepository;

@Service
@RequiredArgsConstructor
//@Transactional
@Slf4j

public class UserServiceImpl implements UserService, UserDetailsService {
//	public class UserServiceImpl implements UserService {

	private final UserRepository userRepo;
	private final RoleRepository roleRepo;
	private final PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findByUsername(username);
		if (user == null) {
			log.error("user {} not found in the database", username);
			throw new UsernameNotFoundException("user not found");

		} else {
			log.info("user {} found in the database", username);
		}
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName().name()));
		});
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				authorities);

	}

	@Override
	public List<User> getUsers() {
		log.info("fetching all users");
		return (List<User>) userRepo.findAll();
	}

	@Override
	public List<Role> getRoles() {
		log.info("fetching all roles");
		return (List<Role>) roleRepo.findAll();
	}

	@Override
	public Role saveRole(Role role) {
		log.info("saving new role {} to the database", role.getName());
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String username, ERole roleName) {
		log.info("adding role {} to user {}", roleName, username);
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);
	}

	@Override
	public void deleteUser(Long id) {
		userRepo.deleteById(id);
	}

	@Override
	public void deleteRole(Long id) {
		roleRepo.deleteById(id);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.save(user);
	}

//	@Override
//	public void lockUser(Long id, boolean status) {
//		// TODO Auto-generated method stub
//		User user = userRepo.findById(id).get();
//		user.setAccountNonLocked(status);
//		;
//		userRepo.save(user);
//	}

	@Override
	public Role updateRole(Role role, Long id) {
		return roleRepo.save(role);
	}

	@Override
	public User getUser(String username) {
		log.info("fetching user {} ", username);
		return userRepo.findByUsername(username);
	}

	@Override
	public User saveUser(User user) {
		log.info("saving new user {} to the database", user.getUsername());
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public void lockUser(Long id, boolean status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addRoleToUser(String username, String roleName) {
		// TODO Auto-generated method stub
		
	}

}