package com.softib.controllers.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softib.entities.User;
import com.softib.services.IUserService;

@RestController
public class RestControllerUser {

	@Autowired
	IUserService userService;
	Logger logger = LoggerFactory.getLogger(RestControllerUser.class);
	
	@GetMapping(value = "users")
	@ResponseBody
	public List<User> getAllUsers(){
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username ="null";
		if (principal instanceof UserDetails) {
		   username = ((UserDetails)principal).getUsername();
		} else {
		   username = principal.toString();
		}
		logger.error(username);
		return userService.getAllUsers();	
	}
	
}
