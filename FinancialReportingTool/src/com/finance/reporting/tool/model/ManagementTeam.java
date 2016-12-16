package com.finance.reporting.tool.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ManagementTeam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String projectManager;
	
	private String salesHead;
	
	private String salesPerson;
	
	private String deliveryHead;
	
	private Date startDate;
	
	private Date endDate;
	
	@ManyToOne(optional=true)
	@JoinColumn(name = "project_id")
	private Project project;
		
	public ManagementTeam() {
		
	}

	public ManagementTeam(String projectManager, String salesHead,
			String salesPerson, String deliveryHead, Date startDate,
			Date endDate) {
		this.projectManager = projectManager;
		this.salesHead = salesHead;
		this.salesPerson = salesPerson;
		this.deliveryHead = deliveryHead;
		this.startDate = startDate;
		this.endDate = endDate;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
		
}
