package com.frt.controller;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frt.model.Client;
import com.frt.model.Employee;
import com.frt.model.Employee.Role;
import com.frt.model.FinancialData;
import com.frt.model.FinancialData.Month;
import com.frt.model.Project;
import com.frt.model.SubProject;
import com.frt.service.ClientService;
import com.frt.service.EmployeeService;
import com.frt.service.FinancialDataService;
import com.frt.service.ProjectService;
import com.frt.service.SubProjectService;

@RestController
@RequestMapping(value = "/test")
public class TestController {

	@Autowired
	HttpServletResponse response;

	@Autowired
	HttpServletRequest request;

	@Autowired
	ClientService clientService;

	@Autowired
	ProjectService projectService;

	@Autowired
	FinancialDataService financialDataService;

	@Autowired
	SubProjectService subProjectService;

	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "/list")
	public void test() {

		System.out.println("Inside test controller...");

		// Instantiating 1st client
		Client client = new Client();

		client.setRegion("USA");
		client.setClientName("IBM");
		client.setClientJoining("New");
		client.setDomain("Networking");
		client.setDisplay(true);

		Project project = new Project();
		project.setProjectNamePerQB("IBM Portal");
		project.setProjectNamePerQuest("IBM User Management Portal");
		project.setSourceOfBusiness("EE");
		project.setProjectNew(true);
		project.setNatureOfDeal("Managed T&M");
		project.setType("Onsite Vendor");
		project.setGroupSkill("Java");
		project.setStream("Consulting");
		// project.setEndPeriod(new Date());
		project.setSubTechnology("Liferay");
		project.setTechnology("Portals");
		project.setQb("AMER");

		SubProject subProject1 = new SubProject();
		subProject1.setSubProjectName("Liferay Portal");

		Set<SubProject> subProjectList = new LinkedHashSet<SubProject>();
		subProjectList.add(subProject1);

		project.setSubProjectList(subProjectList);

		FinancialData financialData = new FinancialData();
		financialData.setOnSite(true);
		financialData.setRoleOfResource("Developer");
		financialData.setRequestedBy("Vishal Rangras");
		financialData.setResourceSkill("Java Web");
		financialData.setLocationOfResource("California");
		financialData.setResourceExpense("Resource");
		financialData.setMonth(Month.JAN);
		financialData.setYear(2017);
		financialData.setHrs_days(30);
		financialData.setActualRevenue(10000);
		financialData.setActualCost(5960);
		financialData.setActualProjectMargin(4060);
		financialData.setActualMarginPercentage(40);

		Employee projectResource = new Employee();
		projectResource.setFirstName("Juhi");
		projectResource.setLastName("Soni");
		projectResource.setRole(Role.Project_Resource);
		projectResource.setResourceCode("CAD161009L");

		financialData.setProjectResource(projectResource);

		Employee projectManager = new Employee();
		projectManager.setFirstName("Vatsal");
		projectManager.setLastName("Thakkar");
		projectManager.setRole(Role.Project_Manager);
		projectManager.setResourceCode("CAD157007L");

		financialData.setProjectManager(projectManager);

		Employee salesHead = new Employee();
		salesHead.setFirstName("Paul");
		salesHead.setLastName("Anthony");
		salesHead.setRole(Role.Sales_Head);
		salesHead.setResourceCode("CAD175307L");

		financialData.setSalesHead(salesHead);

		Employee salesPerson = new Employee();
		salesPerson.setFirstName("Vivek");
		salesPerson.setLastName("Obhrai");
		salesPerson.setRole(Role.Sales_Person);
		salesPerson.setResourceCode("CAD157237L");

		financialData.setSalesPerson(salesPerson);

		Employee deliveryHead = new Employee();
		deliveryHead.setFirstName("Srinivas");
		deliveryHead.setLastName("Tadepatri");
		deliveryHead.setRole(Role.Delivery_Head);
		deliveryHead.setResourceCode("CAD114327L");

		financialData.setDeliveryHead(deliveryHead);

		Set<FinancialData> financialDataList = new LinkedHashSet<FinancialData>();
		financialDataList.add(financialData);

		project.setFinancialDataList(financialDataList);
		client.setFinanceDataList(financialDataList);

		Set<Project> projectList = new LinkedHashSet<Project>();
		projectList.add(project);
		client.setProjectList(projectList);

		// projectService.saveProject(project);
		clientService.saveClient(client);

		System.out.println("Data insertion completed... Fetching data now");

		Client searchClient = new Client();
		searchClient.setClientName("IBM");

		List<Client> searchClientList = clientService.search(searchClient);

		for (Client myClient : searchClientList) {
			System.out.println("Searched Client is:" + myClient.getClientName() + ", Domain " + myClient.getDomain());
		}

	}
}
