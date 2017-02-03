package com.frt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.FinancialData.Month;
import com.frt.repository.ClientRepository;
import com.frt.service.ClientService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class ClientServiceImpl implements ClientService {

	@Autowired
	public ClientRepository clientRepository;

	@Override
	public void saveClient(Client client) {

		clientRepository.saveClient(client);
	}

	@Override
	public Client getClientById(Long id) {

		Client client = clientRepository.getClientById(id);
		return client;
	}

	@Override
	public List<Client> getAllClient() {

		List<Client> clientList = new ArrayList<>();
		clientList = clientRepository.getAllClient();
		return clientList;
	}

	@Override
	public List<Client> search(Client client) {
		return clientRepository.search(client);
	}

	@Override
	public List<FinancialData> getRevenueByClientName(Client client,
			Month month1, Month month2, String typeOfData) {
		
		return clientRepository.getRevenueByClientName(client, month1, month2, typeOfData);
	}

}
