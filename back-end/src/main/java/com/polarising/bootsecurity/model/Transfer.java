package com.polarising.bootsecurity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Transfer {

	private Long id;

	@NotBlank(message="${app.model.message.required}")
	private Transaction transation;

	@NotBlank(message="${app.model.message.required}")
	@Size(min = 25, max = 25, message = "${app.model.message.length} 25")
	private String destination_iban;

	private Long employeeId;

	// Add Transfer
	public Transfer(Transaction transation, String destination_iban, Long employeeId) {
		super();
		this.transation = transation;
		this.destination_iban = destination_iban;
		this.employeeId = employeeId;
	}

	// Get Transfer
	public Transfer(Long id, Transaction transation, String destination_iban, Long employeeId) {
		super();
		this.id = id;
		this.transation = transation;
		this.destination_iban = destination_iban;
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
		return destination_iban;
	}

	public void setDestinationIBAN(String destination_iban) {
		this.destination_iban = destination_iban;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
}
