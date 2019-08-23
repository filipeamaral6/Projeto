
package com.polarising.bootsecurity.soap.account.tibco.schemas.account;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Account.xsd}inputAccount" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Account.xsd}outputAccount" maxOccurs="unbounded" minOccurs="0"/>
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
    "inputAccount",
    "outputAccount"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<InputAccount> inputAccount;
    protected List<OutputAccount> outputAccount;

    /**
     * Gets the value of the inputAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputAccount }
     * 
     * 
     */
    public List<InputAccount> getInputAccount() {
        if (inputAccount == null) {
            inputAccount = new ArrayList<InputAccount>();
        }
        return this.inputAccount;
    }

    /**
     * Gets the value of the outputAccount property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the outputAccount property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getOutputAccount().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link OutputAccount }
     * 
     * 
     */
    public List<OutputAccount> getOutputAccount() {
        if (outputAccount == null) {
            outputAccount = new ArrayList<OutputAccount>();
        }
        return this.outputAccount;
    }

}
