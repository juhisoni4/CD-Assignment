package com.frt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	private String startDate;
	
	private String endDate;
			
	public ManagementTeam() {
		
	}

	public ManagementTeam(String projectManager, String salesHead,
			String salesPerson, String deliveryHead, String startDate,
			String endDate) {
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

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "ManagementTeam [id=" + id + ", projectManager="
				+ projectManager + ", salesHead=" + salesHead
				+ ", salesPerson=" + salesPerson + ", deliveryHead="
				+ deliveryHead + ", startDate=" + startDate + ", endDate="
				+ endDate + "]";
	}		
}
