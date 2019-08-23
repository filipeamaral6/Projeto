package com.polarising.bootsecurity.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.soap.client_account.example.xmlns._1566480228153.ClientAccountService;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.account.RootClientAccount;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.client.RootAccountClient;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.getbyid.GetById;




@RestController
@RequestMapping("/")
@CrossOrigin
public class ClientAccountController {

	// Get Clients by Account_id
	@GetMapping("clients/accountClients/{id}")
	public ResponseEntity<Object> getClientAccounts(@PathVariable String id) {

		ClientAccountService clientAccountService = new ClientAccountService();
		GetById getById = new GetById();
		getById.setId(id);
		RootAccountClient getClientsByAccountId = clientAccountService.getPortTypeGetAccountClientsEndpoint1().operation(getById);
		

		if (getClientsByAccountId.getInputClient().isEmpty()) {
			return new ResponseEntity<Object>(getClientsByAccountId.getOutputClient(), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Object>(getClientsByAccountId.getInputClient(), HttpStatus.OK);
		}
		
	
	}
	
	// Get Accounts by user_id
	@GetMapping("accounts/clientAccounts/{id}")
	public ResponseEntity<Object> getAccountClients(@PathVariable String id) {

		ClientAccountService clientAccountService = new ClientAccountService();
		GetById getById = new GetById();
		getById.setId(id);
		RootClientAccount getAccountsByClientId = clientAccountService.getPortTypeGetClientAccountsEndpoint1().operation(getById);
		
		if (getAccountsByClientId.getInputAccount().isEmpty()) {
			return new ResponseEntity<Object>(getAccountsByClientId.getOutputAccount(), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Object>(getAccountsByClientId.getInputAccount(), HttpStatus.OK);
		}
	}
}
