package com.hibernate.practice.oneToOne.unidirection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	@GeneratedValue
	@Column(name="id")
	private long addressId;
	
	@Column(name="street")
	private String street;
	
	@Column(name="city")
	private String city;
	
	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	public Address() {
		
	}

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
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
		return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + "]";
	}
	
}
