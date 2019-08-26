
package com.polarising.bootsecurity.soap.employee.tibco.schemas.employee;

import java.util.ArrayList;
import java.util.List;
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
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Employee.xsd}InputEmployee" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.tibco.com/schemas/Bankrising/Schemas/Employee.xsd}OutputEmployee" minOccurs="0"/>
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
    "inputEmployee",
    "outputEmployee"
})
@XmlRootElement(name = "root")
public class Root {

    @XmlElement(name = "InputEmployee")
    protected List<InputEmployee> inputEmployee;
    @XmlElement(name = "OutputEmployee")
    protected OutputEmployee outputEmployee;

    /**
     * Gets the value of the inputEmployee property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the inputEmployee property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInputEmployee().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link InputEmployee }
     * 
     * 
     */
    public List<InputEmployee> getInputEmployee() {
        if (inputEmployee == null) {
            inputEmployee = new ArrayList<InputEmployee>();
        }
        return this.inputEmployee;
    }

    /**
     * Gets the value of the outputEmployee property.
     * 
     * @return
     *     possible object is
     *     {@link OutputEmployee }
     *     
     */
    public OutputEmployee getOutputEmployee() {
        return outputEmployee;
    }

    /**
     * Sets the value of the outputEmployee property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutputEmployee }
     *     
     */
    public void setOutputEmployee(OutputEmployee value) {
        this.outputEmployee = value;
    }

}
