package com.frt.service;

import java.util.List;

import com.frt.model.Client;

public interface ClientService {

	public void saveClient(Client client);

	public Client getClientById(Long id);

	public List<Client> getAllClient();
}
