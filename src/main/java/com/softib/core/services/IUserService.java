package com.softib.core.services;

import java.util.Collection;
import java.util.List;

import com.softib.core.entities.User;

public interface IUserService {

	public User registerNewUserAccount(User user);
	
	public User getCurrentUser();

	public User findUserByEmail(String email);
	
	public User findUserByUserName(String username);

	public List<User> getAllUsers();

	public User updateUser(User user);

	public void deleteUser(String username);
	
	public void getActivationKey();
	
	public void activateUser(String key);

}
