
package com.polarising.bootsecurity.soap.employee.tibco.schemas.getbyid;


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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/getById.xsd}getById"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/getById.xsd}user_id"/>
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
    "getById",
    "userId"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(required = true)
    protected GetById getById;
    @XmlElement(name = "user_id", required = true)
    protected UserId userId;

    /**
     * Gets the value of the getById property.
     * 
     * @return
     *     possible object is
     *     {@link GetById }
     *     
     */
    public GetById getGetById() {
        return getById;
    }

    /**
     * Sets the value of the getById property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetById }
     *     
     */
    public void setGetById(GetById value) {
        this.getById = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link UserId }
     *     
     */
    public UserId getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserId }
     *     
     */
    public void setUserId(UserId value) {
        this.userId = value;
    }

}
