package com.softib.controllers.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.softib.entities.AuthentificationRequest;
import com.softib.entities.AuthentificationResponse;
import com.softib.entities.User;
import com.softib.security.MyUserDetailsService;
import com.softib.services.IUserService;
import com.softib.util.JwtUtil;

@RestController
public class RestControllerUser {

	@Autowired
	IUserService userService;
	Logger logger = LoggerFactory.getLogger(RestControllerUser.class);
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;
	
	@GetMapping(value = "users")
	@ResponseBody
	public List<User> getAllUsers(){
		logger.info(userService.getCurrentUser().toString());
		return userService.getAllUsers();	
	}
	
	@PostMapping(value = "auth")
	@ResponseBody
	public AuthentificationResponse login(@RequestBody AuthentificationRequest authentificationRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authentificationRequest.getEmail(), authentificationRequest.getPassword())
					);
		} catch (BadCredentialsException e) {
			throw new  Exception("incorrect username and password",e);
		}
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authentificationRequest.getEmail());
		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return new AuthentificationResponse(jwt);
	}
	
	@PostMapping(value = "register")
	@ResponseBody
	public User register(@RequestBody User user) {
		return userService.registerNewUserAccount(user);
	}
	
}
