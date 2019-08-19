
package com.polarising.bootsecurity.soap.transaction.tibco.schemas.payment;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Payment.xsd}inputPayment" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Payment.xsd}outputPayment" minOccurs="0"/>
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
    "inputPayment",
    "outputPayment"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<InputPayment> inputPayment;
    protected OutputPayment outputPayment;

    /**
     * Gets the value of the inputPayment property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputPayment property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputPayment().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputPayment }
     * 
     * 
     */
    public List<InputPayment> getInputPayment() {
        if (inputPayment == null) {
            inputPayment = new ArrayList<InputPayment>();
        }
        return this.inputPayment;
    }

    /**
     * Gets the value of the outputPayment property.
     * 
     * @return
     *     possible object is
     *     {@link OutputPayment }
     *     
     */
    public OutputPayment getOutputPayment() {
        return outputPayment;
    }

    /**
     * Sets the value of the outputPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputPayment }
     *     
     */
    public void setOutputPayment(OutputPayment value) {
        this.outputPayment = value;
    }

}
