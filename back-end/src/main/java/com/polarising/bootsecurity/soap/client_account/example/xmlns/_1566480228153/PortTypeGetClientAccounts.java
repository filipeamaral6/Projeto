
package com.polarising.bootsecurity.soap.client_account.example.xmlns._1566480228153;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.account.InputAccount;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.account.RootClientAccount;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.getbyid.GetById;



/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebService(name = "PortType_GetClientAccounts", targetNamespace = "http://xmlns.example.com/1566480228153")
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
@XmlSeeAlso({
	com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.account.ObjectFactory.class,
	com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.client.ObjectFactory.class,
	com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.getbyid.ObjectFactory.class
})
public interface PortTypeGetClientAccounts {


    /**
     * 
     * @param input
     * @return
     *     returns com.tibco.schemas.bankrising.schemas.account.InputAccount
     */
    @WebMethod(operationName = "Operation", action = "/Client_Account/Service.serviceagent/PortType_GetClientAccountsEndpoint1/Operation")
    @WebResult(name = "inputAccount", targetNamespace = "http://www.tibco.com/schemas/Bankrising/Schemas/Account.xsd", partName = "output")
    public RootClientAccount operation(
        @WebParam(name = "getById", targetNamespace = "http://www.tibco.com/schemas/Bankrising/Schemas/getById.xsd", partName = "input")
        GetById input);

}
