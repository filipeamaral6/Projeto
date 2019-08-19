package com.polarising.bootsecurity.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Object AddClient(@Valid @RequestBody InputClient inputClient, BindingResult result) {

		if (!result.hasErrors()) {

			inputClient.setLoginPassword(passwordEncoder.encode(inputClient.getLoginPassword()));
			inputClient.setTransactionPassword(passwordEncoder.encode(inputClient.getTransactionPassword()));

			ClientService clientService = new ClientService();

			OutputClient message = clientService.getPortTypeCreateClientEndpoint1().operation(inputClient);
			return message;

		}

		HashMap<String, String> error = new HashMap<>();
		error.put("field", result.getFieldError().getField());
		error.put("message", result.getFieldError().getDefaultMessage());

		return error;
	}

	// Get Clients
	@GetMapping("clients")
	public List<Object> getClients() {

		ClientService clientService = new ClientService();
		Root getClients = clientService.getPortTypeGetAllClientsEndpoint1().operation();

		List<Object> message = new ArrayList<Object>();

		if (!getClients.getInputClient().isEmpty()) {
			for (InputClient client : getClients.getInputClient()) {
				message.add(client);
			}
		} else {
			message.add(getClients.getOutputClient());
		}

		return message;
	}

	// Get Client by Id
	@GetMapping("clients/id/{id}")
	public Object getClientById(@PathVariable String id) {

		ClientService clientService = new ClientService();
		GetById getById = new GetById();
		getById.setId(id);
		Root getClientById = clientService.getPortTypeGetClientByIdEndpoint1().operation(getById);

		if (getClientById.getInputClient().isEmpty()) {
			return getClientById.getOutputClient();
		} else {
			return getClientById.getInputClient();
		}

	}

	// Get Client by CC
	@GetMapping("clients/cc/{cc}")
	public Object getClientByCC(@PathVariable String cc) {

		ClientService clientService = new ClientService();
		GetByClientCC getByCC = new GetByClientCC();
		getByCC.setClientCc(cc);
		Root getClientByCC = clientService.getPortTypeGetClientByCcEndpoint1().operation(getByCC);

		if (getClientByCC.getInputClient().isEmpty()) {
			return getClientByCC.getOutputClient();
		} else {
			return getClientByCC.getInputClient();
		}
	}

	// Update Client
	@PutMapping("clients/update")
	public Object updateClient(@Valid @RequestBody InputClient inputClient, BindingResult result) {

		if (!result.hasErrors()) {

			ClientService clientService = new ClientService();

			OutputClient message = clientService.getPortTypeUpdateClientEndpoint1().operation(inputClient);

			return message;

		}

		HashMap<String, String> error = new HashMap<>();
		error.put("field", result.getFieldError().getField());
		error.put("message", result.getFieldError().getDefaultMessage());

		return error;

	}
}