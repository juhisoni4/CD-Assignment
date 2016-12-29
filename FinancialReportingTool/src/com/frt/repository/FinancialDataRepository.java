package com.frt.repository;

import java.util.List;
import java.util.Map;

import com.frt.model.FinancialData;

public interface FinancialDataRepository {

	public void saveFinanceData(FinancialData financialData);
	
	public FinancialData getaddFinanceDataById(Long id);
	
	public List<FinancialData> getAlladdFinanceData();
	
	public Map<String, String> getRevenueByProjectManager(String projectManager);
}
