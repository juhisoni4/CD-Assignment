package com.frt.service;

import java.util.List;
import java.util.Map;

import com.frt.model.FinancialData;

public interface FinancialDataService {

	public void saveFinanceData(FinancialData financialData);

	public FinancialData getFinanceDataById(Long id);

	public List<FinancialData> getAllFinanceData();
	
	public Map<String, String> getRevenueByProjectManager(String projectManager);
}
