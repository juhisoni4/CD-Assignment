package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.Client;
import com.frt.repository.ClientRepository;

@Repository
public class ClientRepositoryImpl implements ClientRepository {

	@Autowired
	public SessionFactory factory;

	@Override
	public void saveClient(Client client) {

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

	@Override
	/*public List<Client> search(Client client) {

		List<Client> clientList;

		StringBuilder hql = new StringBuilder("from Client WHERE display=true");

		if (client.getClientName() != null && !client.getClientName().equals("")) {
			hql.append(" AND clientName like :clientName");
		}

		if (client.getDomain() != null && client.getDomain().equals("")) {
			hql.append(" AND domain like :domain");
		}

		Query query = factory.getCurrentSession().createQuery(hql.toString());

		if (client.getClientName() != null && !client.getClientName().equals("")) {
			query.setParameter("clientName", client.getClientName());
		}

		if (client.getDomain() != null && client.getDomain().equals("")) {
			query.setParameter("domain", client.getDomain());
		}

		clientList = query.list();

		return clientList;

	}*/

	    public List<Client> search(Client client){
		
		List<Client> clientList;
		
		Criteria criteria = factory.getCurrentSession().createCriteria(Client.class);
		
		if(client.getClientName()!=null && !client.getClientName().equals("")){
			criteria.add(Restrictions.eq("clientName", client.getClientName()));
		}
		
		if(client.getDomain()!=null && client.getDomain().equals("")){
			criteria.add(Restrictions.eq("domain", client.getDomain()));
		}
		
		clientList = criteria.list();
		
		return clientList;			
        
	}

}
