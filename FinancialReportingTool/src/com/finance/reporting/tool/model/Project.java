package com.finance.reporting.tool.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.FetchType;
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
@Table(name="project")
public class Project implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="project_id")
	private Long id;

	private String projectNamePerQB;

	private String projectNamePerQuest;

	private String project_new_existing;

	private String natureOfDeal;

	private String type;

	private String onsiteOffshore;

	private String technology;

	private String subTechnology;

	private String stream;

	private Date endPeriod;

	private String qb;

	private String groupSkill;

	private String requestedBy;

	@ManyToOne(optional=true)
	@JoinColumn(name = "client_id")
	private Client client;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "project_projectResource", 
	joinColumns = { @JoinColumn(name = "project_id", referencedColumnName = "project_id") }, 
	inverseJoinColumns = { @JoinColumn(name = "projectResource_id", referencedColumnName = "projectResource_id") })
	private List<ProjectResource> projectResourcesList;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<SubProject> subProjectList;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
	private List<ManagementTeam> managementTeamList;

	public Project() {

	}

	
	public Long getId() {
		return id;
	}

	public Project(String projectNamePerQB,
			String projectNamePerQuest, String project_new_existing,
			String natureOfDeal, String type, String onsiteOffshore,
			String technology, String subTechnology, String stream,
			Date endPeriod, String qb, String groupSkill, String requestedBy) {
		this.projectNamePerQB = projectNamePerQB;
		this.projectNamePerQuest = projectNamePerQuest;
		this.project_new_existing = project_new_existing;
		this.natureOfDeal = natureOfDeal;
		this.type = type;
		this.onsiteOffshore = onsiteOffshore;
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

	public String getProject_new_existing() {
		return project_new_existing;
	}

	public void setProject_new_existing(String project_new_existing) {
		this.project_new_existing = project_new_existing;
	}

	public String getNatureOfDeal() {
		return natureOfDeal;
	}

	public void setNatureOfDeal(String natureOfDeal) {
		this.natureOfDeal = natureOfDeal;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getOnsiteOffshore() {
		return onsiteOffshore;
	}

	public void setOnsiteOffshore(String onsiteOffshore) {
		this.onsiteOffshore = onsiteOffshore;
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

	public Date getEndPeriod() {
		return endPeriod;
	}

	public void setEndPeriod(Date endPeriod) {
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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

}
