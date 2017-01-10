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

		String fileName = "C:\\Users\\juhi.soni\\Desktop\\Data.csv";

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

			client.setRegion(row.get(1));
			client.setClientName(row.get(2));
			client.setClientJoining(row.get(9));
			client.setDomain(row.get(11));
			client.setDisplay(true);

			List<Client> searchClientList = clientService.search(client);

			Project project = new Project();
			project.setProjectNamePerQB(row.get(4));
			project.setProjectNamePerQuest(row.get(3));
			project.setSourceOfBusiness(row.get(8));
			project.setProjectNew(Boolean.parseBoolean(row.get(10)));
			project.setNatureOfDeal(row.get(12));
			project.setType(row.get(16));
			project.setGroupSkill(row.get(20));
			project.setStream(row.get(25));
			project.setSubTechnology(row.get(26));
			project.setTechnology(row.get(27));
			project.setQb(row.get(0));

			List<Project> searchProjectList = projectService.search(project);

			Set<Project> projectList = new LinkedHashSet<Project>();

			if (searchProjectList != null && searchProjectList.size() > 0) {
				projectList.add(searchProjectList.get(0));
			} else {
				projectList.add(project);
			}

			SubProject subProject = new SubProject();
			subProject.setSubProjectName(row.get(5));

			// //SubProject Dependency in Project
			List<SubProject> searchSubProjectList = subProjectService
					.search(subProject);

			Set<SubProject> subProjectList = new LinkedHashSet<SubProject>();

			if (searchSubProjectList != null && searchSubProjectList.size() > 0) {
				subProjectList.add(searchSubProjectList.get(0));
			} else {
				subProjectList.add(subProject);
			}

			project.setSubProjectList(subProjectList);

			// /////FinancialData Dependency
			FinancialData financialData = new FinancialData();
			financialData.setOnSite(Boolean.parseBoolean(row.get(16)));
			financialData.setRoleOfResource(row.get(18));
			financialData.setRequestedBy(row.get(19));
			financialData.setResourceSkill(row.get(21));
			financialData.setLocationOfResource(row.get(23));
			financialData.setResourceExpense(row.get(24));
			financialData.setMonth(Month.JAN);
			financialData.setYear(Long.parseLong(row.get(28)));
			financialData.setHrs_days(Long.parseLong(row.get(29)));
			financialData.setActualRevenue(Double.parseDouble(row.get(30)));
			financialData.setActualCost(Double.parseDouble(row.get(31)));
			financialData
					.setActualProjectMargin(Double.parseDouble(row.get(32)));
			financialData.setActualMarginPercentage(Double.parseDouble(row
					.get(33)));

			Employee salesHead = new Employee();
			List<String> stringsArray = resourseName(row.get(6));
			salesHead.setFirstName(stringsArray.get(0));
			if (stringsArray.size() == 2) {
				salesHead.setLastName(stringsArray.get(1));
			}
			salesHead.setRole(Role.Sales_Head);

			List<Employee> searchEmployeeList = employeeService
					.searchWithoutResourceCode(salesHead);

			if (searchEmployeeList != null && searchEmployeeList.size() > 0) {
				financialData.setSalesHead(searchEmployeeList.get(0));
			} else {
				financialData.setSalesHead(salesHead);
			}

			Employee salesPerson = new Employee();
			List<String> stringsArray1 = resourseName(row.get(7));
			salesPerson.setFirstName(stringsArray1.get(0));
			if (stringsArray1.size() == 2) {
				salesPerson.setLastName(stringsArray1.get(1));
			}
			salesPerson.setRole(Role.Sales_Person);

			List<Employee> searchEmployeeList1 = employeeService
					.searchWithoutResourceCode(salesPerson);

			if (searchEmployeeList1 != null && searchEmployeeList1.size() > 0) {
				financialData.setSalesPerson(searchEmployeeList1.get(0));
			} else {
				financialData.setSalesPerson(salesPerson);
			}

			Employee projectManager = new Employee();
			List<String> stringsArray2 = resourseName(row.get(13));
			projectManager.setFirstName(stringsArray2.get(0));
			if (stringsArray2.size() == 2) {
				projectManager.setLastName(stringsArray2.get(1));
			}
			projectManager.setRole(Role.Project_Manager);

			List<Employee> searchEmployeeList2 = employeeService
					.searchWithoutResourceCode(projectManager);

			if (searchEmployeeList2 != null && searchEmployeeList2.size() > 0) {
				financialData.setProjectManager(searchEmployeeList2.get(0));
			} else {
				financialData.setProjectManager(projectManager);
			}

			Employee deliveryHead = new Employee();
			List<String> stringsArray3 = resourseName(row.get(13));
			deliveryHead.setFirstName(stringsArray3.get(0));
			if (stringsArray3.size() == 2) {
				deliveryHead.setLastName(stringsArray3.get(1));
			}
			deliveryHead.setRole(Role.Delivery_Head);

			List<Employee> searchEmployeeList3 = employeeService
					.searchWithoutResourceCode(deliveryHead);

			if (searchEmployeeList3 != null && searchEmployeeList3.size() > 0) {
				financialData.setDeliveryHead(searchEmployeeList3.get(0));
			} else {
				financialData.setDeliveryHead(projectManager);
			}

			Employee resource = new Employee();
			List<String> stringsArray4 = resourseName(row.get(17));
			resource.setFirstName(stringsArray4.get(0));
			if (stringsArray4.size() == 2) {
				resource.setLastName(stringsArray4.get(1));
			}
			resource.setRole(Role.Project_Resource);
			resource.setResourceCode(row.get(22));

			List<Employee> searchEmployeeList4 = employeeService
					.search(resource);

			if (searchEmployeeList4 != null && searchEmployeeList4.size() > 0) {
				financialData.setProjectResource(searchEmployeeList4.get(0));
			} else {
				financialData.setProjectResource(resource);
			}

			Set<FinancialData> financialDataList = new LinkedHashSet<FinancialData>();
			financialDataList.add(financialData);
			
			/////project dependency
			if (searchProjectList != null && searchProjectList.size() > 0) {
				searchProjectList.get(0)
						.setFinancialDataList(financialDataList);
			} else {
				project.setFinancialDataList(financialDataList);
			}
			
			////////Client Dependency
			if (searchClientList != null && searchClientList.size() > 0) {
				searchClientList.get(0).setFinanceDataList(financialDataList);
				searchClientList.get(0).setProjectList(projectList);
				clientService.saveClient(searchClientList.get(0));
			} else {
				client.setFinanceDataList(financialDataList);
				client.setProjectList(projectList);
				clientService.saveClient(client);
			}

		}

	}

	public List<String> resourseName(String string) {

		String[] stringsArray = string.split(" ");

		List<String> list = new ArrayList<>();

		for (int i = 0; i < stringsArray.length; i++) {
			list.add(stringsArray[i]);
		}

		return list;
	}
}
