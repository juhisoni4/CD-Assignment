package com.frt.repository;

import java.util.List;
import java.util.Map;

import com.frt.model.FinancialData;

public interface FinancialDataRepository {

	public void saveFinanceData(FinancialData financialData);
	
	public FinancialData getaddFinanceDataById(Long id);
	
	public List<FinancialData> getAlladdFinanceData();
	
	public List<FinancialData> getRevenueByProjectManager(String month1, String month2, Integer year,String managementTeam, String managementTeamPersonName);
}
