package com.softib.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softib.entities.User;
import com.softib.entities.codes.Role;
import com.softib.repositories.UserRepository;

@Service
public class UserServiceImpl implements IUserService {

	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User authenticate(String email, String password) {
		// TODO Auto-generated method stub
		User user = userRepository.getSalaireByEmployeIdJPQL(email);
		return user;
	}

	@Override
	public List<User>  getAllUsers() {
		// TODO Auto-generated method stub
		List<User> result = new ArrayList<User>();
		Iterable<User> users  = userRepository.findAll();
		users.forEach(result::add);
		return result;
	}

}
