
package com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *       &lt;sequence>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Transaction.xsd}inputTransaction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Transaction.xsd}outputTransaction" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Transaction.xsd}DepositTransaction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Transaction.xsd}WithdrawTransaction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Transaction.xsd}PaymentTransaction" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Transaction.xsd}TransferTransaction" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "inputTransaction",
    "outputTransaction",
    "depositTransaction",
    "withdrawTransaction",
    "paymentTransaction",
    "transferTransaction"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<InputTransaction> inputTransaction;
    protected OutputTransaction outputTransaction;
    @XmlElement(name = "DepositTransaction")
    protected List<DepositTransaction> depositTransaction;
    @XmlElement(name = "WithdrawTransaction")
    protected List<WithdrawTransaction> withdrawTransaction;
    @XmlElement(name = "PaymentTransaction")
    protected List<PaymentTransaction> paymentTransaction;
    @XmlElement(name = "TransferTransaction")
    protected List<TransferTransaction> transferTransaction;

    /**
     * Gets the value of the inputTransaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputTransaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputTransaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputTransaction }
     * 
     * 
     */
    public List<InputTransaction> getInputTransaction() {
        if (inputTransaction == null) {
            inputTransaction = new ArrayList<InputTransaction>();
        }
        return this.inputTransaction;
    }

    /**
     * Gets the value of the outputTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link OutputTransaction }
     *     
     */
    public OutputTransaction getOutputTransaction() {
        return outputTransaction;
    }

    /**
     * Sets the value of the outputTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputTransaction }
     *     
     */
    public void setOutputTransaction(OutputTransaction value) {
        this.outputTransaction = value;
    }

    /**
     * Gets the value of the depositTransaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the depositTransaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDepositTransaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DepositTransaction }
     * 
     * 
     */
    public List<DepositTransaction> getDepositTransaction() {
        if (depositTransaction == null) {
            depositTransaction = new ArrayList<DepositTransaction>();
        }
        return this.depositTransaction;
    }

    /**
     * Gets the value of the withdrawTransaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the withdrawTransaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWithdrawTransaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WithdrawTransaction }
     * 
     * 
     */
    public List<WithdrawTransaction> getWithdrawTransaction() {
        if (withdrawTransaction == null) {
            withdrawTransaction = new ArrayList<WithdrawTransaction>();
        }
        return this.withdrawTransaction;
    }

    /**
     * Gets the value of the paymentTransaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the paymentTransaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPaymentTransaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link PaymentTransaction }
     * 
     * 
     */
    public List<PaymentTransaction> getPaymentTransaction() {
        if (paymentTransaction == null) {
            paymentTransaction = new ArrayList<PaymentTransaction>();
        }
        return this.paymentTransaction;
    }

    /**
     * Gets the value of the transferTransaction property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the transferTransaction property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTransferTransaction().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TransferTransaction }
     * 
     * 
     */
    public List<TransferTransaction> getTransferTransaction() {
        if (transferTransaction == null) {
            transferTransaction = new ArrayList<TransferTransaction>();
        }
        return this.transferTransaction;
    }

}
