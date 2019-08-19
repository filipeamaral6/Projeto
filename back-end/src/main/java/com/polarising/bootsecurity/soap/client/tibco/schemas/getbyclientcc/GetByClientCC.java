
package com.polarising.bootsecurity.soap.client.tibco.schemas.getbyclientcc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="client_cc" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "GetByClientCC")
public class GetByClientCC {

    @XmlAttribute(name = "client_cc")
    protected String clientCc;

    /**
     * Gets the value of the clientCc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getClientCc() {
        return clientCc;
    }

    /**
     * Sets the value of the clientCc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setClientCc(String value) {
        this.clientCc = value;
    }

}
