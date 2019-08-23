
package com.polarising.bootsecurity.soap.transaction.tibco.schemas.deposit;

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
 *       &lt;attribute name="account_iban" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="account_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="created_at" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="depositer_cc_number" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="depositer_name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="description" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="employee_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="transaction_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="type" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="user_id" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "inputDeposit")
public class InputDeposit {
	
	@NotBlank(message="Campo obrigatório")
	@Size(max = 25, message="Número de caracteres máximo (25)")
    @XmlAttribute(name = "account_iban")
    protected String accountIban;
	@NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "account_id")
    protected String accountId;
    @XmlAttribute(name = "created_at")
    protected String createdAt;
    @NotBlank(message="Campo obrigatório")
    @Size(max = 8, message="Número de caracteres máximo (8)")
    @XmlAttribute(name = "depositer_cc_number")
    protected String depositerCcNumber;
    @NotBlank(message="Campo obrigatório")
    @Size(max = 255, message="Número de caracteres máximo (255)")
    @XmlAttribute(name = "depositer_name")
    protected String depositerName;
    @Size(max = 255, message="Número de caracteres máximo (255)")
    @XmlAttribute(name = "description")
    protected String description;
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "employee_id")
    protected String employeeId;
    @XmlAttribute(name = "id")
    protected String id;
    @XmlAttribute(name = "transaction_id")
    protected String transactionId;
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "type")
    protected String type;
    @NotBlank(message="Campo obrigatório")
    @XmlAttribute(name = "user_id")
    protected String userId;
    @NotBlank(message="Campo obrigatório")
    @Size(max = 255, message="Número de caracteres máximo (255)")
    @XmlAttribute(name = "value")
    protected String value;

    /**
     * Gets the value of the accountIban property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountIban() {
        return accountIban;
    }

    /**
     * Sets the value of the accountIban property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountIban(String value) {
        this.accountIban = value;
    }

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountId(String value) {
        this.accountId = value;
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
     * Gets the value of the depositerCcNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositerCcNumber() {
        return depositerCcNumber;
    }

    /**
     * Sets the value of the depositerCcNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositerCcNumber(String value) {
        this.depositerCcNumber = value;
    }

    /**
     * Gets the value of the depositerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDepositerName() {
        return depositerName;
    }

    /**
     * Sets the value of the depositerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDepositerName(String value) {
        this.depositerName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the employeeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the value of the employeeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmployeeId(String value) {
        this.employeeId = value;
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
     * Gets the value of the transactionId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * Sets the value of the transactionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionId(String value) {
        this.transactionId = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
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
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

}
