package com.frt.controller;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
//@RequestMapping(value = "/test")
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

	//@RequestMapping(value = "/list")
	public void test() {

		System.out.println("Inside test controller...");

		String fileName = "C:/test/Data1.csv";
		
		List<List<String>> mainList = new ArrayList<List<String>>();

		try {
			File fl = new File(fileName);
			BufferedReader br = new BufferedReader(new FileReader(fl));
			String str;

			while ((str = br.readLine()) != null) {
				String[] stringsArray = str.split(",");
				mainList.add(Arrays.asList(stringsArray));
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (List<String> row : mainList) {		
					
			Client client = new Client();

			client.setClientName(row.get(2));

			List<Client> searchClientList = clientService.search(client);

			if (searchClientList != null && searchClientList.size() > 0) {
				client = searchClientList.get(0);				
			} else {
				client.setRegion(row.get(1));
				client.setClientJoining(row.get(9));
				client.setDomain(row.get(11));
				client.setDisplay(true);
			}

			Project project = new Project();
			project.setProjectNamePerQB(row.get(4));
			project.setProjectNamePerQuest(row.get(3));	
			
			List<Project> searchProjectList = projectService.search(project);

			if (searchProjectList != null && searchProjectList.size() > 0) {
				project = searchProjectList.get(0);					
			} else {
				project.setProjectNew(row.get(10).trim().toLowerCase()
						.equalsIgnoreCase("new"));
				project.setSourceOfBusiness(row.get(8));
				project.setNatureOfDeal(row.get(12));
				project.setType(row.get(16));
				project.setGroupSkill(row.get(20));
				project.setStream(row.get(25));
				project.setSubTechnology(row.get(26));
				project.setTechnology(row.get(27));
				project.setQb(row.get(0));				
			}

			SubProject subProject = new SubProject();
			subProject.setSubProjectName(row.get(5));
			
			List<SubProject> searchSubProjectList = subProjectService
					.search(subProject);

			if (searchSubProjectList != null && searchSubProjectList.size() > 0) {
				subProject = searchSubProjectList.get(0);
			}
			
			Set<SubProject> subProjectList = new LinkedHashSet<SubProject>();	
			
			subProjectList.add(subProject);				
			subProject.setProject(project);
			project.setClient(client);
			project.setSubProjectList(subProjectList);
			
			Employee salesHead = new Employee();
			salesHead.setName(row.get(6));
			salesHead.setRole(Role.Sales_Head);

			List<Employee> searchEmployeeList = employeeService
					.search(salesHead);

			if (searchEmployeeList != null && searchEmployeeList.size() > 0) {
				salesHead = searchEmployeeList.get(0);
				searchEmployeeList = null;
			}

			Employee salesPerson = new Employee();
			salesPerson.setName(row.get(7));
			salesPerson.setRole(Role.Sales_Person);

			searchEmployeeList = employeeService.search(salesPerson);

			if (searchEmployeeList != null && searchEmployeeList.size() > 0) {
				salesPerson = searchEmployeeList.get(0);
				searchEmployeeList = null;
			}

			Employee projectManager = new Employee();
			projectManager.setName(row.get(13));
			projectManager.setRole(Role.Project_Manager);

			searchEmployeeList = employeeService.search(projectManager);

			if (searchEmployeeList != null && searchEmployeeList.size() > 0) {
				projectManager = searchEmployeeList.get(0);
				searchEmployeeList = null;
			}

			Employee deliveryHead = new Employee();
			deliveryHead.setName(row.get(14));
			deliveryHead.setRole(Role.Delivery_Head);

			searchEmployeeList = employeeService.search(deliveryHead);

			if (searchEmployeeList != null && searchEmployeeList.size() > 0) {
				deliveryHead = searchEmployeeList.get(0);
				searchEmployeeList = null;
			}

			Employee resource = new Employee();
			resource.setName(row.get(17));
			resource.setRole(Role.Project_Resource);
			resource.setResourceCode(row.get(22));

			searchEmployeeList = employeeService.search(resource);

			if (searchEmployeeList != null && searchEmployeeList.size() > 0) {
				resource = searchEmployeeList.get(0);
				searchEmployeeList = null;
			}		

			for (int j = 29, i = 0; j <= 88; ++j, i++) {

				FinancialData financialData = new FinancialData();
				financialData.setOnSite(row.get(16).trim().toLowerCase()
						.equalsIgnoreCase("onsite") ? true : false);
				financialData.setRoleOfResource(row.get(18));
				financialData.setRequestedBy(row.get(19));
				financialData.setResourceSkill(row.get(21));
				financialData.setLocationOfResource(row.get(23));
				financialData.setResourceExpense(row.get(24));
				financialData.setYear(Long.parseLong(row.get(28)));

				if (row.get(j).isEmpty()) {
					j = j + 5;
					i++;
				}

				financialData.setMonth(Month.values()[i]);

				financialData.setHrs_days(Long.parseLong(row.get(j)));

				financialData
						.setActualRevenue(Double.parseDouble(row.get(++j)));

				financialData.setActualCost(Double.parseDouble(row.get(++j)));

				financialData.setActualProjectMargin(Double.parseDouble(row
						.get(++j)));

				financialData.setActualMarginPercentage(Double.parseDouble(row
						.get(++j)));				
				
				financialData.setProjectResource(resource);

				financialData.setSalesHead(salesHead);

				financialData.setSalesPerson(salesPerson);

				financialData.setProjectManager(projectManager);

				financialData.setDeliveryHead(deliveryHead);

				financialData.setProject(project);

				financialData.setClient(client);

				financialDataService.saveFinanceData(financialData);
			}

		}

	}

}
