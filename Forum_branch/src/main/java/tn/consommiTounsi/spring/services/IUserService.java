package tn.consommiTounsi.spring.services;

import java.util.List;

import tn.consommiTounsi.spring.entity.Publication;
import tn.consommiTounsi.spring.entity.User;

public interface IUserService {
	
	public void AddUser(User user);
	public List<User> RetrieveUser();
	public void UpdateUserById(User user, int id);
	public void DeleteUser(int id);

}
