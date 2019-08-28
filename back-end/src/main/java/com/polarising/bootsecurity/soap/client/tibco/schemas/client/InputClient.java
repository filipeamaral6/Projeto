
package com.polarising.bootsecurity.soap.client.tibco.schemas.client;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;



/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="address" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="birthDate" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="client_cc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="country" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="county" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="created_at" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="email" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="full_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="login_password" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="mobile_number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nationality" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="nif" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="notification" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="phone_number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="role" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="status" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="transaction_password" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="user_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="username" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="zip_code" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "inputClient")
public class InputClient {

	@NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "address")
    protected String address;
	
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "birthDate")
    protected String birthDate;
    
    @Size(min = 8, max = 8, message="Número de caracteres obrigatórios (8)")
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "client_cc")
    protected String clientCc;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "country")
    protected String country;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "county")
    protected String county;
    
    @XmlAttribute(name = "created_at")
    protected String createdAt;
    
    @NotBlank(message="Campo obrigatório")
	@Email(message="Formato inválido")
    @XmlAttribute(name = "email")
    protected String email;
    
    @NotBlank(message="Campo obrigatório")
	@Size(max = 200, message="Número de caracteres máximo (200)")
    @XmlAttribute(name = "full_name")
    protected String fullName;
    
    @XmlAttribute(name = "id")
    protected String id;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "login_password")
    protected String loginPassword;
    
    @Size(min = 12, max = 12, message="Número de caracteres obrigatórios (12)")
    @XmlAttribute(name = "mobile_number")
    protected String mobileNumber;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "nationality")
    protected String nationality;
    
    @NotBlank(message="Campo obrigatório")
	@Size(min = 9, max = 9, message="Número de caracteres obrigatórios (9)")
    @XmlAttribute(name = "nif")
    protected String nif;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "notification")
    protected String notification;
    
    @Size(min = 12, max = 12, message="Número de caracteres obrigatórios (12)")
    @XmlAttribute(name = "phone_number")
    protected String phoneNumber;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "role")
    protected String role;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "status")
    protected String status;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "transaction_password")
    protected String transactionPassword;
    
    @XmlAttribute(name = "user_id")
    protected String userId;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "username")
    protected String username;
    
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "zip_code")
    protected String zipCode;

    /**
     * Gets the value of the address property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    
    public String getAddress() {
        return address;
    }

    /**
     * Sets the value of the address property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAddress(String value) {
        this.address = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(String value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the clientCc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientCc() {
        return clientCc;
    }

    /**
     * Sets the value of the clientCc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientCc(String value) {
        this.clientCc = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCountry(String value) {
        this.country = value;
    }

    /**
     * Gets the value of the county property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCounty() {
        return county;
    }

    /**
     * Sets the value of the county property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCounty(String value) {
        this.county = value;
    }

    /**
     * Gets the value of the createdAt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets the value of the createdAt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreatedAt(String value) {
        this.createdAt = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the fullName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * Sets the value of the fullName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullName(String value) {
        this.fullName = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the loginPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLoginPassword() {
        return loginPassword;
    }

    /**
     * Sets the value of the loginPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLoginPassword(String value) {
        this.loginPassword = value;
    }

    /**
     * Gets the value of the mobileNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMobileNumber() {
        return mobileNumber;
    }

    /**
     * Sets the value of the mobileNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMobileNumber(String value) {
        this.mobileNumber = value;
    }

    /**
     * Gets the value of the nationality property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNationality() {
        return nationality;
    }

    /**
     * Sets the value of the nationality property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNationality(String value) {
        this.nationality = value;
    }

    /**
     * Gets the value of the nif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNif() {
        return nif;
    }

    /**
     * Sets the value of the nif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNif(String value) {
        this.nif = value;
    }

    /**
     * Gets the value of the notification property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNotification() {
        return notification;
    }

    /**
     * Sets the value of the notification property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNotification(String value) {
        this.notification = value;
    }

    /**
     * Gets the value of the phoneNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the value of the phoneNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRole(String value) {
        this.role = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the transactionPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionPassword() {
        return transactionPassword;
    }

    /**
     * Sets the value of the transactionPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionPassword(String value) {
        this.transactionPassword = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserId(String value) {
        this.userId = value;
    }

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

}
