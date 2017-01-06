package com.frt.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class FinancialData implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private boolean isOnSite;
	
	private String roleOfResource;
	
	private String requestedBy;
	
	private String resourceSkill;
	
	private String locationOfResource;
	
	private String resourceExpense;
	
	public enum Month{
		JAN, FEB, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
	}
	
	private Month month;

	private long year;	

	private long hrs_days;

	private Double actualRevenue;

	private Double actualCost;

	private Double actualProjectMargin;

	private Double actualMarginPercentage;

	//private Integer hrs_daysYear;

	//private Double actualRevenueYear;

	//private Double actualCostYear;

	//private Double actualProjectMarginYear;

	//private Double actualMarginPercentageYear;

	@ManyToOne(cascade = CascadeType.ALL)
	private Project project;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Client client;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee projectResource;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee projectManager;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee salesHead;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee salesPerson;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Employee deliveryHead;

	public FinancialData() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean isOnSite() {
		return isOnSite;
	}

	public void setOnSite(boolean isOnSite) {
		this.isOnSite = isOnSite;
	}

	public String getRoleOfResource() {
		return roleOfResource;
	}

	public void setRoleOfResource(String roleOfResource) {
		this.roleOfResource = roleOfResource;
	}

	public String getReuestedBy() {
		return requestedBy;
	}

	public void setReuestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public String getResourceSkill() {
		return resourceSkill;
	}

	public void setResourceSkill(String resourceSkill) {
		this.resourceSkill = resourceSkill;
	}

	public String getLocationOfResource() {
		return locationOfResource;
	}

	public void setLocationOfResource(String locationOfResource) {
		this.locationOfResource = locationOfResource;
	}

	public String getResourceExpense() {
		return resourceExpense;
	}

	public void setResourceExpense(String resourceExpense) {
		this.resourceExpense = resourceExpense;
	}

	public Month getMonth() {
		return month;
	}

	public void setMonth(Month month) {
		this.month = month;
	}

	public long getYear() {
		return year;
	}

	public void setYear(long year) {
		this.year = year;
	}

	public long getHrs_days() {
		return hrs_days;
	}

	public void setHrs_days(long hrs_days) {
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

	/*public Integer getHrs_daysYear() {
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
	}*/

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getProjectResource() {
		return projectResource;
	}

	public void setProjectResource(Employee projectResource) {
		this.projectResource = projectResource;
	}

	public Employee getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(Employee projectManager) {
		this.projectManager = projectManager;
	}

	public Employee getSalesHead() {
		return salesHead;
	}

	public void setSalesHead(Employee salesHead) {
		this.salesHead = salesHead;
	}

	public Employee getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(Employee salesPerson) {
		this.salesPerson = salesPerson;
	}

	public Employee getDeliveryHead() {
		return deliveryHead;
	}
	
}
