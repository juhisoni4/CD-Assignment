package com.frt.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String clientName;

	private String domain;

	private String region;

	private String clientJoining;

	private boolean display;

	@OneToMany(mappedBy="client")	
	@Cascade({CascadeType.ALL})
	//@JoinColumn(name="CLIENT_ID")
	private Set<Project> projectList;

	@OneToMany(mappedBy="client")
	@Cascade({CascadeType.ALL})
	//@JoinColumn(name = "CLIENT_ID")
	private Set<FinancialData> financeDataList;

	public Client() {

	}

	public Client(String clientName, String domain, String region, String clientJoining) {
		this.clientName = clientName;
		this.domain = domain;
		this.region = region;
		this.clientJoining = clientJoining;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getClientJoining() {
		return clientJoining;
	}

	public void setClientJoining(String clientJoining) {
		this.clientJoining = clientJoining;
	}

	public boolean isDisplay() {
		return display;
	}

	public void setDisplay(boolean display) {
		this.display = display;
	}

	public Set<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(Set<Project> projectList) {
		this.projectList = projectList;
	}

	public Set<FinancialData> getFinanceDataList() {
		return financeDataList;
	}

	public void setFinanceDataList(Set<FinancialData> financeDataList) {
		this.financeDataList = financeDataList;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", clientName=" + clientName + ", domain=" + domain + ", region=" + region
				+ ", clientJoining=" + clientJoining + "]";
	}

}
