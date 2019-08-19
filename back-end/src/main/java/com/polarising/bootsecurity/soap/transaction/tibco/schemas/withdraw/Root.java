
package com.polarising.bootsecurity.soap.transaction.tibco.schemas.withdraw;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Withdraw.xsd}inputWithdraw" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Withdraw.xsd}outputWithdraw" minOccurs="0"/>
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
    "inputWithdraw",
    "outputWithdraw"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<InputWithdraw> inputWithdraw;
    protected OutputWithdraw outputWithdraw;

    /**
     * Gets the value of the inputWithdraw property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputWithdraw property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputWithdraw().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputWithdraw }
     * 
     * 
     */
    public List<InputWithdraw> getInputWithdraw() {
        if (inputWithdraw == null) {
            inputWithdraw = new ArrayList<InputWithdraw>();
        }
        return this.inputWithdraw;
    }

    /**
     * Gets the value of the outputWithdraw property.
     * 
     * @return
     *     possible object is
     *     {@link OutputWithdraw }
     *     
     */
    public OutputWithdraw getOutputWithdraw() {
        return outputWithdraw;
    }

    /**
     * Sets the value of the outputWithdraw property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputWithdraw }
     *     
     */
    public void setOutputWithdraw(OutputWithdraw value) {
        this.outputWithdraw = value;
    }

}
