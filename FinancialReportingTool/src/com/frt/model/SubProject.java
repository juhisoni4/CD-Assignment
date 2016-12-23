package com.frt.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class SubProject implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private Long id;

	private String subProjectName;
		
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
