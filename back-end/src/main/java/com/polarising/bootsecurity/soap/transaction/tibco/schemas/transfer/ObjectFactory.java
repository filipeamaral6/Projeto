
package com.polarising.bootsecurity.soap.transaction.tibco.schemas.transfer;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tibco.schemas.bankrising.schemas.transfer package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tibco.schemas.bankrising.schemas.transfer
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InputTransfer }
     * 
     */
    public InputTransfer createInputTransfer() {
        return new InputTransfer();
    }

    /**
     * Create an instance of {@link OutputTransfer }
     * 
     */
    public OutputTransfer createOutputTransfer() {
        return new OutputTransfer();
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

}
