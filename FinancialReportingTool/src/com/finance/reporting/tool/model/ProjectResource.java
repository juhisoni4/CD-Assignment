package com.finance.reporting.tool.model;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name="projectresource")
public class ProjectResource implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="projectResource_id")
	private Long id;

	private String resourceCode;

	private String resourceName;

	private String roleOfTheresources;
	
	private String resourceSkill;

	private String locationOfResource;

	private String resource_expenses;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "projectResourcesList")
	private List<Project> projectList;

	public ProjectResource() {

	}

	public ProjectResource(String resourceCode, String resourceName,String roleOfTheresources,
			String resourceSkill, String locationOfResource,
			String resource_expenses) {
		this.resourceCode = resourceCode;
		this.resourceName = resourceName;
		this.roleOfTheresources = roleOfTheresources;
		this.resourceSkill = resourceSkill;
		this.locationOfResource = locationOfResource;
		this.resource_expenses = resource_expenses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getResourceCode() {
		return resourceCode;
	}

	public void setResourceCode(String resourceCode) {
		this.resourceCode = resourceCode;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public String getRoleOfTheresources() {
		return roleOfTheresources;
	}

	public void setRoleOfTheresources(String roleOfTheresources) {
		this.roleOfTheresources = roleOfTheresources;
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

	public String getResource_expenses() {
		return resource_expenses;
	}

	public void setResource_expenses(String resource_expenses) {
		this.resource_expenses = resource_expenses;
	}

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

}
