package com.frt.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FinancialData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String month;

	private Integer year;
	
	private String projectManager;

	private String salesHead;

	private String salesPerson;

	private String deliveryHead;

	private Integer hrs_days;

	private Double actualRevenue;

	private Double actualCost;

	private Double actualProjectMargin;

	private Double actualMarginPercentage;

	private Integer hrs_daysYear;

	private Double actualRevenueYear;

	private Double actualCostYear;

	private Double actualProjectMarginYear;

	private Double actualMarginPercentageYear;

	@OneToOne(cascade = CascadeType.ALL)
	private Project project;

	@OneToOne(cascade = CascadeType.ALL)
	private ProjectResource projectResource;

	@OneToOne(cascade = CascadeType.ALL)
	private Client client;

	@OneToOne(cascade = CascadeType.ALL)
	private SubProject subProject;

	public FinancialData() {

	}
	
	public FinancialData(String month, Integer year, String projectManager, String salesHead,
			String salesPerson, String deliveryHead, Integer hrs_days,
			Double actualRevenue, Double actualCost,
			Double actualProjectMargin, Double actualMarginPercentage,
			Integer hrs_daysYear, Double actualRevenueYear,
			Double actualCostYear, Double actualProjectMarginYear,
			Double actualMarginPercentageYear) {
		this.month = month;
		this.year = year;
		this.projectManager = projectManager;
		this.salesHead = salesHead;
		this.salesPerson = salesPerson;
		this.deliveryHead = deliveryHead;
		this.hrs_days = hrs_days;
		this.actualRevenue = actualRevenue;
		this.actualCost = actualCost;
		this.actualProjectMargin = actualProjectMargin;
		this.actualMarginPercentage = actualMarginPercentage;
		this.hrs_daysYear = hrs_daysYear;
		this.actualRevenueYear = actualRevenueYear;
		this.actualCostYear = actualCostYear;
		this.actualProjectMarginYear = actualProjectMarginYear;
		this.actualMarginPercentageYear = actualMarginPercentageYear;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}	

	public Integer getHrs_days() {
		return hrs_days;
	}

	public void setHrs_days(Integer hrs_days) {
		this.hrs_days = hrs_days;
	}

	public Double getActualRevenue() {
		return actualRevenue;
	}

	public void setActualRevenue(Double actualRevenue) {
		this.actualRevenue = actualRevenue;
	}

	public Double getActualCost() {
		return actualCost;
	}

	public void setActualCost(Double actualCost) {
		this.actualCost = actualCost;
	}

	public Double getActualProjectMargin() {
		return actualProjectMargin;
	}

	public void setActualProjectMargin(Double actualProjectMargin) {
		this.actualProjectMargin = actualProjectMargin;
	}

	public Double getActualMarginPercentage() {
		return actualMarginPercentage;
	}

	public void setActualMarginPercentage(Double actualMarginPercentage) {
		this.actualMarginPercentage = actualMarginPercentage;
	}

	public Integer getHrs_daysYear() {
		return hrs_daysYear;
	}

	public void setHrs_daysYear(Integer hrs_daysYear) {
		this.hrs_daysYear = hrs_daysYear;
	}

	public Double getActualRevenueYear() {
		return actualRevenueYear;
	}

	public void setActualRevenueYear(Double actualRevenueYear) {
		this.actualRevenueYear = actualRevenueYear;
	}

	public Double getActualCostYear() {
		return actualCostYear;
	}

	public void setActualCostYear(Double actualCostYear) {
		this.actualCostYear = actualCostYear;
	}

	public Double getActualProjectMarginYear() {
		return actualProjectMarginYear;
	}

	public void setActualProjectMarginYear(Double actualProjectMarginYear) {
		this.actualProjectMarginYear = actualProjectMarginYear;
	}

	public Double getActualMarginPercentageYear() {
		return actualMarginPercentageYear;
	}

	public void setActualMarginPercentageYear(Double actualMarginPercentageYear) {
		this.actualMarginPercentageYear = actualMarginPercentageYear;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}

	public String getSalesHead() {
		return salesHead;
	}

	public void setSalesHead(String salesHead) {
		this.salesHead = salesHead;
	}

	public String getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	public String getDeliveryHead() {
		return deliveryHead;
	}

	public void setDeliveryHead(String deliveryHead) {
		this.deliveryHead = deliveryHead;
	}

	public ProjectResource getProjectResource() {
		return projectResource;
	}

	public void setProjectResource(ProjectResource projectResource) {
		this.projectResource = projectResource;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public SubProject getSubProject() {
		return subProject;
	}

	public void setSubProject(SubProject subProject) {
		this.subProject = subProject;
	}

}
