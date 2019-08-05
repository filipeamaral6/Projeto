package com.polarising.bootsecurity.model;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class Client {

	@NotBlank
	private User user;

	private Long id;

	@NotBlank(message="Campo obrigatório")
	@Size(max = 200, message="O número máximo de caracteres é 200")
	private String fullName;

	@NotBlank(message="Campo obrigatório")
	@Size(min = 9, max = 9, message="Número de caracteres obrigatórios (9)")
	private Long nif;

	@NotBlank(message="Campo obrigatório")
	private Date birthdate;

	private Long phoneNumber;

	private Long mobileNumber;

	@NotBlank(message="Campo obrigatório")
	private String address;

	@NotBlank(message="Campo obrigatório")
	private String county;

	@NotBlank(message="Campo obrigatório")
	private String country;

	@NotBlank(message="Campo obrigatório")
	private String nationality;

	@NotBlank(message="Campo obrigatório")
	private String status;

	@NotBlank(message="Campo obrigatório")
	private String notification;

	@NotBlank(message="Campo obrigatório")
	private String transactionPassword;

	private Date createdAt;


	// Add Client
	public Client(User user, String fullName, Long nif, Date birthdate, Long phoneNumber, Long mobileNumber,
			String address, String county, String country, String nationality, String status, String notification,
			String transactionPassword) {
		super();
		this.user = user;
		this.fullName = fullName;
		this.nif = nif;
		this.birthdate = birthdate;
		this.phoneNumber = phoneNumber;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.county = county;
		this.country = country;
		this.nationality = nationality;
		this.status = status;
		this.notification = notification;
		this.transactionPassword = transactionPassword;
	}

	// Get Client
	public Client(User user, Long id, String fullName, Long nif, Date birthdate, Long phoneNumber, Long mobileNumber,
			String address, String county, String country, String nationality, String status, String notification,
			String transactionPassword, Date createdAt) {
		super();
		this.user = user;
		this.id = id;
		this.fullName = fullName;
		this.nif = nif;
		this.birthdate = birthdate;
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

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
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
