package com.crud.mvc.spring.hibernate;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
@Entity
public class StudentProfile {
	
	@Id
	@GeneratedValue
	@Column(name="studentProfile_id")
	private Integer id;
	
	@Column(name="userRole")
	private String userRole;
	
	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@ManyToMany(mappedBy="studentProfileList")	
	private List<Student> student;
	
	public StudentProfile() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}	
	
}
