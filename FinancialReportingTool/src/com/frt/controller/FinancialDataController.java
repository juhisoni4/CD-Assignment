package com.frt.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.frt.model.FinancialData;
import com.frt.model.FinancialData.Month;
import com.frt.model.DTO.FinancialDataDTO;
import com.frt.service.FinancialDataService;
import com.frt.util.Util;

@RestController
@RequestMapping(value = "/financeData")
public class FinancialDataController {

	@Autowired
	FinancialDataService financialDataService;

	@RequestMapping(value = "/list2")
	public List<FinancialDataDTO> getFinanceDataByManagementTeamPerson() {

		List<FinancialDataDTO> financialDataDTOList1 = new ArrayList<>();
		List<FinancialDataDTO> financialDataDTOList2 = new ArrayList<>();
		String typeOfFinanceData = "Revenue";
		String typeOfFinanceData1 = "Cost";
		
		List<FinancialData> financeDataList = financialDataService
				.getFinancialDataOfYear(2015, 2016);

		financialDataDTOList1 = financialDataService.calculateFinanceData(financialDataDTOList1,
				financeDataList, typeOfFinanceData);
		financialDataDTOList2 = financialDataService.calculateFinanceData(financialDataDTOList2,
				financeDataList, typeOfFinanceData1);

		int i = 0;

		for (FinancialDataDTO financialDataDTO2 : financialDataDTOList2) {
			Double data = financialDataDTO2.getRevenue();			
			financialDataDTOList1.get(i).setCost(data);	
			Double data2 = financialDataDTOList1.get(i).getRevenue();
			Double margin = data2 - data;
			Double marginPer = (margin/data2)*100;
			System.out.println(margin);
			System.out.println(marginPer);
			financialDataDTOList1.get(i).setActualProjectMargin(margin);
			financialDataDTOList1.get(i).setActualProjectMarginPercentage(marginPer);
			i++;
		}

		return financialDataDTOList1;
	}

	public void saveFinancialData(FinancialData financialData) {

		financialDataService.saveFinanceData(financialData);
	}

	public FinancialData getFinancialDataById(Long id) {

		FinancialData financialData = financialDataService
				.getFinanceDataById(id);
		return financialData;
	}

	public List<FinancialData> getAllFinancialData() {

		List<FinancialData> financialDataList = new ArrayList<>();
		financialDataList = financialDataService.getAllFinanceData();
		return financialDataList;
	}

}
