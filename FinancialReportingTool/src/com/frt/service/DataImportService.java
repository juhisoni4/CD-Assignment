package com.frt.service;

import java.util.List;

import com.frt.model.FinancialData;

public interface DataImportService {
	
	public void saveXlsFileData(List<List<String>> list);

}
