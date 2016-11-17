package com.hibernate.oneToOne.bidirection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table
public class Student {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	
	@OneToOne(mappedBy="student", cascade = CascadeType.ALL)
	private Address address;

	public Student(String name) {
		this.name = name;
	}

	public Student() {

	}

	public Student(String name, Address address) {
		this.name = name;
		this.address = address;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}

//	@Override
//	public String toString() {
//		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
//	}

}
