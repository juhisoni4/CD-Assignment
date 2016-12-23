package com.frt.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.ManagementTeam;
import com.frt.model.Project;
import com.frt.model.ProjectResource;
import com.frt.model.SubProject;
import com.frt.service.ClientService;
import com.frt.service.FinancialDataService;
import com.frt.service.ManagementTeamService;
import com.frt.service.ProjectResourceService;
import com.frt.service.ProjectService;
import com.frt.service.SubProjectService;
import com.frt.service.TestService;

@Controller
public class TestController {

	@Autowired
	ClientService clientService;

	@Autowired
	ProjectService projectService;

	@Autowired
	ProjectResourceService projectResourceService;

	@Autowired
	FinancialDataService financialDataService;

	@Autowired
	SubProjectService subProjectService;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ManagementTeamService managementTeamService;

	Project project1 = new Project("IBM Portal", "IBM User Management Portal",
			"EE", true, "Managed T&M", true, "portal", "liferay", "consulting",
			"1/2/2015", "USA", "Java", "Vishal");

	Project project2 = new Project("Apple IOS game", "Apple IOS game", "EE",
			true, "Fixed Bid", true, "portal", "liferay", "consulting",
			"5/10/2016", "INDIA", "IOS", "Vishal");

	Project project3 = new Project("Licence", "Licence", "NN", false,
			"Licence", false, "Magento Licence", "Magento Licence", "Licence",
			"25/10/2016", "USA", "Licence", "Vishal");

	ProjectResource projectResource1 = new ProjectResource("CAD1111111A",
			"Juhi Soni", "Developer", "Java", "USA", "Resource",
			"Onsite Vendor");
	ProjectResource projectResource2 = new ProjectResource("CAD1111111B",
			"Charmy Raval", "Developer", "Java", "Ahmedabad", "Resource",
			"Offshore Employee");
	ProjectResource projectResource3 = new ProjectResource("CAD1111111C",
			"Krina Akhani", "QA", "D3", "Ahmedabad", "Resource",
			"Offshore Employee");
	ProjectResource projectResource4 = new ProjectResource("CAD150506E",
			"Vishal Rangras", "Technical Lead", "IOS", "Ahmedabad", "Resource",
			"Offshore Employee");
	ProjectResource projectResource5 = new ProjectResource("CAD150508F",
			"Isha Mehta", "Developer", "Testing", "Noida", "Resource",
			"Offshore Employee");
	ProjectResource projectResource6 = new ProjectResource("CAD150508R",
			"Nehal Soni", "Developer", "UI", "Ahmedabad", "Resource",
			"Offshore Employee");
	ProjectResource projectResource7 = new ProjectResource("Licence",
			"Licence", "Licence", "Licence", "Licence", "Licence", "Licence");

	Client client1 = new Client("IBM", "Networking", "USA", "New");
	Client client2 = new Client("Apple", "Entertainment", "APJ", "Existing");
	Client client3 = new Client("Microsoft", "IT", "USA", "Existing");

	ManagementTeam managementTeam1 = new ManagementTeam("Anand Shah",
			"Paul Anthony", "Paul Anthony", "Srinivas Tadeparti", "17/08/2014",
			"05/03/2016");
	ManagementTeam managementTeam2 = new ManagementTeam("Jogen G", "Ashish T",
			"Ashish T", "PKV Sastry", "21/07/2014", "02/05/2015");
	ManagementTeam managementTeam3 = new ManagementTeam("Kruti Shah",
			"Paul Anthony", "Paul Anthony", "PKV Sastry", "3/05/2015",
			"27/10/2016");
	ManagementTeam managementTeam4 = new ManagementTeam("Jogen G", "Pinkal K",
			"Pinkal K", "PKV Sastry", "06/08/2015", "15/3/2016");

	SubProject subProject1 = new SubProject("Liferay Portal");
	SubProject subProject2 = new SubProject("Liferay Portal");
	SubProject subProject3 = new SubProject("Liferay Portal");
	SubProject subProject4 = new SubProject("IOS");
	SubProject subProject5 = new SubProject("IOS");
	SubProject subProject6 = new SubProject("UX");

	FinancialData financialData1 = new FinancialData("april", 2016,
			"01/04/2016", "30/04/2016", 30, 10000.00, 5940.00, 4060.00, 40.60,
			120, 55000.00, 26000.00, 29000.00, 52.73);
	FinancialData financialData2 = new FinancialData("april", 2016,
			"01/04/2016", "30/04/2016", 28, 9400.00, 5940.00, 3460.00, 36.81,
			110, 52000.00, 24000.00, 28000.00, 55.73);
	FinancialData financialData3 = new FinancialData("april", 2016,
			"01/04/2016", "30/04/2016", 29, 9600.00, 5940.00, 3460.00, 36.81,
			110, 52000.00, 24000.00, 28000.00, 55.73);
	FinancialData financialData4 = new FinancialData("april", 2016,
			"01/04/2016", "30/04/2016", 30, 15000.00, 6200.00, 8800.00, 58.61,
			120, 55000.00, 26000.00, 29000.00, 52.73);
	FinancialData financialData5 = new FinancialData("april", 2016,
			"01/04/2016", "30/04/2016", 30, 14200.00, 6200.00, 8000.00, 56.36,
			120, 55000.00, 26000.00, 29000.00, 52.73);
	FinancialData financialData6 = new FinancialData("april", 2016,
			"01/04/2016", "30/04/2016", 30, 9000.00, 5200.00, 3800.00, 42.22,
			120, 55000.00, 26000.00, 29000.00, 52.73);
	FinancialData financialData7 = new FinancialData("april", 2016,
			"01/04/2016", "30/04/2016", 0, 0.00, 0.00, 0.00, 0.00, 0, 0.00,
			0.00, 0.00, 0.00);

	//uncomment the code to save the data
	/*@RequestMapping(value = "/")
	public String projectData() {

		projectx();

		projecty();

		projectz();

		return "index";

	}*/
	
	@RequestMapping(value = "/")
	public String getProjectData(){
		
		System.out.println(financialDataService.getFinanceDataById(2L));
		System.out.println(projectResourceService.getProjectResourceById(2L));
		System.out.println(projectService.getProjectById(3L));
		System.out.println(managementTeamService.getManagementTeamById(1L));
		System.out.println(clientService.getClientById(3L));
		System.out.println(subProjectService.getSubProjectById(6L));
		
		return "index";
	}

	// @RequestMapping(value = "/")
	public String projectData1() {
		// managementTeamService.getManagementTeamPerson("projectManager",
		// "Anand Shah");
		return "data-fetch";
	}

	@RequestMapping(value = "fetch")
	public String dataFetch() {
		String name = request.getParameter("data");
		String finance = request.getParameter("finance");
		System.out.println(name);
		String[] parts = name.split("-");
		String part1 = parts[0];
		String part2 = parts[1];

		if (finance.equals("Revenue")) {
			parseDataColumnRevenue(part1, part2);
		} else if (finance.equals("Cost")) {
			// parseDataColumnCost(part1, part2);
		} else {
			// parseDataColumnMargin(part1, part2);
		}

		System.out.println(part1);
		System.out.println(part2);
		return "data-fetch";
	}

	private void parseDataColumnRevenue(String part1, String part2) {
		Double revenueData = null;
		switch (part1) {
		case "projectManager":
			revenueData = managementTeamService.getManagementTeamPersonRevenue(
					part1, part2);
			break;

		case "salesPerson":
			revenueData = managementTeamService.getManagementTeamPersonRevenue(
					part1, part2);
			break;

		case "salesHead":
			revenueData = managementTeamService.getManagementTeamPersonRevenue(
					part1, part2);
			break;

		case "deliveryHead":
			revenueData = managementTeamService.getManagementTeamPersonRevenue(
					part1, part2);
			break;

		}

		request.setAttribute("financeData", revenueData);
	}

	public void sendDataToFrontEnd() {

	}

	public void projectz() {

		List<Project> projectList3 = new ArrayList<>();
		projectList3.add(project3);

		client3.setProjectList(projectList3);

		financialData7.setProject(project3);
		financialData7.setProjectResource(projectResource7);

		List<ProjectResource> projectResourcesList3 = new ArrayList<>();
		projectResourcesList3.add(projectResource7);
		project3.setProjectResourcesList(projectResourcesList3);

		List<ManagementTeam> managementTeamList3 = new ArrayList<>();
		managementTeamList3.add(managementTeam4);
		project3.setManagementTeamList(managementTeamList3);

		clientService.saveClient(client3);
		projectService.saveProject(project3);
		projectResourceService.saveProjectResource(projectResource7);
		financialDataService.saveFinanceData(financialData7);
		managementTeamService.saveManagementTeam(managementTeam4);

	}

	public void projecty() {

		List<Project> projectList2 = new ArrayList<>();
		projectList2.add(project2);
		projectResource4.setProjectList(projectList2);

		client2.setProjectList(projectList2);

		List<ManagementTeam> managementTeamList2 = new ArrayList<>();
		managementTeamList2.add(managementTeam2);
		managementTeamList2.add(managementTeam3);
		project2.setManagementTeamList(managementTeamList2);

		List<SubProject> subProjectList2 = new ArrayList<SubProject>();
		subProjectList2.add(subProject4);
		subProjectList2.add(subProject5);
		subProjectList2.add(subProject6);
		project2.setSubProjectList(subProjectList2);

		financialData4.setProject(project2);
		financialData5.setProject(project2);
		financialData6.setProject(project2);

		financialData4.setProjectResource(projectResource4);
		financialData5.setProjectResource(projectResource5);
		financialData6.setProjectResource(projectResource6);

		List<ProjectResource> projectResourcesList2 = new ArrayList<>();
		projectResourcesList2.add(projectResource4);
		projectResourcesList2.add(projectResource5);
		projectResourcesList2.add(projectResource6);
		project2.setProjectResourcesList(projectResourcesList2);

		clientService.saveClient(client2);
		projectService.saveProject(project2);
		projectResourceService.saveProjectResource(projectResource4);
		projectResourceService.saveProjectResource(projectResource5);
		projectResourceService.saveProjectResource(projectResource6);
		subProjectService.saveSubProject(subProject4);
		subProjectService.saveSubProject(subProject5);
		subProjectService.saveSubProject(subProject6);
		financialDataService.saveFinanceData(financialData4);
		financialDataService.saveFinanceData(financialData5);
		financialDataService.saveFinanceData(financialData6);
		managementTeamService.saveManagementTeam(managementTeam2);
		managementTeamService.saveManagementTeam(managementTeam3);

	}

	public void projectx() {

		List<Project> projectList1 = new ArrayList<>();
		projectList1.add(project1);
		projectResource1.setProjectList(projectList1);

		client1.setProjectList(projectList1);

		financialData1.setProject(project1);
		financialData2.setProject(project1);
		financialData3.setProject(project1);

		financialData1.setProjectResource(projectResource1);
		financialData2.setProjectResource(projectResource2);
		financialData3.setProjectResource(projectResource3);

		List<ProjectResource> projectResourcesList1 = new ArrayList<>();
		projectResourcesList1.add(projectResource1);
		projectResourcesList1.add(projectResource2);
		projectResourcesList1.add(projectResource3);
		project1.setProjectResourcesList(projectResourcesList1);

		List<SubProject> subProjectList1 = new ArrayList<SubProject>();
		subProjectList1.add(subProject1);
		subProjectList1.add(subProject2);
		subProjectList1.add(subProject3);
		project1.setSubProjectList(subProjectList1);

		List<ManagementTeam> managementTeamList1 = new ArrayList<>();
		managementTeamList1.add(managementTeam1);
		project1.setManagementTeamList(managementTeamList1);

		clientService.saveClient(client1);
		projectService.saveProject(project1);
		projectResourceService.saveProjectResource(projectResource1);
		projectResourceService.saveProjectResource(projectResource2);
		projectResourceService.saveProjectResource(projectResource3);
		financialDataService.saveFinanceData(financialData1);
		financialDataService.saveFinanceData(financialData2);
		financialDataService.saveFinanceData(financialData3);
		subProjectService.saveSubProject(subProject1);
		subProjectService.saveSubProject(subProject2);
		subProjectService.saveSubProject(subProject3);
		managementTeamService.saveManagementTeam(managementTeam1);

	}
}
