package com.softib.core.entities;

public class AuthentificationRequest {

	private String username;
	private String password;

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public AuthentificationRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	
}
