package com.crud.mvc.spring.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class StudentLoggin {

	@Id
	@GeneratedValue
	@Column(name="studentLoggin_id")
	private Integer id;
	
	@Column(name="userName")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@OneToOne
	@PrimaryKeyJoinColumn
    private Student student;
	
	public StudentLoggin() {
		
	}

	public StudentLoggin(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "StudentLoggin [id=" + id + ", userName=" + userName
				+ ", password=" + password + ", student=" + student + "]";
	}
	
}
