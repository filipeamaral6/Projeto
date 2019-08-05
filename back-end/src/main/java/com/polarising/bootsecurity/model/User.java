package com.polarising.bootsecurity.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Autowired;

import com.polarising.bootsecurity.security.SecurityConfiguration;

public class User {
	
	@Autowired
	private SecurityConfiguration securityConfig;
	
	private long id;
	
	@NotBlank(message="${app.model.message.required}")
	private String username;

	@NotBlank(message="${app.model.message.required}")
	private String password;
	
	@NotBlank(message="${app.model.message.required}")
	@Email(message="${app.model.message.format}")
	private String email;
	
	private int active;
	
	@NotBlank(message="${app.model.message.required}")
	private String role;
	

	public User(String username, String password, String email, String role) {
		this.username = username;
		this.password = securityConfig.passwordEncoder().encode(password);
		this.email = email;
		this.active = 1;
		this.role = role;
	}
	
	protected User(){}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getActive() {
		return active;
	}

	public void setActive(int active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}