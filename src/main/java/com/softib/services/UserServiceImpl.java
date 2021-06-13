package com.softib.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.softib.entities.User;
import com.softib.entities.codes.Role;
import com.softib.repositories.UserRepository;
import com.softib.util.Utility;

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
		String email = null;
		if (principal instanceof UserDetails) {
			email = ((UserDetails)principal).getUsername();
		} else {
			email = principal.toString();
		}
		return findUserByEmail(email);
	}

	@Override
	public User registerNewUserAccount(User userDto) {
		User user = userDto;
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setIsActive(false);
		user.setActivationKey(Utility.generateActivationKey());
		return userRepository.save(user);
	}

}
