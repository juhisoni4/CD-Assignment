package com.finance.reporting.tool.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.finance.reporting.tool.model.Client;
import com.finance.reporting.tool.model.FinancialData;
import com.finance.reporting.tool.model.ManagementTeam;
import com.finance.reporting.tool.model.Project;
import com.finance.reporting.tool.model.ProjectResource;
import com.finance.reporting.tool.model.SubProject;

@Repository
public class FrtDao {

	@Autowired
	public SessionFactory factory;
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void add(){
		
		Project project1 = new Project("IBM Portal", "IBM User Management Portal","New","Managed T&M", "Onsite Vendor", "onsite", "portal", "liferay", "consulting", new Date(), "USA", "Java", "Vishal");
		Project project2 = new Project("Apple IOS game", "Apple IOS game","New","Fixed Bid", "Offshore Employee", "onsite", "portal", "liferay", "consulting", new Date(), "USA", "Java", "Vishal");
		
		ProjectResource projectResource1	= new ProjectResource("CAD1111111A", "Juhi Soni","Developer", "Java","USA" ,"Resource");	
		ProjectResource projectResource2	= new ProjectResource("CAD1111111B", "Charmy Raval","Developer", "Java","Ahmedabad" ,"Resource");
		ProjectResource projectResource3	= new ProjectResource("CAD1111111C", "Krina Akhani","QA", "Java","Ahmedabad" ,"Resource");	
		
		Client client = new Client("IBM","Networking", "USA", "New");
		
		ManagementTeam managementTeam = new ManagementTeam("Anand Shah", "Paul Anthony", "Paul Anthony", "Srinivas Tadeparti", new Date(), new Date());
		
		SubProject subProject1 = new SubProject("Liferay Portal");
		SubProject subProject2 = new SubProject("Liferay Portal");
		SubProject subProject3 = new SubProject("Liferay Portal");
		
		FinancialData financialData1 = new FinancialData("april", 2015, new Date(), new Date(), 30, 10000.00, 5940.00, 4060.00, 40.60, 120, 55000.00, 26000.00, 29000.00, 52.73);
		FinancialData financialData2 = new FinancialData("april", 2015, new Date(), new Date(), 28, 9400.00, 5940.00, 3460.00, 36.81, 110, 52000.00, 24000.00, 28000.00, 55.73);
		FinancialData financialData3 = new FinancialData("april", 2015, new Date(), new Date(), 28, 9400.00, 5940.00, 3460.00, 36.81, 110, 52000.00, 24000.00, 28000.00, 55.73);
		
		project1.setClient(client);
		List<ProjectResource> projectResourcesList = new ArrayList<>();
		projectResourcesList.add(projectResource1);
		projectResourcesList.add(projectResource2);
		projectResourcesList.add(projectResource3);
		project1.setProjectResourcesList(projectResourcesList);		
		List<Project> projectList = new ArrayList<>();
		projectList.add(project2);
		projectList.add(project1);		
		projectResource1.setProjectList(projectList);
		List<SubProject> subProjectList = new ArrayList();
		subProjectList.add(subProject1);
		subProjectList.add(subProject2);
		subProjectList.add(subProject3);
		project1.setSubProjectList(subProjectList);
		
		Session session = (Session) factory.getCurrentSession();
		
		session.save(client);
		session.save(project1);
		session.save(project2);
		session.save(subProject1);
		session.save(subProject2);
		session.save(subProject3);
		session.save(projectResource1);
		session.save(projectResource2);
		session.save(projectResource3);
		session.save(financialData1);
		session.save(financialData2);
		session.save(financialData2);
		session.save(financialData3);
		session.save(managementTeam);		
		
		session.close();
		
	}
}
