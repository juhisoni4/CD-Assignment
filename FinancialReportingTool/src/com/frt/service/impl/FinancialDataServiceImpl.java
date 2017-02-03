package com.frt.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.Client;
import com.frt.model.FinancialData;
import com.frt.model.DTO.FinancialDataDTO;
import com.frt.model.FinancialData.Month;
import com.frt.repository.FinancialDataRepository;
import com.frt.service.FinancialDataService;
import com.frt.util.Util;

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

		FinancialData financialData = financialDataRepository
				.getaddFinanceDataById(id);
		return financialData;
	}

	@Override
	public List<FinancialData> getAllFinanceData() {

		List<FinancialData> financialDataList = new ArrayList<>();
		financialDataList = financialDataRepository.getAlladdFinanceData();
		return financialDataList;
	}

	@Override
	public List<FinancialData> getRevenueByProjectManager(String month1,
			String month2, long year, Client client) {

		List<FinancialData> totalRevenue = new ArrayList<>();
		totalRevenue = financialDataRepository.getRevenueByProjectManager(
				month1, month2, year, client);
		return totalRevenue;
	}

	@Override
	public List<FinancialData> search(FinancialData FinancialData) {

		return financialDataRepository.search(FinancialData);
	}

	@Override
	public List<FinancialData> getFinanceDataByClient(Client client,
			Month month1, Month month2, String typeOfData, long year) {

		return financialDataRepository.getFinanceDataByClient(client, month1,
				month2, typeOfData, year);
	}

	@Override
	public List<FinancialData> getFinancialDataOfYear(long year1, long year2) {

		return financialDataRepository.getFinancialDataOfYear(year1, year2);
	}

	public List<FinancialDataDTO> objectFactory(
			List<FinancialDataDTO> financialDataDTOList,
			Double totalFinanceDataPerMonth, String month) {

		FinancialDataDTO financialDataDTO = new FinancialDataDTO();
		financialDataDTO.setRevenue(totalFinanceDataPerMonth);
		financialDataDTO.setMonth(month);
		financialDataDTOList.add(financialDataDTO);
		return financialDataDTOList;
	}

	public List<FinancialDataDTO> calculateFinanceData(
			List<FinancialDataDTO> financialDataDTOList,			
			List<FinancialData> financeDataList, String typeOfFinanceData) {

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

		for (FinancialData data : financeDataList) {

			Double financeData = Util.get(data, typeOfFinanceData);
			Month month = data.getMonth();

			switch (month) {
			case JAN:
				totalFinanceDataPerJanuary += financeData;
				break;

			case FEB:
				totalFinanceDataPerFebruary += financeData;
				break;

			case MAR:
				totalFinanceDataPerMarch += financeData;
				break;

			case APR:
				totalFinanceDataPerApril += financeData;
				break;

			case MAY:
				totalFinanceDataPerMay += financeData;
				break;

			case JUN:
				totalFinanceDataPerJune += financeData;
				break;

			case JUL:
				totalFinanceDataPerJuly += financeData;
				break;

			case AUG:
				totalFinanceDataPerAugust += financeData;
				break;

			case SEP:
				totalFinanceDataPerSeptember += financeData;
				break;

			case OCT:
				totalFinanceDataPerOctober += financeData;
				break;

			case NOV:
				totalFinanceDataPerNovember += financeData;
				break;

			case DEC:
				totalFinanceDataPerDecember += financeData;
				break;
			}

		}

		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerJanuary, "JAN");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerFebruary, "FEB");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerMarch, "MAR");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerApril, "APR");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerMay, "MAY");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerJune, "JUN");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerJuly, "JUL");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerAugust, "AUG");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerSeptember, "SEP");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerOctober, "OCT");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerNovember, "NOV");
		financialDataDTOList = objectFactory(financialDataDTOList,
				totalFinanceDataPerDecember, "DEC");

		return financialDataDTOList;

	}

	@Override
	public List<FinancialData> getFinancialDataByClient(
			Client client) {

		return financialDataRepository.getFinancialDataByClient(client);

	}

}
