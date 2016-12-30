package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.frt.model.FinancialData;
import com.frt.repository.FinancialDataRepository;

@Repository
public class FinancialDataRepositoryImpl implements FinancialDataRepository {

	@Autowired
	SessionFactory factory;

	/*@Autowired
	FinancialData financialData;*/

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

	public List<FinancialData> getRevenueByProjectManager(String month1,
			String month2, Integer year, String managementTeam,
			String managementTeamPersonName) {

		String hql = "from FinancialData WHERE month BETWEEN :month1 AND :month2 AND year = :year AND "
				+ managementTeam + " = :managementTeamPerson";
		Session session = factory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("month1", month1);
		query.setParameter("month2", month2);
		query.setParameter("year", year);
		query.setParameter("managementTeamPerson", managementTeamPersonName);
		List<FinancialData> financeDatalist = query.list();
		System.out.println(financeDatalist);

		return financeDatalist;
	}
	
}
