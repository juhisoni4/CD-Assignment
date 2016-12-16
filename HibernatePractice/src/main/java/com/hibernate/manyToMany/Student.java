package com.hibernate.manyToMany;

import java.util.List;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	
	@Id
	@GeneratedValue
	@Column(name="student_id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "student_subject",
	joinColumns = {@JoinColumn(name = "student_id")},
	inverseJoinColumns = {@JoinColumn(name = "subject_id")})
	private List<Subject> subjectList;

	public Student(String name) {
		this.name = name;
	}

	public Student() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", subjectList=" + subjectList + "]";
//	}
		
}
