package com.frt.model;

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
@Table(name = "projectresource")
public class ProjectResource implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String resourceCode;

	private String resourceName;

	private String role;

	private String resourceSkill;

	private String locationOfResource;

	private String resource_expenses;

	private String type;

	@ManyToMany(cascade = CascadeType.ALL, mappedBy = "projectResourcesList")
	private List<Project> projectList;

	public ProjectResource() {

	}

	public ProjectResource(String resourceCode, String resourceName,
			String role, String resourceSkill,
			String locationOfResource, String resource_expenses, String type) {
		this.resourceCode = resourceCode;
		this.resourceName = resourceName;
		this.role = role;
		this.resourceSkill = resourceSkill;
		this.locationOfResource = locationOfResource;
		this.resource_expenses = resource_expenses;
		this.type = type;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "ProjectResource [id=" + id + ", resourceCode=" + resourceCode
				+ ", resourceName=" + resourceName + ", role=" + role
				+ ", resourceSkill=" + resourceSkill + ", locationOfResource="
				+ locationOfResource + ", resource_expenses="
				+ resource_expenses + ", type=" + type + "]";
	}

}
