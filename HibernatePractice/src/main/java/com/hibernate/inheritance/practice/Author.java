package com.hibernate.inheritance.practice;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Author extends Person {

	@ManyToOne
	@JoinColumn(name = "publisher_name")
	private Publisher publisher;

	@ManyToMany(mappedBy = "author")
	private List<Book> book;

	public Author() {

	}

	public Author(String name) {
		this.name = name;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	public List<Book> getBook() {
		return book;
	}

	public void setBook(List<Book> book) {
		this.book = book;
	}

	@Override
	public String toString() {
		return "Author [publisher=" + publisher + "]";
	}	

}
