package com.frt.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class SubProject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String subProjectName;
	
	@ManyToOne
	@Cascade({CascadeType.ALL})
	private Project project;
		
	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public SubProject() {

	}
	
	public SubProject(String subProjectName) {
		this.subProjectName = subProjectName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSubProjectName() {
		return subProjectName;
	}

	public void setSubProjectName(String subProjectName) {
		this.subProjectName = subProjectName;
	}

	@Override
	public String toString() {
		return "SubProject [id=" + id + ", subProjectName=" + subProjectName
				+ "]";
	}	
		
}
