package com.polarising.bootsecurity.model;

import javax.validation.constraints.NotBlank;

public class Withdraw {

	private Long id;

	@NotBlank(message="${app.model.message.required}")
	private Transaction transation;

	@NotBlank(message="${app.model.message.required}")
	private Long employeeId;

	// Add Withdraw
	public Withdraw(Transaction transation, Long employeeId) {
		super();
		this.transation = transation;
		this.employeeId = employeeId;
	}

	// Get Withdraw
	public Withdraw(Long id, Transaction transation, Long employeeId) {
		super();
		this.id = id;
		this.transation = transation;
		this.employeeId = employeeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Transaction getTransation() {
		return transation;
	}

	public void setTransation(Transaction transation) {
		this.transation = transation;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}
