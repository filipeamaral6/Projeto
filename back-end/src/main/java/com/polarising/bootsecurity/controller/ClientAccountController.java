package com.polarising.bootsecurity.controller;

import java.util.HashMap;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.polarising.bootsecurity.soap.client_account.example.xmlns._1566480228153.ClientAccountService;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.account.RootClientAccount;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.accountclient.InputAccountClient;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.accountclient.OutputAccountClient;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.client.RootAccountClient;
import com.polarising.bootsecurity.soap.client_account.tibco.schemas.bankrising.schemas.getbyid.GetById;




@RestController
@RequestMapping("/")
@CrossOrigin
public class ClientAccountController {
	
	
		// Add Client to Account
		@PostMapping("addClient")
		public ResponseEntity<Object> AddClient(@Valid @RequestBody InputAccountClient inputAccountClient, BindingResult result) {
	
			if (!result.hasErrors()) {
	
				
				ClientAccountService clientAccountService = new ClientAccountService();
	
				OutputAccountClient message = clientAccountService.getPortTypeAddClientToAccountEndpoint1().operation(inputAccountClient);
				
				if(message.getMessage().startsWith("Erro")) {
					return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<Object>(message, HttpStatus.OK);
	
			}
			
			HashMap<String, String> error = new HashMap<>();
			error.put("field", result.getFieldError().getField());
			error.put("message", result.getFieldError().getDefaultMessage());
			
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		}
	
		
		//Delete Client from Account
		@PostMapping("deleteClient")
		public ResponseEntity<Object> DeleteClient(@Valid @RequestBody InputAccountClient inputAccountClient, BindingResult result) {

			if (!result.hasErrors()) {

				
				ClientAccountService clientAccountService = new ClientAccountService();

				OutputAccountClient message = clientAccountService.getPortTypeDeleteAccountClientEndpoint1().operation(inputAccountClient);
				
				if(message.getMessage().startsWith("Erro")) {
					return new ResponseEntity<Object>(message, HttpStatus.BAD_REQUEST);
				}
				return new ResponseEntity<Object>(message, HttpStatus.OK);

			}
		
		
			HashMap<String, String> error = new HashMap<>();
			error.put("field", result.getFieldError().getField());
			error.put("message", result.getFieldError().getDefaultMessage());
			
			return new ResponseEntity<Object>(error, HttpStatus.BAD_REQUEST);
		}

	// Get Clients by Account_id
	@GetMapping("accountClients/{id}")
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
	@GetMapping("clientAccounts/{id}")
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
