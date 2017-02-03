package com.frt.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String projectNamePerQB;

	private String projectNamePerQuest;

	private Boolean isProjectNew;

	private String natureOfDeal;

	private String sourceOfBusiness;

	private String type;

	private String technology;

	private String subTechnology;

	private String stream;

	private String endPeriod;

	private String qb;

	private String groupSkill;

	@ManyToOne
	@Cascade({CascadeType.ALL})
	private Client client;

	@OneToMany(mappedBy="project")	
	//@JoinColumn(name="PROJECT_ID")
	private Set<FinancialData> financialDataList;

	@OneToMany(mappedBy="project")
	@Cascade({CascadeType.ALL})
	//@JoinColumn(name="PROJECT_ID")
	private Set<SubProject> subProjectList;

	public Project() {

	}

	public Project(String projectNamePerQB, String projectNamePerQuest, Boolean isProjectNew, String natureOfDeal,
			String sourceOfBusiness, String type, String technology, String subTechnology, String stream,
			String endPeriod, String qb, String groupSkill) {
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

	public Boolean isProjectNew() {
		return isProjectNew;
	}

	public void setProjectNew(Boolean isProjectNew) {
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

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectNamePerQB=" + projectNamePerQB
				+ ", projectNamePerQuest=" + projectNamePerQuest
				+ ", isProjectNew=" + isProjectNew + ", natureOfDeal="
				+ natureOfDeal + ", sourceOfBusiness=" + sourceOfBusiness
				+ ", type=" + type + ", technology=" + technology
				+ ", subTechnology=" + subTechnology + ", stream=" + stream
				+ ", endPeriod=" + endPeriod + ", qb=" + qb + ", groupSkill="
				+ groupSkill + "]";
	}

}
