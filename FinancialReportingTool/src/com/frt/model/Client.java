package com.frt.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Client implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	private String clientName;
	
	private String domain;
	
	private String region;
	
	private String clientJoining;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Project> projectList;
			
	public Client() {
		
	}

	public Client(String clientName, String domain, String region,
			String clientJoining) {
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

	public List<Project> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<Project> projectList) {
		this.projectList = projectList;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", clientName=" + clientName + ", domain="
				+ domain + ", region=" + region + ", clientJoining="
				+ clientJoining + "]";
	}
	
		
}
