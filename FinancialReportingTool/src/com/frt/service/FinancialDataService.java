package com.frt.service;

import java.util.List;
import java.util.Map;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.DTO.FinancialDataDTO;
import com.frt.model.FinancialData.Month;

public interface FinancialDataService {

	public void saveFinanceData(FinancialData financialData);

	public FinancialData getFinanceDataById(Long id);

	public List<FinancialData> getAllFinanceData();
	
	public List<FinancialData> getFinancialDataOfYear(long year1, long year2);
	
	public List<FinancialData> getFinancialDataByClient(Client client);
	
	public List<FinancialData> getFinanceDataByClient(Client client, Month month1, Month month2,String typeOfData,long year);
	
	public List<FinancialData> getRevenueByProjectManager(String month1, String month2, long year,Client client);
	
	public List<FinancialData> search(FinancialData FinancialData);	
	
	public List<FinancialDataDTO> calculateFinanceData(
			List<FinancialDataDTO> financialDataDTOList,			
			List<FinancialData> financeDataList, String typeOfFinanceData);
}
