package com.polarising.bootsecurity.model;

public class UserResponse {
	
	private String username;
	
	private String token;
	
	private String message;
	
	private String role;

	public UserResponse(String username, String token, String message, String role) {
		this.username = username;
		this.token = token;
		this.message = message;
		this.role = role;
	}
	
	protected UserResponse(){}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
