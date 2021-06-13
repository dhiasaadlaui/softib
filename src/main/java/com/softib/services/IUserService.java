package com.softib.services;

import java.util.Collection;
import java.util.List;

import com.softib.entities.User;


public interface IUserService {
	
	public User getCurrentUser();
	public User findUserByEmail(String email) ;
	public List<User> getAllUsers() ;
	public User registerNewUserAccount(User user);

}
