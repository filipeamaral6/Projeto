package com.polarising.bootsecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.polarising.bootsecurity.soap.client.example.xmlns._1564670621329.ClientService;
import com.polarising.bootsecurity.soap.client.tibco.schemas.client.InputClient;
import com.polarising.bootsecurity.soap.client.tibco.schemas.client.OutputClient;
import com.polarising.bootsecurity.soap.client.tibco.schemas.client.Root;
import com.polarising.bootsecurity.soap.client.tibco.schemas.getbyclientcc.GetByClientCC;
import com.polarising.bootsecurity.soap.client.tibco.schemas.getbyid.GetById;

@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class ClientController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	// Add Client
	@PostMapping("clients/add")
	public ResponseEntity<Object> AddClient(@Valid @RequestBody InputClient inputClient, BindingResult result) {

		if (!result.hasErrors()) {

			inputClient.setLoginPassword(passwordEncoder.encode(inputClient.getLoginPassword()));
			inputClient.setTransactionPassword(passwordEncoder.encode(inputClient.getTransactionPassword()));

			ClientService clientService = new ClientService();

			OutputClient message = clientService.getPortTypeCreateClientEndpoint1().operation(inputClient);
			
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
	// Get Clients
	@GetMapping("clients")
	public ResponseEntity<List<Object>> getClients() {

		ClientService clientService = new ClientService();
		Root getClients = clientService.getPortTypeGetAllClientsEndpoint1().operation();

		List<Object> message = new ArrayList<Object>();

		if (!getClients.getInputClient().isEmpty()) {
			for (InputClient client : getClients.getInputClient()) {
				message.add(client);
			}
		} else {
			message.add(getClients.getOutputClient());
			return new ResponseEntity<List<Object>>(message, HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<List<Object>>(message, HttpStatus.OK);
	}

	// Get Client by Id
	@GetMapping("clients/id/{id}")
	public ResponseEntity<Object> getClientById(@PathVariable String id) {

		ClientService clientService = new ClientService();
		GetById getById = new GetById();
		getById.setId(id);
		Root getClientById = clientService.getPortTypeGetClientByIdEndpoint1().operation(getById);

		if (getClientById.getInputClient().isEmpty()) {
			return new ResponseEntity<Object>(getClientById.getOutputClient(), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Object>(getClientById.getInputClient(), HttpStatus.OK);
		}

	}

	// Get Client by CC
	@GetMapping("clients/cc/{cc}")
	public ResponseEntity<Object> getClientByCC(@PathVariable String cc) {

		ClientService clientService = new ClientService();
		GetByClientCC getByCC = new GetByClientCC();
		getByCC.setClientCc(cc);
		Root getClientByCC = clientService.getPortTypeGetClientByCcEndpoint1().operation(getByCC);

		if (getClientByCC.getInputClient().isEmpty()) {
			return new ResponseEntity<Object>(getClientByCC.getOutputClient(), HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<Object>(getClientByCC.getInputClient(), HttpStatus.OK);
		}
	}

	// Update Client
	@PutMapping("clients/update")
	public ResponseEntity<Object> updateClient(@Valid @RequestBody InputClient inputClient, BindingResult result) {

		if (!result.hasErrors()) {

			ClientService clientService = new ClientService();
			OutputClient message = clientService.getPortTypeUpdateClientEndpoint1().operation(inputClient);
			
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
}