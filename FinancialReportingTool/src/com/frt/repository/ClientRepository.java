package com.frt.repository;

import java.util.List;

import com.frt.model.Client;

public interface ClientRepository {

	public void saveClient(Client client);
	
	public Client getClientById(Long id);
	
	public List<Client> getAllClient();
}
