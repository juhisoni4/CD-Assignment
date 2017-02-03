package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.FinancialData.Month;
import com.frt.repository.FinancialDataRepository;

@Repository
public class FinancialDataRepositoryImpl implements FinancialDataRepository {

	@Autowired
	SessionFactory factory;

	@Override
	public void saveFinanceData(FinancialData financialData) {

		factory.getCurrentSession().saveOrUpdate(financialData);
	}

	@Override
	public FinancialData getaddFinanceDataById(Long id) {

		FinancialData financialData = (FinancialData) factory
				.getCurrentSession().get(FinancialData.class, id);
		return financialData;
	}

	@Override
	public List<FinancialData> getAlladdFinanceData() {

		List<FinancialData> financialDataList = new ArrayList<>();
		financialDataList = factory.getCurrentSession()
				.createQuery("from FinancialData").list();
		return financialDataList;
	}
	
	public List<FinancialData> getFinanceDataByClient(Client client, Month month1, Month month2,String typeOfData,long year){
		
			
		//System.out.println(Month.valueOf(month1));
		//System.out.println(Month.valueOf(month2));
		System.out.println(client.getId());
		System.out.println(year);
		Criteria criteria = factory.getCurrentSession().createCriteria(FinancialData.class);
		criteria.add(Restrictions.eq("client.id", client.getId()));		
		criteria.add(Restrictions.eq("year", year));
		criteria.add(Restrictions.between("month", month1,month2)); 
		//criteria.add(Restrictions.le("month", Month.valueOf(month2)));		
		List<FinancialData> financialDataList = criteria.list();
		
		for(FinancialData financialData:financialDataList){
			System.out.println(financialData);
		}
		
		return financialDataList;
	}
	
	public List<FinancialData> getFinancialDataByClient(Client client){
		
		List<FinancialData> financialDataList = null;					
		Criteria criteria = factory.getCurrentSession().createCriteria(FinancialData.class);
		criteria.add(Restrictions.eq("client.id", client.getId()));		
		financialDataList = criteria.list();	
		
		return financialDataList;
	}

	public List<FinancialData> getRevenueByProjectManager(String month1,
			String month2, long year,Client client
			) {

		String hql = "from FinancialData WHERE month BETWEEN :month1 AND :month2 AND year = :year AND  client.id = :id";
				
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("id",client.getId());
		query.setParameter("month1", Month.valueOf(month1));
		query.setParameter("month2", Month.valueOf(month2));
		query.setParameter("year", year);		
		List<FinancialData> financeDatalist = query.list();
		System.out.println(financeDatalist);

		return financeDatalist;
	}
	
	public List<FinancialData> getFinancialDataOfYear(long year1, long year2){
		
		Criteria criteria = factory.getCurrentSession().createCriteria(FinancialData.class);		
		criteria.add(Restrictions.between("year", year1, year2)); 				
		List<FinancialData> financialDataList = criteria.list();		
		return financialDataList;
		
	}

	public List<FinancialData> search(FinancialData FinancialData) {

		Example FinancialDataExample = Example.create(FinancialData);
		List<FinancialData> FinancialDataList = factory.getCurrentSession()
				.createCriteria(FinancialData.class).add(FinancialDataExample).list();

		return FinancialDataList;

	}

}
