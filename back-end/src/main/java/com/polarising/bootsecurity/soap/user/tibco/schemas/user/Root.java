
package com.polarising.bootsecurity.soap.user.tibco.schemas.user;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/tibco/Schemas/Schema.xsd}inputUsers" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/tibco/Schemas/Schema.xsd}outputUsers" minOccurs="0"/>
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
    "inputUsers",
    "outputUsers"
})
@XmlRootElement(name = "root")
public class Root {

    protected List<InputUsers> inputUsers;
    protected OutputUsers outputUsers;

    /**
     * Gets the value of the inputUsers property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputUsers property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputUsers().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputUsers }
     * 
     * 
     */
    public List<InputUsers> getInputUsers() {
        if (inputUsers == null) {
            inputUsers = new ArrayList<InputUsers>();
        }
        return this.inputUsers;
    }

    /**
     * Gets the value of the outputUsers property.
     * 
     * @return
     *     possible object is
     *     {@link OutputUsers }
     *     
     */
    public OutputUsers getOutputUsers() {
        return outputUsers;
    }

    /**
     * Sets the value of the outputUsers property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputUsers }
     *     
     */
    public void setOutputUsers(OutputUsers value) {
        this.outputUsers = value;
    }

}
