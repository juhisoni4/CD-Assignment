package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.Client;
import com.frt.repository.ClientRepository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

	@Autowired
	public SessionFactory factory;
	
	@Override
	public void saveClient(Client client){
		
		factory.getCurrentSession().saveOrUpdate(client);

	}

	@Override
	public Client getClientById(Long id) {
		
		Client client = (Client) factory.getCurrentSession().get(Client.class, id);
		return client;
	}

	@Override
	public List<Client> getAllClient() {
		
		List<Client> clientList = new ArrayList<>();
		clientList = factory.getCurrentSession().createQuery("from Client").list();
		return clientList;
	}

}
