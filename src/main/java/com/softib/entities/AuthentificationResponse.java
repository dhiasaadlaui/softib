package com.softib.entities;

public class AuthentificationResponse {

	private final String jwt;

	public String getJwt() {
		return jwt;
	}

	public AuthentificationResponse(String jwt) {
		super();
		this.jwt = jwt;
	}
	
}
