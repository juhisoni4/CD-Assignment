package com.frt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "project")
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String projectNamePerQB;

	private String projectNamePerQuest;

	private boolean isProjectNew;

	private String natureOfDeal;

	private String sourceOfBusiness;

	private boolean isOnsite;

	private String technology;

	private String subTechnology;

	private String stream;

	private String endPeriod;

	private String qb;

	private String groupSkill;

	private String requestedBy;

	@ManyToMany(cascade = CascadeType.ALL)
	// @JoinTable(name = "project_projectResource", joinColumns = {
	// @JoinColumn(name = "project_id", referencedColumnName = "id") },
	// inverseJoinColumns = { @JoinColumn(name = "projectResource_id",
	// referencedColumnName = "id") })
	private List<ProjectResource> projectResourcesList;

	@OneToMany(cascade = CascadeType.ALL)
	private List<SubProject> subProjectList;

	@OneToMany(cascade = CascadeType.ALL)
	private List<ManagementTeam> managementTeamList;

	public Project() {

	}

	public Long getId() {
		return id;
	}

	public Project(String projectNamePerQB, String projectNamePerQuest,
			String sourceOfBusiness, boolean isProjectNew, String natureOfDeal,
			boolean isOnsite, String technology, String subTechnology,
			String stream, String endPeriod, String qb, String groupSkill,
			String requestedBy) {
		this.projectNamePerQB = projectNamePerQB;
		this.projectNamePerQuest = projectNamePerQuest;
		this.sourceOfBusiness = sourceOfBusiness;
		this.isProjectNew = isProjectNew;
		this.natureOfDeal = natureOfDeal;
		this.isOnsite = isOnsite;
		this.technology = technology;
		this.subTechnology = subTechnology;
		this.stream = stream;
		this.endPeriod = endPeriod;
		this.qb = qb;
		this.groupSkill = groupSkill;
		this.requestedBy = requestedBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectNamePerQB() {
		return projectNamePerQB;
	}

	public void setProjectNamePerQB(String projectNamePerQB) {
		this.projectNamePerQB = projectNamePerQB;
	}

	public String getProjectNamePerQuest() {
		return projectNamePerQuest;
	}

	public void setProjectNamePerQuest(String projectNamePerQuest) {
		this.projectNamePerQuest = projectNamePerQuest;
	}

	public boolean isProjectNew() {
		return isProjectNew;
	}

	public void setProjectNew(boolean isProjectNew) {
		this.isProjectNew = isProjectNew;
	}

	public String getNatureOfDeal() {
		return natureOfDeal;
	}

	public void setNatureOfDeal(String natureOfDeal) {
		this.natureOfDeal = natureOfDeal;
	}

	public boolean isOnsite() {
		return isOnsite;
	}

	public void setOnsite(boolean isOnsite) {
		this.isOnsite = isOnsite;
	}

	public String getTechnology() {
		return technology;
	}

	public void setTechnology(String technology) {
		this.technology = technology;
	}

	public String getSubTechnology() {
		return subTechnology;
	}

	public void setSubTechnology(String subTechnology) {
		this.subTechnology = subTechnology;
	}

	public String getStream() {
		return stream;
	}

	public void setStream(String stream) {
		this.stream = stream;
	}

	public String getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(String endPeriod) {
		this.endPeriod = endPeriod;
	}

	public String getQb() {
		return qb;
	}

	public void setQb(String qb) {
		this.qb = qb;
	}

	public String getGroupSkill() {
		return groupSkill;
	}

	public void setGroupSkill(String groupSkill) {
		this.groupSkill = groupSkill;
	}

	public String getRequestedBy() {
		return requestedBy;
	}

	public void setRequestedBy(String requestedBy) {
		this.requestedBy = requestedBy;
	}

	public List<ProjectResource> getProjectResourcesList() {
		return projectResourcesList;
	}

	public void setProjectResourcesList(
			List<ProjectResource> projectResourcesList) {
		this.projectResourcesList = projectResourcesList;
	}

	public List<SubProject> getSubProjectList() {
		return subProjectList;
	}

	public void setSubProjectList(List<SubProject> subProjectList) {
		this.subProjectList = subProjectList;
	}

	public List<ManagementTeam> getManagementTeamList() {
		return managementTeamList;
	}

	public void setManagementTeamList(List<ManagementTeam> managementTeamList) {
		this.managementTeamList = managementTeamList;
	}

	public String getSourceOfBusiness() {
		return sourceOfBusiness;
	}

	public void setSourceOfBusiness(String sourceOfBusiness) {
		this.sourceOfBusiness = sourceOfBusiness;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectNamePerQB=" + projectNamePerQB
				+ ", projectNamePerQuest=" + projectNamePerQuest
				+ ", isProjectNew=" + isProjectNew + ", natureOfDeal="
				+ natureOfDeal + ", sourceOfBusiness=" + sourceOfBusiness
				+ ", isOnsite=" + isOnsite + ", technology=" + technology
				+ ", subTechnology=" + subTechnology + ", stream=" + stream
				+ ", endPeriod=" + endPeriod + ", qb=" + qb + ", groupSkill="
				+ groupSkill + ", requestedBy=" + requestedBy + "]";
	}	

}
