package com.frt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frt.model.FinancialData;
import com.frt.service.FinancialDataService;
import com.frt.util.Util;

@RestController
@RequestMapping(value = "/financeData")
public class FinancialDataController {

	@Autowired
	FinancialDataService financialDataService;
	

	@RequestMapping(value = "/list")	
	public Map<String, Double> getFinanceDataByManagementTeamPerson(
			String managementTeamPerson, String typeOfData) {

		List<FinancialData> financeDataList = new ArrayList<>();
		Map<String, Double> revenueOfManagementTeamPerson = new HashMap<>();
		String typeOfFinanceData = "Cost";
		
		Double totalFinanceDataPerJanuary = 0.0;
		Double totalFinanceDataPerFebruary = 0.0;
		Double totalFinanceDataPerMarch = 0.0;
		Double totalFinanceDataPerApril = 0.0;
		Double totalFinanceDataPerMay = 0.0;
		Double totalFinanceDataPerJune = 0.0;
		Double totalFinanceDataPerJuly = 0.0;
		Double totalFinanceDataPerAugust = 0.0;
		Double totalFinanceDataPerSeptember = 0.0;
		Double totalFinanceDataPerOctober = 0.0;
		Double totalFinanceDataPerNovember = 0.0;
		Double totalFinanceDataPerDecember = 0.0;

		financeDataList = financialDataService.getRevenueByProjectManager(
				"april", "may", 2016, "projectManager","Anand Shah");

		for (FinancialData data : financeDataList) {
			
			Double financeData = Util.get(data, typeOfFinanceData);
			String month = data.getMonth();
			
			switch (month) {

			case "january":
				totalFinanceDataPerJanuary += financeData;
				revenueOfManagementTeamPerson.put("january",
						totalFinanceDataPerJanuary);
				break;

			case "february":

				totalFinanceDataPerFebruary += financeData;
				revenueOfManagementTeamPerson.put("february",
						totalFinanceDataPerFebruary);
				break;

			case "march":
				totalFinanceDataPerMarch += financeData;
				revenueOfManagementTeamPerson.put("march",
						totalFinanceDataPerMarch);
				break;

			case "april":
				totalFinanceDataPerApril += financeData;
				revenueOfManagementTeamPerson.put("april",
						totalFinanceDataPerApril);
				break;

			case "may":
				totalFinanceDataPerMay += financeData;
				revenueOfManagementTeamPerson
						.put("may", totalFinanceDataPerMay);
				break;

			case "june":
				totalFinanceDataPerJune += financeData;
				revenueOfManagementTeamPerson.put("june",
						totalFinanceDataPerJune);
				break;

			case "july":
				totalFinanceDataPerJuly += financeData;
				revenueOfManagementTeamPerson.put("july",
						totalFinanceDataPerJuly);
				break;

			case "august":
				totalFinanceDataPerAugust += financeData;
				revenueOfManagementTeamPerson.put("august",
						totalFinanceDataPerAugust);
				break;

			case "september":
				totalFinanceDataPerSeptember += financeData;
				revenueOfManagementTeamPerson.put("september",
						totalFinanceDataPerSeptember);
				break;

			case "october":
				totalFinanceDataPerOctober += financeData;
				revenueOfManagementTeamPerson.put("october",
						totalFinanceDataPerOctober);
				break;

			case "november":
				totalFinanceDataPerNovember += financeData;
				revenueOfManagementTeamPerson.put("november",
						totalFinanceDataPerNovember);
				break;

			case "december":
				totalFinanceDataPerDecember += financeData;
				revenueOfManagementTeamPerson.put("december",
						totalFinanceDataPerDecember);
				break;
			}
		}

		return revenueOfManagementTeamPerson;
	}
}
