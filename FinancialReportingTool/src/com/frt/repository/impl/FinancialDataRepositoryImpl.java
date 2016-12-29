package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.frt.model.FinancialData;
import com.frt.repository.FinancialDataRepository;

@Repository
public class FinancialDataRepositoryImpl implements FinancialDataRepository {

	@Autowired
	public SessionFactory factory;

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

	public Map<String, String> getRevenueByProjectManager(String projectManager) {
		
		Double totalRevenue = 0.00;
		String month = "";
					
 		Criteria criteria = factory.getCurrentSession().createCriteria(
				FinancialData.class);
		criteria.add(Restrictions.eq("projectManager", projectManager));
		List<FinancialData> list = criteria.list();
		for (FinancialData data : list) {
			month = data.getMonth();
			Double revenueData = data.getActualRevenue();
			totalRevenue = totalRevenue + revenueData;
			System.out.println(totalRevenue);
		}
		
		String totalRevenueStr = Double.toString(totalRevenue);
		Map<String, String>  revenueData = new HashMap<>();
		revenueData.put("Month",month);
		revenueData.put("ProjectManager",projectManager);
		revenueData.put("Revenue",totalRevenueStr);
		return revenueData;
	}

}
