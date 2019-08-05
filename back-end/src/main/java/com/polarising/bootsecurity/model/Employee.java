package com.polarising.bootsecurity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Employee {

	@NotBlank(message="${app.model.message.required}")
	private User user;

	private Long id;

	@NotBlank(message = "${app.model.message.required}")
	@Size(max = 200, message = "${app.model.message.max} 200")
	private String fullName;

	// Add Employee
	public Employee(User user, String fullName) {
		super();
		this.user = user;
		this.fullName = fullName;
	}

	// Get Employee
	public Employee(User user, Long id, String fullName) {
		super();
		this.user = user;
		this.id = id;
		this.fullName = fullName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}
