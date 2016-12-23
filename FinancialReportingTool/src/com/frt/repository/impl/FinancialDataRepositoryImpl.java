package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.FinancialData;
import com.frt.model.ManagementTeam;
import com.frt.repository.FinancialDataRepository;
import com.frt.repository.ManagementTeamRepositry;

@Repository
public class FinancialDataRepositoryImpl implements FinancialDataRepository{

	@Autowired
	public SessionFactory factory;

	@Override
	public void saveFinanceData(FinancialData financialData) {
		
		factory.getCurrentSession().saveOrUpdate(financialData);
	}

	@Override
	public FinancialData getaddFinanceDataById(Long id) {
		
		FinancialData financialData = (FinancialData) factory.getCurrentSession().get(FinancialData.class, id);
		return financialData;
	}

	@Override
	public List<FinancialData> getAlladdFinanceData() {
		
		List<FinancialData> financialDataList = new ArrayList<>();
		financialDataList = factory.getCurrentSession().createQuery("from FinancialData").list();
		return financialDataList;
	}



}
