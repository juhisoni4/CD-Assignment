package com.frt.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.frt.model.Client;
import com.frt.model.SubProject;

public class App {

	static int j;

	static void methodA(int i) {
		boolean b;
		do {
			b = i < 10 | methodB(4); /* Line 9 *///b=true|true
			b = i < 10 || methodB(8); /* Line 10 */
		} while (!b);
	}

	static boolean methodB(int i) {
		j += i;
		return true;
	}

	public static void main(String[] args) {

		methodA(0);
		System.out.println("j = " + j);
		/*
		 * List<String> list = new ArrayList<>(); list.add("Juhi");
		 * list.add("Nehal"); list.add("Vishal"); list.add("Juhi"); for(String
		 * name:list){ System.out.println(name); System.out.println(); }
		 * 
		 * Set<String> set = new HashSet<>(list); for(String name1:set){
		 * System.out.println(name1); }
		 */
		/*
		 * int numbers[] = {23,5,23,1,7,12,3,34,0};
		 * 
		 * bubbleSort(numbers);
		 * 
		 * for(int num:numbers){ System.out.println(num); }
		 */
		
		/*ProjectResource projectResource1 = new ProjectResource("CAD1111111A",
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

		SubProject subProject1 = new SubProject("Liferay Portal");
		SubProject subProject2 = new SubProject("Liferay Portal");
		SubProject subProject3 = new SubProject("Liferay Portal");
		SubProject subProject4 = new SubProject("IOS");
		SubProject subProject5 = new SubProject("IOS");
		SubProject subProject6 = new SubProject("UX");*/

	/*	FinancialData financialData1 = new FinancialData("april", 2016,
				"Anand Shah", "Paul Anthony", "Paul Anthony", "Srinivas Tadeparti",
				30, 10000.00, 5940.00, 4060.00, 40.60, 120, 55000.00, 26000.00,
				29000.00, 52.73);
		FinancialData financialData2 = new FinancialData("april", 2016,
				"Anand Shah", "Paul Anthony", "Paul Anthony", "Srinivas Tadeparti",
				28, 9400.00, 5940.00, 3460.00, 36.81, 110, 52000.00, 24000.00,
				28000.00, 55.73);
		FinancialData financialData3 = new FinancialData("april", 2016,
				"Anand Shah", "Paul Anthony", "Paul Anthony", "Srinivas Tadeparti",
				29, 9600.00, 5940.00, 3460.00, 36.81, 110, 52000.00, 24000.00,
				28000.00, 55.73);
		FinancialData financialData4 = new FinancialData("may", 2016, "Anand Shah",
				"Paul Anthony", "Paul Anthony", "Srinivas Tadeparti", 30, 10000.00,
				5940.00, 4060.00, 40.60, 120, 55000.00, 26000.00, 29000.00, 52.73);
		FinancialData financialData5 = new FinancialData("may", 2016, "Anand Shah",
				"Paul Anthony", "Paul Anthony", "Srinivas Tadeparti", 28, 9400.00,
				5940.00, 3460.00, 36.81, 110, 52000.00, 24000.00, 28000.00, 55.73);
		FinancialData financialData6 = new FinancialData("may", 2016, "Anand Shah",
				"Paul Anthony", "Paul Anthony", "Srinivas Tadeparti", 29, 9600.00,
				5940.00, 3460.00, 36.81, 110, 52000.00, 24000.00, 28000.00, 55.73);
		FinancialData financialData7 = new FinancialData("april", 2016, "Jogen G",
				"Ashish T", "Ashish T", "PKV Sastry", 30, 15000.00, 6200.00,
				8800.00, 58.61, 120, 55000.00, 26000.00, 29000.00, 52.73);
		FinancialData financialData8 = new FinancialData("april", 2016, "Jogen G",
				"Paul Anthony", "Paul Anthony", "PKV Sastry", 30, 14200.00,
				6200.00, 8000.00, 56.36, 120, 55000.00, 26000.00, 29000.00, 52.73);
		FinancialData financialData9 = new FinancialData("april", 2016, "Jogen G",
				"Paul Anthony", "Paul Anthony", "PKV Sastry", 30, 9000.00, 5200.00,
				3800.00, 42.22, 120, 55000.00, 26000.00, 29000.00, 52.73);
		FinancialData financialData10 = new FinancialData("may", 2016,
				"Kruti Shah", "Paul Anthony", "Paul Anthony", "PKV Sastry", 30,
				14200.00, 6200.00, 8000.00, 56.36, 120, 55000.00, 26000.00,
				29000.00, 52.73);
		FinancialData financialData11 = new FinancialData("may", 2016,
				"Kruti Shah", "Paul Anthony", "Paul Anthony", "PKV Sastry", 30,
				9000.00, 5200.00, 3800.00, 42.22, 120, 55000.00, 26000.00,
				29000.00, 52.73);
		FinancialData financialData12 = new FinancialData("may", 2016,
				"Kruti Shah", "Paul Anthony", "Paul Anthony", "PKV Sastry", 30,
				9000.00, 5200.00, 3800.00, 42.22, 120, 55000.00, 26000.00,
				29000.00, 52.73);
		FinancialData financialData13 = new FinancialData("april", 2016, "Jogen G",
				"Pinkal K", "Pinkal K", "PKV Sastry", 0, 0.00, 0.00, 0.00, 0.00, 0,
				0.00, 0.00, 0.00, 0.00);
		FinancialData financialData14 = new FinancialData("may", 2016, "Jogen G",
				"Pinkal K", "Pinkal K", "PKV Sastry", 0, 0.00, 0.00, 0.00, 0.00, 0,
				0.00, 0.00, 0.00, 0.00);*/


		/*public void projectz() {

			List<Project> projectList3 = new ArrayList<>();
			projectList3.add(project3);

			client3.setProjectList(projectList3);

			financialData13.setProject(project3);
			financialData13.setProjectResource(projectResource7);
			financialData13.setClient(client3);
			financialData14.setProject(project3);
			financialData14.setProjectResource(projectResource7);
			financialData14.setClient(client3);

			List<ProjectResource> projectResourcesList3 = new ArrayList<>();
			projectResourcesList3.add(projectResource7);
			project3.setProjectResourcesList(projectResourcesList3);

			clientService.saveClient(client3);
			projectService.saveProject(project3);
			projectResourceService.saveProjectResource(projectResource7);
			financialDataService.saveFinanceData(financialData13);
			financialDataService.saveFinanceData(financialData14);
		}

		public void projecty() {

			List<Project> projectList2 = new ArrayList<>();
			projectList2.add(project2);
			projectResource4.setProjectList(projectList2);

			client2.setProjectList(projectList2);

			List<SubProject> subProjectList2 = new ArrayList<SubProject>();
			subProjectList2.add(subProject4);
			subProjectList2.add(subProject5);
			subProjectList2.add(subProject6);
			project2.setSubProjectList(subProjectList2);

			financialData7.setProject(project2);
			financialData8.setProject(project2);
			financialData9.setProject(project2);
			financialData10.setProject(project2);
			financialData11.setProject(project2);
			financialData12.setProject(project2);

			financialData7.setClient(client2);
			financialData8.setClient(client2);
			financialData9.setClient(client2);
			financialData10.setClient(client2);
			financialData11.setClient(client2);
			financialData12.setClient(client2);

			financialData7.setSubProject(subProject4);
			financialData8.setSubProject(subProject5);
			financialData9.setSubProject(subProject6);
			financialData10.setSubProject(subProject4);
			financialData11.setSubProject(subProject5);
			financialData12.setSubProject(subProject6);

			financialData7.setProjectResource(projectResource4);
			financialData8.setProjectResource(projectResource5);
			financialData9.setProjectResource(projectResource6);
			financialData10.setProjectResource(projectResource4);
			financialData11.setProjectResource(projectResource5);
			financialData12.setProjectResource(projectResource6);

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
			financialDataService.saveFinanceData(financialData7);
			financialDataService.saveFinanceData(financialData8);
			financialDataService.saveFinanceData(financialData9);
			financialDataService.saveFinanceData(financialData10);
			financialDataService.saveFinanceData(financialData11);
			financialDataService.saveFinanceData(financialData12);
		}*/

	/*	public void projectx() {

			List<Project> projectList1 = new ArrayList<>();
			projectList1.add(project1);
			projectResource1.setProjectList(projectList1);

			client1.setProjectList(projectList1);

			financialData1.setProject(project1);
			financialData2.setProject(project1);
			financialData3.setProject(project1);
			financialData4.setProject(project1);
			financialData5.setProject(project1);
			financialData6.setProject(project1);

			financialData1.setClient(client1);
			financialData2.setClient(client1);
			financialData3.setClient(client1);
			financialData4.setClient(client1);
			financialData5.setClient(client1);
			financialData6.setClient(client1);

			financialData1.setSubProject(subProject1);
			financialData2.setSubProject(subProject2);
			financialData3.setSubProject(subProject3);
			financialData4.setSubProject(subProject1);
			financialData5.setSubProject(subProject2);
			financialData6.setSubProject(subProject3);

			financialData1.setProjectResource(projectResource1);
			financialData2.setProjectResource(projectResource2);
			financialData3.setProjectResource(projectResource3);
			financialData4.setProjectResource(projectResource1);
			financialData5.setProjectResource(projectResource2);
			financialData6.setProjectResource(projectResource3);

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

			clientService.saveClient(client1);
			projectService.saveProject(project1);
			projectResourceService.saveProjectResource(projectResource1);
			projectResourceService.saveProjectResource(projectResource2);
			projectResourceService.saveProjectResource(projectResource3);
			financialDataService.saveFinanceData(financialData1);
			financialDataService.saveFinanceData(financialData2);
			financialDataService.saveFinanceData(financialData3);
			financialDataService.saveFinanceData(financialData4);
			financialDataService.saveFinanceData(financialData5);
			financialDataService.saveFinanceData(financialData6);
			subProjectService.saveSubProject(subProject1);
			subProjectService.saveSubProject(subProject2);
			subProjectService.saveSubProject(subProject3);
		}*/

	}

	/*
	 * public static void bubbleSort(int array[]){ int temp; int n =
	 * array.length; for(int i=0; i < n ;i++){ for(int j=1; j<n-1; j++){
	 * if(array[j-1]>array[j]){ temp = array[j-1]; array[j-1] = array[j];
	 * array[j] = temp; } } } }
	 */

}
