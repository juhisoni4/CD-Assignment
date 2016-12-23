package com.frt.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.ManagementTeam;
import com.frt.model.Project;
import com.frt.model.ProjectResource;
import com.frt.model.SubProject;
import com.frt.repository.TestRepository;

@Repository
public class TestRepositoryImpl implements TestRepository {

	@Autowired
	public SessionFactory factory;

	// session.save(client2);
	// session.save(project2);
	// session.save(subProject4);
	// session.save(subProject5);
	// session.save(subProject6);
	// session.save(projectResource4);
	// session.save(projectResource5);
	// session.save(projectResource6);
	// session.save(financialData4);
	// session.save(financialData5);
	// session.save(financialData6);
	// session.save(managementTeam2);

	public void testData(Project project1, Client client1,
			ProjectResource projectResource1, ProjectResource projectResource2,
			ProjectResource projectResource3, SubProject subProject1,
			SubProject subProject2, SubProject subProject3,
			ManagementTeam managementTeam1, FinancialData financialData1,
			FinancialData financialData2, FinancialData financialData3) {

		Session session = (Session) factory.getCurrentSession();

		session.save(client1);
		session.save(project1);
		session.save(subProject1);
		session.save(subProject2);
		session.save(subProject3);
		session.save(projectResource1);
		session.save(projectResource2);
		session.save(projectResource3);
		session.save(financialData1);
		session.save(financialData2);
		session.save(financialData3);
		session.save(managementTeam1);

	}

	@Override
	public void testData(Project project3, Client client3,
			ProjectResource projectResource7, ManagementTeam managementTeam4,
			FinancialData financialData7) {

		Session session = (Session) factory.getCurrentSession();

		session.save(client3);
		session.save(project3);
		session.save(projectResource7);
		session.save(financialData7);
		session.save(managementTeam4);
	}
}
