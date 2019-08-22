
package com.polarising.bootsecurity.soap.transaction.tibco.schemas.deposit;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Deposit.xsd}inputDeposit" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Deposit.xsd}outputDeposit" minOccurs="0"/>
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
    "inputDeposit",
    "outputDeposit"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<InputDeposit> inputDeposit;
    protected OutputDeposit outputDeposit;

    /**
     * Gets the value of the inputDeposit property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputDeposit property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputDeposit().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputDeposit }
     * 
     * 
     */
    public List<InputDeposit> getInputDeposit() {
        if (inputDeposit == null) {
            inputDeposit = new ArrayList<InputDeposit>();
        }
        return this.inputDeposit;
    }

    /**
     * Gets the value of the outputDeposit property.
     * 
     * @return
     *     possible object is
     *     {@link OutputDeposit }
     *     
     */
    public OutputDeposit getOutputDeposit() {
        return outputDeposit;
    }

    /**
     * Sets the value of the outputDeposit property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputDeposit }
     *     
     */
    public void setOutputDeposit(OutputDeposit value) {
        this.outputDeposit = value;
    }

}
