package com.frt.model.DTO;

public class FinancialDataDTO {
	
	private String month;
	
	private Double revenue;
	
	private Double cost;
	
	private Double actualProjectMargin;
	
	private Double actualProjectMarginPercentage;	
	
	private String clientName;	
	
	public FinancialDataDTO() {
		
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Double getRevenue() {
		return revenue;
	}

	public void setRevenue(Double revenue) {
		this.revenue = revenue;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Double getActualProjectMargin() {
		return actualProjectMargin;
	}

	public void setActualProjectMargin(Double actualProjectMargin) {
		this.actualProjectMargin = actualProjectMargin;
	}

	public Double getActualProjectMarginPercentage() {
		return actualProjectMarginPercentage;
	}

	public void setActualProjectMarginPercentage(
			Double actualProjectMarginPercentage) {
		this.actualProjectMarginPercentage = actualProjectMarginPercentage;
	}
	
	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "FinancialDataDTO [month=" + month + ", revenue=" + revenue
				+ ", cost=" + cost + ", actualProjectMargin="
				+ actualProjectMargin + ", actualProjectMarginPercentage="
				+ actualProjectMarginPercentage + ", clientName=" + clientName
				+ "]";
		}

	
}
