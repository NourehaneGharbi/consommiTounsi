package tn.consommiTounsi.spring.services;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tn.consommiTounsi.spring.entity.ERole;
import tn.consommiTounsi.spring.entity.Role;
import tn.consommiTounsi.spring.entity.User;

public interface UserService {

	List<User> getUsers();

	User saveUser(User user);

	Role saveRole(Role role);

	void addRoleToUser(String username, String roleName);

	void deleteUser(Long id);

	User updateUser(User user);

	void lockUser(Long id, boolean status);

	User getUser(String username);

	Role updateRole(Role p, Long id);

	void deleteRole(Long id);

	List<Role> getRoles();

	void addRoleToUser(String username, ERole roleName);

}