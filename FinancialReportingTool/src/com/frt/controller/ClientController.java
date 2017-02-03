package com.frt.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.DTO.FinancialDataDTO;
import com.frt.model.FinancialData.Month;
import com.frt.repository.FinancialDataRepository;
import com.frt.service.ClientService;
import com.frt.service.FinancialDataService;
import com.frt.util.Util;

@RestController
@RequestMapping(value = "/client")
public class ClientController {

	@Autowired
	ClientService clientService;

	@Autowired
	FinancialDataService financialDataService;

	@RequestMapping(value = "/list1")
	public List<FinancialDataDTO> getRevenueByClientName() {

		List<FinancialDataDTO> financialDataDTOList1 = new ArrayList<>();		
		
		List<Client> clientList = clientService.getAllClient();

		for (Client client : clientList) {
			
			FinancialDataDTO financialDataDTO = new FinancialDataDTO();
			
			Double revenue = 0.0 ;
			Double cost = 0.0;			
			
			List<FinancialData> financeDataList = financialDataService
					.getFinancialDataByClient(client);
			
			for(FinancialData financialData:financeDataList){
				
				revenue += financialData.getActualRevenue();
				cost += financialData.getActualCost();
				Double margin = revenue - cost;
				Double marginPer = (margin/revenue)*100;
				
				financialDataDTO.setClientName(client.getClientName());
				financialDataDTO.setRevenue(revenue);
				financialDataDTO.setCost(cost);
				financialDataDTO.setActualProjectMargin(margin);
				financialDataDTO.setActualProjectMarginPercentage(marginPer);
				
				financialDataDTOList1.add(financialDataDTO);
				
			}			
			

		}
		
		return financialDataDTOList1;

	}

	public void saveClient(Client client) {

		clientService.saveClient(client);
	}

	public void getClientById(Long id) {

		Client client = clientService.getClientById(id);
	}

	public void getAllClient() {

		List<Client> clientList = clientService.getAllClient();
	}
}
