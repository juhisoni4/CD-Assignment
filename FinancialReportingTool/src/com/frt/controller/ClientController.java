package com.frt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frt.model.Client;
import com.frt.service.ClientService;

@RestController
@RequestMapping(value="/client")
public class ClientController {

	@Autowired
	ClientService clientService;
	
	public void saveClient(Client client){
		
		clientService.saveClient(client);
	}
	
	public void getClientById(Long id){
		
		Client client = clientService.getClientById(id);
	}
	
	public void getAllClient(){
		
		List<Client> clientList = clientService.getAllClient();
	}
}
