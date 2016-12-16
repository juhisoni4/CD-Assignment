package com.hibernate.inheritance.practice;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Publisher extends Person {

//	@Id
//	@Column(name = "publisher_id")
//	private int id;
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}

	@Column(name = "tax_id")
	private String taxId;

	@OneToMany(mappedBy = "publisher")
	private List<Author> author;

	public Publisher() {

	}

	public Publisher(String name, String taxId) {
		this.name = name;
		this.taxId = taxId;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public List<Author> getAuthor() {
		return author;
	}

	public void setAuthor(List<Author> author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Publisher [taxId=" + taxId + ", author=" + author + "]";
	}

}
