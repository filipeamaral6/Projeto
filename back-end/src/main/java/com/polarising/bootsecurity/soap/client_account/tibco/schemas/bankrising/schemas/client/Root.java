
package com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.client;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Client.xsd}inputClient" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Client.xsd}outputClient" minOccurs="0"/>
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
    "inputClient",
    "outputClient"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<InputClient> inputClient;
    protected OutputClient outputClient;

    /**
     * Gets the value of the inputClient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputClient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputClient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputClient }
     * 
     * 
     */
    public List<InputClient> getInputClient() {
        if (inputClient == null) {
            inputClient = new ArrayList<InputClient>();
        }
        return this.inputClient;
    }

    /**
     * Gets the value of the outputClient property.
     * 
     * @return
     *     possible object is
     *     {@link OutputClient }
     *     
     */
    public OutputClient getOutputClient() {
        return outputClient;
    }

    /**
     * Sets the value of the outputClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputClient }
     *     
     */
    public void setOutputClient(OutputClient value) {
        this.outputClient = value;
    }

}
