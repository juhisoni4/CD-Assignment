package com.hibernate.oneToOne.bidirection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Address {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int addressId;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	@OneToOne
	@PrimaryKeyJoinColumn
    private Student student;
	
	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Address() {
		
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", student=" + student
				+ "]";
	}
	
}
