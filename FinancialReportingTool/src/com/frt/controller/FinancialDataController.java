package com.frt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.frt.model.FinancialData;
import com.frt.model.FinancialData.Month;
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
			Month month = data.getMonth();
			
			switch (month) {

			case JAN:
				totalFinanceDataPerJanuary += financeData;
				revenueOfManagementTeamPerson.put("january",
						totalFinanceDataPerJanuary);
				break;

			case FEB:

				totalFinanceDataPerFebruary += financeData;
				revenueOfManagementTeamPerson.put("february",
						totalFinanceDataPerFebruary);
				break;

			case MAR:
				totalFinanceDataPerMarch += financeData;
				revenueOfManagementTeamPerson.put("march",
						totalFinanceDataPerMarch);
				break;

			case APR:
				totalFinanceDataPerApril += financeData;
				revenueOfManagementTeamPerson.put("april",
						totalFinanceDataPerApril);
				break;

			case MAY:
				totalFinanceDataPerMay += financeData;
				revenueOfManagementTeamPerson
						.put("may", totalFinanceDataPerMay);
				break;

			case JUN:
				totalFinanceDataPerJune += financeData;
				revenueOfManagementTeamPerson.put("june",
						totalFinanceDataPerJune);
				break;

			case JUL:
				totalFinanceDataPerJuly += financeData;
				revenueOfManagementTeamPerson.put("july",
						totalFinanceDataPerJuly);
				break;

			case AUG:
				totalFinanceDataPerAugust += financeData;
				revenueOfManagementTeamPerson.put("august",
						totalFinanceDataPerAugust);
				break;

			case SEP:
				totalFinanceDataPerSeptember += financeData;
				revenueOfManagementTeamPerson.put("september",
						totalFinanceDataPerSeptember);
				break;

			case OCT:
				totalFinanceDataPerOctober += financeData;
				revenueOfManagementTeamPerson.put("october",
						totalFinanceDataPerOctober);
				break;

			case NOV:
				totalFinanceDataPerNovember += financeData;
				revenueOfManagementTeamPerson.put("november",
						totalFinanceDataPerNovember);
				break;

			case DEC:
				totalFinanceDataPerDecember += financeData;
				revenueOfManagementTeamPerson.put("december",
						totalFinanceDataPerDecember);
				break;
			}
		}

		return revenueOfManagementTeamPerson;
	}
	
	public void saveFinancialData(FinancialData financialData){
		
		financialDataService.saveFinanceData(financialData);
	}
	
	public FinancialData getFinancialDataById(Long id){
		
		FinancialData financialData = financialDataService.getFinanceDataById(id);
		return financialData;
	}
	
	public List<FinancialData> getAllFinancialData(){
		
		List<FinancialData> financialDataList = new ArrayList<>();
		financialDataList = financialDataService.getAllFinanceData();
		return financialDataList;		
	}
}
