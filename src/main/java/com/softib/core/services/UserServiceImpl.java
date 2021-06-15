package com.softib.core.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.softib.core.entities.User;
import com.softib.core.entities.codes.Role;
import com.softib.core.repositories.UserRepository;
import com.softib.core.util.Utility;

@Service
public class UserServiceImpl implements IUserService {

	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		User user = userRepository.findUserByEmail(email);
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

	@Override
	public User getCurrentUser() {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		return findUserByUserName(username);
	}

	@Override
	public User registerNewUserAccount(User userDto) {
		User user = userDto;
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setIsActive(false);
		user.setActivationKey(Utility.generateActivationKey());
		return userRepository.save(user);
	}

	@Override
	public User findUserByUserName(String username) {
		User user = userRepository.findUserByUsername(username);
		return user;
	}

}
