
package com.polarising.bootsecurity.soap.transaction.tibco.schemas.transfer;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Transfer.xsd}inputTransfer" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Transfer.xsd}outputTransfer" minOccurs="0"/>
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
    "inputTransfer",
    "outputTransfer"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<InputTransfer> inputTransfer;
    protected OutputTransfer outputTransfer;

    /**
     * Gets the value of the inputTransfer property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputTransfer property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputTransfer().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputTransfer }
     * 
     * 
     */
    public List<InputTransfer> getInputTransfer() {
        if (inputTransfer == null) {
            inputTransfer = new ArrayList<InputTransfer>();
        }
        return this.inputTransfer;
    }

    /**
     * Gets the value of the outputTransfer property.
     * 
     * @return
     *     possible object is
     *     {@link OutputTransfer }
     *     
     */
    public OutputTransfer getOutputTransfer() {
        return outputTransfer;
    }

    /**
     * Sets the value of the outputTransfer property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputTransfer }
     *     
     */
    public void setOutputTransfer(OutputTransfer value) {
        this.outputTransfer = value;
    }

}
