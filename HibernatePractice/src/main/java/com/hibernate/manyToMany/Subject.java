package com.hibernate.manyToMany;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table
public class Subject {

	@Id
	@GeneratedValue
	@Column(name = "subject_id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "subjectList")
	private List<Student> student;

	public Subject() {

	}
	
	public Subject(String name) {
		this.name = name;
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

	public List<Student> getStudent() {
		return student;
	}

	public void setStudent(List<Student> student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Subject [id=" + id + ", name=" + name + ", student=" + student + "]";
	}

//	@Override
//	public String toString() {
//		return "Subject [id=" + id + ", name=" + name + "]";
//	}
	
	
}
