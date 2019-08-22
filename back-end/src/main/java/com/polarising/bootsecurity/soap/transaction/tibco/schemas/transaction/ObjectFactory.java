
package com.polarising.bootsecurity.soap.transaction.tibco.schemas.transaction;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.tibco.schemas.bankrising.schemas.transaction package. 
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
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.tibco.schemas.bankrising.schemas.transaction
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PaymentTransaction }
     * 
     */
    public PaymentTransaction createPaymentTransaction() {
        return new PaymentTransaction();
    }

    /**
     * Create an instance of {@link WithdrawTransaction }
     * 
     */
    public WithdrawTransaction createWithdrawTransaction() {
        return new WithdrawTransaction();
    }

    /**
     * Create an instance of {@link DepositTransaction }
     * 
     */
    public DepositTransaction createDepositTransaction() {
        return new DepositTransaction();
    }

    /**
     * Create an instance of {@link RootTransaction }
     * 
     */
    public RootTransaction createRoot() {
        return new RootTransaction();
    }

    /**
     * Create an instance of {@link InputTransaction }
     * 
     */
    public InputTransaction createInputTransaction() {
        return new InputTransaction();
    }

    /**
     * Create an instance of {@link OutputTransaction }
     * 
     */
    public OutputTransaction createOutputTransaction() {
        return new OutputTransaction();
    }

    /**
     * Create an instance of {@link TransferTransaction }
     * 
     */
    public TransferTransaction createTransferTransaction() {
        return new TransferTransaction();
    }

}
