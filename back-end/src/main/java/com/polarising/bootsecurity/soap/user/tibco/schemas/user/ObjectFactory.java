
package com.polarising.bootsecurity.soap.user.tibco.schemas.user;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tibco.schemas.tibco.schemas.schema package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tibco.schemas.tibco.schemas.schema
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link InputUsers }
     * 
     */
    public InputUsers createInputUsers() {
        return new InputUsers();
    }

    /**
     * Create an instance of {@link Root }
     * 
     */
    public Root createRoot() {
        return new Root();
    }

    /**
     * Create an instance of {@link OutputUsers }
     * 
     */
    public OutputUsers createOutputUsers() {
        return new OutputUsers();
    }

}
