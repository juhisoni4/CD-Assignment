package com.frt.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.ManagementTeam;
import com.frt.model.Project;
import com.frt.model.ProjectResource;
import com.frt.model.SubProject;
import com.frt.repository.TestRepository;
import com.frt.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	@Autowired
	public TestRepository testRepository;

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void testData(Project project1, Client client1,
			ProjectResource projectResource1, ProjectResource projectResource2,
			ProjectResource projectResource3, SubProject subProject1,
			SubProject subProject2, SubProject subProject3,
			ManagementTeam managementTeam1, FinancialData financialData1,
			FinancialData financialData2, FinancialData financialData3) {
	
		testRepository.testData(project1,client1,projectResource1,projectResource2, 
				projectResource3, subProject1, subProject2, subProject3, managementTeam1, 
				financialData1, financialData2, financialData3);
		
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void testData(Project project3, Client client3,
			ProjectResource projectResource7, ManagementTeam managementTeam4,
			FinancialData financialData7) {
		
		testRepository.testData(project3,client3,projectResource7, managementTeam4, 
				financialData7);
	}		
	
}





