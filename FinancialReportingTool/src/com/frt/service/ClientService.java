package com.frt.service;

import java.util.List;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.FinancialData.Month;

public interface ClientService {

	public void saveClient(Client client);

	public Client getClientById(Long id);

	public List<Client> getAllClient();

	List<Client> search(Client client);
	
	public List<FinancialData> getRevenueByClientName(Client client, Month month1, Month month2,String typeOfData);
}
