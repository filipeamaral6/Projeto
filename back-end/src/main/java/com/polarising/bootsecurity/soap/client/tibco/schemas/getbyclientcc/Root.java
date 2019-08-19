
package com.polarising.bootsecurity.soap.client.tibco.schemas.getbyclientcc;

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
 *         &lt;element ref="{http://www.tibco.com/schemas/tibco/Schemas/GetByClientCC.xsd}GetByClientCC"/>
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
    "getByClientCC"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(name = "GetByClientCC", required = true)
    protected GetByClientCC getByClientCC;

    /**
     * Gets the value of the getByClientCC property.
     * 
     * @return
     *     possible object is
     *     {@link GetByClientCC }
     *     
     */
    public GetByClientCC getGetByClientCC() {
        return getByClientCC;
    }

    /**
     * Sets the value of the getByClientCC property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetByClientCC }
     *     
     */
    public void setGetByClientCC(GetByClientCC value) {
        this.getByClientCC = value;
    }

}
