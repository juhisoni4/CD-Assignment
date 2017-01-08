package com.frt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
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

	private String type;

	private String technology;

	private String subTechnology;

	private String stream;

	private Date endPeriod;

	private String qb;

	private String groupSkill;

	@ManyToOne
	private Client client;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID")
	private Set<FinancialData> financialDataList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="PROJECT_ID")
	private Set<SubProject> subProjectList;

	public Project() {

	}

	public Project(String projectNamePerQB, String projectNamePerQuest, boolean isProjectNew, String natureOfDeal,
			String sourceOfBusiness, String type, String technology, String subTechnology, String stream,
			Date endPeriod, String qb, String groupSkill) {
		this.projectNamePerQB = projectNamePerQB;
		this.projectNamePerQuest = projectNamePerQuest;
		this.isProjectNew = isProjectNew;
		this.natureOfDeal = natureOfDeal;
		this.sourceOfBusiness = sourceOfBusiness;
		this.type = type;
		this.technology = technology;
		this.subTechnology = subTechnology;
		this.stream = stream;
		this.endPeriod = endPeriod;
		this.qb = qb;
		this.groupSkill = groupSkill;		
	}

	public Long getId() {
		return id;
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

	public String getSourceOfBusiness() {
		return sourceOfBusiness;
	}

	public void setSourceOfBusiness(String sourceOfBusiness) {
		this.sourceOfBusiness = sourceOfBusiness;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<FinancialData> getFinancialDataList() {
		return financialDataList;
	}

	public void setFinancialDataList(Set<FinancialData> financialDataList) {
		this.financialDataList = financialDataList;
	}

	public Set<SubProject> getSubProjectList() {
		return subProjectList;
	}

	public void setSubProjectList(Set<SubProject> subProjectList) {
		this.subProjectList = subProjectList;
	}

}
