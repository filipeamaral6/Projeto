
package com.polarising.bootsecurity.soap.client.tibco.schemas.client;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tibco.schemas.bankrising.schemas.client package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tibco.schemas.bankrising.schemas.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link OutputClient }
     * 
     */
    public OutputClient createOutputClient() {
        return new OutputClient();
    }

    /**
     * Create an instance of {@link InputClient }
     * 
     */
    public InputClient createInputClient() {
        return new InputClient();
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

}
