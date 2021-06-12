package com.softib.services;

import java.util.Collection;
import java.util.List;

import com.softib.entities.User;


public interface IUserService {
	public User authenticate(String email, String password) ;
	public List<User> getAllUsers() ;
}
