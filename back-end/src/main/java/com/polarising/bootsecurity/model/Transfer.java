package com.polarising.bootsecurity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Transfer {

	private Long id;

	@NotBlank(message="${app.model.message.required}")
	private Transaction transation;

	@NotBlank(message="${app.model.message.required}")
	@Size(min = 25, max = 25, message = "${app.model.message.length} 25")
	private String destinationIBAN;

	private Long employeeId;

	// Add Transfer
	public Transfer(Transaction transation, String destinationIBAN, Long employeeId) {
		super();
		this.transation = transation;
		this.destinationIBAN = destinationIBAN;
		this.employeeId = employeeId;
	}

	// Get Transfer
	public Transfer(Long id, Transaction transation, String destinationIBAN, Long employeeId) {
		super();
		this.id = id;
		this.transation = transation;
		this.destinationIBAN = destinationIBAN;
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

	public String getDestinationIBAN() {
		return destinationIBAN;
	}

	public void setDestinationIBAN(String destinationIBAN) {
		this.destinationIBAN = destinationIBAN;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}
