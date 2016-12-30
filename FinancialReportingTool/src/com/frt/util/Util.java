package com.frt.util;

import com.frt.model.FinancialData;

public class Util {

	public static Double get(FinancialData financialData, String typeOfData) {

		String typeOfFinanceData = typeOfData;
		
		if (typeOfFinanceData.equals("Revenue")) {
			Double data1 = financialData.getActualRevenue();
			return data1;
		} else if (typeOfFinanceData.equals("Cost")) {
			Double data2 = financialData.getActualCost();
			return data2;
		} else {
			Double data3 = financialData.getActualMarginPercentage();
			return data3;
		}
	}

}
