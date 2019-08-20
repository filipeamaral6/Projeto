package com.polarising.bootsecurity.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import org.springframework.beans.factory.annotation.Value;

public class Account {

	private static final Long MILLIS = ( System.currentTimeMillis() / 100 ) ;
		
	private Long id;
	private Long accountNumber;
	private String iban;
	
	@Value("${app.vars.bankcode}")
	private int bankCode;
	
	@NotBlank(message = "${app.model.message.required}")
	private Long employeeId; 
	
	@NotBlank(message = "${app.model.message.required}")
	private Long[] clientId;
	
	@NotBlank(message = "${app.model.message.required}")
	private String accountType;
	
	@NotBlank(message = "${app.model.message.required}")
	private double balance;
	
	@NotBlank(message = "${app.model.message.required}")
	private double interest;
	
	@NotBlank(message = "${app.model.message.required}")
	private boolean isActive;
	
	@NotBlank(message = "${app.model.message.required}")
	private Date createDate;

/*
 * 		New Account
 */	
	
	public Account ( String countryCode, int agencyNumber, Long employeeId, Long[] clientId, String accountType, double balance, double interest, boolean isActive) {
		super();
		this.employeeId = employeeId;
		this.clientId = clientId;
		this.accountType = accountType;
		this.balance = balance;
		this.interest = interest;
		this.isActive = isActive;
		this.accountNumber = MILLIS;
		this.iban = this.generateIban(countryCode, agencyNumber, this.accountNumber);
	}
	
/*
 * 		Get Account
 */
	public Account(Long id, Long employeeId, Long accountNumber, String iban, Long[] clientId, String accountType, double balance, double interest, boolean isActive, Date createDate) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.accountNumber = accountNumber;
		this.iban = iban;
		this.clientId = clientId;
		this.accountType = accountType;
		this.balance = balance;
		this.interest = interest;
		this.isActive = isActive;
		this.createDate = createDate;
}
	
public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public Long[] getClientId() {
		return clientId;
	}

	public void setClientId(Long[] clientId) {
		this.clientId = clientId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/*
 * 		Format NIB: BBBB AAAA CCCC CCCC CCC KK
 * 		Format IBAN: CountryCode + NIB
 */	
	private String generateIban( String countryCode, int agency, Long accountNumber) {
		
		Long c = accountNumber;	
		int b = this.bankCode;
		int a = agency;
		int k = (int) (Math.random() * (99 - 0 + 1));

		return countryCode + b + a + c + k;
	}
}
