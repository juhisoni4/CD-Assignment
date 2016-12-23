package com.frt.repository;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.ManagementTeam;
import com.frt.model.Project;
import com.frt.model.ProjectResource;
import com.frt.model.SubProject;

public interface TestRepository {

	public void testData(Project project1, Client client1, ProjectResource projectResource1, ProjectResource projectResource2, ProjectResource projectResource3, SubProject subProject1, SubProject subProject2, SubProject subProject3, ManagementTeam managementTeam1, FinancialData financialData1, FinancialData financialData2, FinancialData financialData3);

	public void testData(Project project3, Client client3,
			ProjectResource projectResource7, ManagementTeam managementTeam4,
			FinancialData financialData7);
}
