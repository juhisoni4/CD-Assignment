package com.crud.mvc.spring.hibernate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;	
	
	@Column(name="firstName")
	private String firstName;
	
	@Column(name="lastName")
	private String lastName;	
	
	@Column(name="email")
	private String email;
	
	@OneToOne(mappedBy="student" ,cascade= CascadeType.ALL)
	private StudentLoggin studentLoggin;
	
	public Student() {
		
	}

	public Student(Integer id, String firstName, String lastName, String email) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public StudentLoggin getStudentLoggin(){
		return studentLoggin;
	}

	public void setStudentLoggin(StudentLoggin studentLoggin) {
		this.studentLoggin = studentLoggin;
	}	
	
}
