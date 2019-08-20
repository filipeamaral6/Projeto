package com.polarising.bootsecurity.model;

import javax.validation.constraints.NotBlank;

public class UserResponse {
	
	@NotBlank(message="${app.model.message.required}")
	private Long id;
	
	@NotBlank(message="${app.model.message.required}")
	private String username;
	
	@NotBlank(message="${app.model.message.required}")
	private String token;
	
	@NotBlank(message="${app.model.message.required}")
	private String message;
	
	@NotBlank(message="${app.model.message.required}")
	private String role;

	public UserResponse(Long id, String username, String token, String message, String role) {
		this.username = username;
		this.token = token;
		this.message = message;
		this.role = role;
		this.id = id;
	}
	
	protected UserResponse(){}
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
