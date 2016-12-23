package com.frt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.FinancialData;
import com.frt.repository.FinancialDataRepository;
import com.frt.service.FinancialDataService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class FinancialDataServiceImpl implements FinancialDataService {

	@Autowired
	public FinancialDataRepository financialDataRepository;
	
	@Override
	public void saveFinanceData(FinancialData financialData) {
		
		financialDataRepository.saveFinanceData(financialData);
	}

	@Override
	public FinancialData getFinanceDataById(Long id) {
		
		FinancialData financialData = financialDataRepository.getaddFinanceDataById(id);
		return financialData;
	}

	@Override
	public List<FinancialData> getAllFinanceData() {
		
		List<FinancialData> financialDataList = new ArrayList<>();
		financialDataList = financialDataRepository.getAlladdFinanceData();	
		return financialDataList;
	}

}
