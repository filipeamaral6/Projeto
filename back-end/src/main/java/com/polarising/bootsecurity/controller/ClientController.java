package com.polarising.bootsecurity.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.model.Client;
import com.polarising.bootsecurity.soap.client.example.xmlns._1564670621329.Service;
import com.polarising.bootsecurity.soap.client.tibco.schemas.client.InputClient;
import com.polarising.bootsecurity.soap.client.tibco.schemas.client.OutputClient;
import com.polarising.bootsecurity.soap.client.tibco.schemas.client.Root;
import com.polarising.bootsecurity.soap.client.tibco.schemas.getbyclientcc.GetByClientCC;
import com.polarising.bootsecurity.soap.client.tibco.schemas.getbyid.GetById;

@RestController
@RequestMapping("/")
@CrossOrigin
public class ClientController {

	// Add Client
	@PostMapping("clients/add")
	public Object AddClient(@RequestBody InputClient inputClient) {

		@Valid
		Client client = new Client(inputClient);
		
		Service clientService = new Service();

		OutputClient message = clientService.getPortTypeUpdateClientEndpoint1().operation(inputClient);

		return message;

	}
	
	// Get Clients
	@GetMapping("clients")
	public List<Object> getClients() {

		Service clientService = new Service();
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

		Service clientService = new Service();
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

		Service clientService = new Service();
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
	public Object updateClient(@RequestBody InputClient client) {

		Service clientService = new Service();

		OutputClient updateClient = clientService.getPortTypeUpdateClientEndpoint1().operation(client);

		return updateClient;

	}

	// Deactivate Client
	@PutMapping("clients/deactivate")
	public Object deactivateClient(@RequestBody InputClient client) {

		Service clientService = new Service();

		client.setStatus("INACTIVE");
		OutputClient updateClient = clientService.getPortTypeUpdateClientEndpoint1().operation(client);

		return updateClient;

	}

	// Activate client
	@PutMapping("clients/activate")
	public Object activateClient(@RequestBody InputClient client) {

		Service clientService = new Service();

		client.setStatus("ACTIVE");
		OutputClient updateClient = clientService.getPortTypeUpdateClientEndpoint1().operation(client);

		return updateClient;

	}
}