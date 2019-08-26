
package com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.accountclient;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/AccountClient.xsd}inputAccountClient" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/AccountClient.xsd}outputAccountClient" minOccurs="0"/>
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
    "inputAccountClient",
    "outputAccountClient"
})
@XmlRootElement(name = "root")
public class RootAccountsClients {

    protected List<InputAccountClient> inputAccountClient;
    protected OutputAccountClient outputAccountClient;

    /**
     * Gets the value of the inputAccountClient property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputAccountClient property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputAccountClient().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputAccountClient }
     * 
     * 
     */
    public List<InputAccountClient> getInputAccountClient() {
        if (inputAccountClient == null) {
            inputAccountClient = new ArrayList<InputAccountClient>();
        }
        return this.inputAccountClient;
    }

    /**
     * Gets the value of the outputAccountClient property.
     * 
     * @return
     *     possible object is
     *     {@link OutputAccountClient }
     *     
     */
    public OutputAccountClient getOutputAccountClient() {
        return outputAccountClient;
    }

    /**
     * Sets the value of the outputAccountClient property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputAccountClient }
     *     
     */
    public void setOutputAccountClient(OutputAccountClient value) {
        this.outputAccountClient = value;
    }

}
