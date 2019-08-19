package com.polarising.bootsecurity.model;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.polarising.bootsecurity.soap.client.tibco.schemas.client.InputClient;

@Component
public class Client {
	
	private InputClient inputClient;
	
	@NotBlank(message="${app.model.message.required}")
	private User user;

	private Long id;

	@NotBlank(message="${app.model.message.required}")
	@Size(max = 200, message="${app.model.message.max} 200")
	private String fullName;

	@NotBlank(message="${app.model.message.required}")
	@Size(min = 9, max = 9, message="${app.model.message.length} 9")
	private Long nif;

	@NotBlank(message="${app.model.message.required}")
	private String birthDate;

	private Long phoneNumber;

	private Long mobileNumber;

	@NotBlank(message="${app.model.message.required}")
	private String address;

	@NotBlank(message="${app.model.message.required}")
	private String county;

	@NotBlank(message="${app.model.message.required}")
	private String country;

	@NotBlank(message="${app.model.message.required}")
	private String nationality;

	@NotBlank(message="${app.model.message.required}")
	private String status;

	@NotBlank(message="${app.model.message.required}")
	private String notification;

	@NotBlank(message="${app.model.message.required}")
	private String transactionPassword;
	
	@NotBlank(message="${app.model.message.required}")
	private String zipCode;
	
	@NotBlank(message="${app.model.message.required}")
	private Long clientCC;

	private Date createdAt;
	
	public Client(@ Valid InputClient inputClient) {
		this.inputClient = inputClient;
		this.user = new User(this.inputClient.getUsername(), this.inputClient.getLoginPassword(), this.inputClient.getEmail(), this.inputClient.getRole());
		this.fullName = this.inputClient.getFullName();
		this.nif = Long.parseLong(this.inputClient.getNif());
		this.birthDate = this.inputClient.getBirthDate();
		this.phoneNumber = Long.parseLong(this.inputClient.getPhoneNumber());
		this.mobileNumber = Long.parseLong(this.inputClient.getMobileNumber());
		this.address = this.inputClient.getAddress();
		this.county = this.inputClient.getCounty();
		this.country = this.inputClient.getCountry();
		this.nationality = this.inputClient.getNationality();
		this.status = this.inputClient.getStatus();
		this.notification = this.inputClient.getNotification();
		this.transactionPassword = this.inputClient.getTransactionPassword();
		this.clientCC = Long.parseLong(this.inputClient.getClientCc());
		this.zipCode = this.inputClient.getZipCode();
	}


//	// Add Client
//	public Client(String username, String password, String email, String role, String fullName, Long nif, String birthDate, Long phoneNumber, Long mobileNumber,
//			String address, String county, String country, String nationality, String status, String notification,
//			String transactionPassword, String zipCode, Long clientCC) {
//		super();
//		this.user = new User(username, password, email, role);
//		this.fullName = fullName;
//		this.nif = nif;
//		this.birthDate = birthDate;
//		this.phoneNumber = phoneNumber;
//		this.mobileNumber = mobileNumber;
//		this.address = address;
//		this.county = county;
//		this.country = country;
//		this.nationality = nationality;
//		this.status = status;
//		this.notification = notification;
//		this.transactionPassword = transactionPassword;
//		this.zipCode = zipCode;
//		this.clientCC = clientCC;
//	}

	// Get Client
	public Client(User user, Long id, String fullName, Long nif, String birthDate, Long phoneNumber, Long mobileNumber,
			String address, String county, String country, String nationality, String status, String notification,
			String transactionPassword, Date createdAt) {
		super();
		this.user = user;
		this.id = id;
		this.fullName = fullName;
		this.nif = nif;
		this.birthDate = birthDate;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.county = county;
		this.country = country;
		this.nationality = nationality;
		this.status = status;
		this.notification = notification;
		this.transactionPassword = transactionPassword;
		this.createdAt = createdAt;
	}
	
	
	

	public InputClient getInputClient() {
		return inputClient;
	}


	public void setInputClient(InputClient inputClient) {
		this.inputClient = inputClient;
	}


	public Long getClientCC() {
		return clientCC;
	}


	public void setClientCC(Long clientCC) {
		this.clientCC = clientCC;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public Long getNif() {
		return nif;
	}

	public void setNif(Long nif) {
		this.nif = nif;
	}

	public String getbirthDate() {
		return birthDate;
	}

	public void setbirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(Long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNotification() {
		return notification;
	}

	public void setNotification(String notification) {
		this.notification = notification;
	}

	public String getTransactionPassword() {
		return transactionPassword;
	}

	public void setTransactionPassword(String transactionPassword) {
		this.transactionPassword = transactionPassword;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
