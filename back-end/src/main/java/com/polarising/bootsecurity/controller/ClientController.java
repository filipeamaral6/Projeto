package com.polarising.bootsecurity.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.polarising.bootsecurity.soap.client.example.xmlns._1564670621329.Service;
import com.polarising.bootsecurity.soap.client.tibco.schemas.client.InputClient;
import com.polarising.bootsecurity.soap.client.tibco.schemas.client.Root;
import com.polarising.bootsecurity.soap.client.tibco.schemas.getbyid.GetById;
import com.polarising.bootsecurity.soap.client.tibco.schemas.getbyid.RootGetById;
import com.polarising.bootsecurity.soap.client.tibco.schemas.getbyid.UserId;

@RestController
@RequestMapping("/")
@CrossOrigin
public class ClientController {
	
	
	@GetMapping("clients")
    public List<Object> getClients() {	
		
		Service clientService = new Service();
		Root getClients = clientService.getPortTypeGetAllClientsEndpoint1().operation();
    	
		List<Object> message = new ArrayList<Object>();
		
		if(!getClients.getInputClient().isEmpty()) {
			for (InputClient client : getClients.getInputClient()) {
				message.add(client);
			}
		} else {
			message.add(getClients.getOutputClient());
		}
		
		return message;
    }
	
//	@GetMapping("clients/{id}")
//	public Object getClient(@PathVariable String id) {
//		Service clientService = new Service();
//		
//
//		
//	}
	
}