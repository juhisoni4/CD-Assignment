package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.FinancialData;
import com.frt.model.ManagementTeam;
import com.frt.repository.ManagementTeamRepositry;

@Repository
public class ManagementTeamRepositoryImpl implements ManagementTeamRepositry {

	@Autowired
	public SessionFactory factory;

	@Override
	public void saveManagementTeam(ManagementTeam managementTeam) {
		
		factory.getCurrentSession().saveOrUpdate(managementTeam);
		
	}

	@Override
	public ManagementTeam getManagementTeamById(Long id) {
		
		ManagementTeam managementTeam = (ManagementTeam) factory.getCurrentSession().get(ManagementTeam.class, id);
		return managementTeam;
	}

	@Override
	public List<ManagementTeam> getAllManagementTeam() {
		
		List<ManagementTeam> managementTeamList = new ArrayList<>();
		managementTeamList = factory.getCurrentSession().createQuery("from ManagementTeam").list();
		return managementTeamList;
	}	
	
	public Double getManagementTeamPersonRevenue(String columnName,
			String personName) {
		Double totalRevenue = 0.00;
		
		Criteria criteria1 = factory.getCurrentSession().createCriteria(
				ManagementTeam.class);
		criteria1.add(Restrictions.eq(columnName, personName));
		List results = criteria1.list();
		ManagementTeam managementTeam = (ManagementTeam) results.get(0);
		Long id = managementTeam.getId();
		System.out.println(id);

		Criteria criteria2 = factory.getCurrentSession().createCriteria(
				FinancialData.class);
		criteria2.add(Restrictions.eq("managementTeam.id", id));
		List<FinancialData> results2 = criteria2.list();
		for (FinancialData data : results2) {
			Double revenueData = data.getActualRevenue();
			totalRevenue = totalRevenue + revenueData;
			System.out.println(totalRevenue);
		}

		return totalRevenue;

		/*
		 * String hql = "from "+class1+" where "+columnName +" = :"+personName;
		 * //String hql =
		 * "from ManagementTeam where projectManager = :projectManager"; Session
		 * session = factory.getCurrentSession(); Query query =
		 * session.createQuery(hql); query.setParameter(columnName, personName);
		 * System.out.println(hql); List<Class<?>> list = query.list(); Class<?>
		 * class2 = list.get(0); Long id = class2.getId();
		 */

		/*
		 * String hql = "from "+tableName+" where "+columnName
		 * +" = :"+columnName; Session session = factory.getCurrentSession();
		 * Query query = session.createQuery(hql);
		 * query.setParameter(columnName, personName); System.out.println(hql);
		 * try { Class a = Class.forName(tableName); Object obj =
		 * a.newInstance(); List<Object> list = query.list(); Object obj2 =
		 * list.get(0); Long id = ((Object) obj2).getId();
		 * 
		 * } catch (ClassNotFoundException | InstantiationException |
		 * IllegalAccessException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */

		/*
		 * String hql = "from FinancialData where managementTeam.id = :id";
		 * Session session = factory.getCurrentSession(); Query query =
		 * session.createQuery(hql); query.setParameter("id", id);
		 * List<FinancialData> list = query.list(); for(FinancialData
		 * data:list){ System.out.println(data.getActualCost() +" "+
		 * data.getHrs_days()); }
		 */

	}




















	

}
