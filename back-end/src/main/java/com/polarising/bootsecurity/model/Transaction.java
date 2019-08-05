package com.polarising.bootsecurity.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Transaction {
	
	private Long id;
	
	@NotBlank(message = "${app.model.message.required}")
	private double value;
	
	@NotBlank(message = "${app.model.message.required}")
	@Size(min = 25, max = 25, message="${app.model.message.length}25")
	private String accountIBAN;

	@Size(max = 200, message="${app.model.message.max}200")
	private String description;
	
	private Date createdAt;
	
	private Long clientId;
	
	// Add Transaction
	public Transaction(double value, String accountIBAN, String description, Long clientId) {
		super();
		this.value = value;
		this.accountIBAN = accountIBAN;
		this.description = description;
		this.clientId = clientId;
	}
	
	// Get Transaction
	public Transaction(Long id, double value, String accountIBAN, String description,
			Date createdAt, Long clientId) {
		super();
		this.id = id;
		this.value = value;
		this.accountIBAN = accountIBAN;
		this.description = description;
		this.createdAt = createdAt;
		this.clientId = clientId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getAccountIBAN() {
		return accountIBAN;
	}

	public void setAccountIBAN(String accountIBAN) {
		this.accountIBAN = accountIBAN;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
}
