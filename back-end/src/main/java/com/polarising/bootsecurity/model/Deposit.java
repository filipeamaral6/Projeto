package com.polarising.bootsecurity.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Deposit {

	private Long id;
	
	@NotBlank
	private Transaction transation;

	@NotBlank
	private Long employeeId;

	@NotBlank
	private String depositerName;

	@NotBlank
	@Size(max = 8, min = 8, message = "Número de caracteres obrigatórios (8)")
	private Long depositerCC;

	public Deposit(Transaction transation, Long employeeId, String depositerName, Long depositerCC) {
		super();
		this.transation = transation;
		this.employeeId = employeeId;
		this.depositerName = depositerName;
		this.depositerCC = depositerCC;
	}
	
	public Deposit(Long id, Transaction transation, Long employeeId, String depositerName, Long depositerCC) {
		super();
		this.id = id;
		this.transation = transation;
		this.employeeId = employeeId;
		this.depositerName = depositerName;
		this.depositerCC = depositerCC;
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

	public String getDepositerName() {
		return depositerName;
	}

	public void setDepositerName(String depositerName) {
		this.depositerName = depositerName;
	}

	public Long getDepositerCC() {
		return depositerCC;
	}

	public void setDepositerCC(Long depositerCC) {
		this.depositerCC = depositerCC;
	}
}
