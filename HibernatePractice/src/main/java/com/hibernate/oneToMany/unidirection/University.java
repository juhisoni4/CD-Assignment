package com.hibernate.oneToMany.unidirection;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class University {

	@Id
	@GeneratedValue
	@Column(name="University_ID")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="country")
	private String country;	
	
	//@OneToMany(mappedBy = "university", cascade = CascadeType.ALL)
   //private List<Student> students;
	
	@ManyToOne(optional = true)
	@JoinColumn(name="id")
	private Student student;
 
//	public List<Student> getStudents() {
//		return students;
//	}
//
//	public void setStudents(List<Student> students) {
//		this.students = students;
//	}

	public University() {

	}

	public University(String name, String country) {
		this.name = name;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "University [id=" + id + ", name=" + name + ", country=" + country + "]";
	}

	public Student getStudents() {
		return student;
	}

	public void setStudents(Student student) {
		this.student = student;
	}		
	
}
