package com.frt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.frt.model.Client;
import com.frt.service.ClientService;

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
