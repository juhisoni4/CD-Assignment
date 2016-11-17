package com.hibernate.oneToMany.unidirection;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

//	@ManyToOne(optional = false)
//  @JoinColumn(name = "University_ID")
//  private University university;
	
	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
	private List<University> university;
	
	public Student() {

	}
	
	public Student(String name) {
		this.name = name;
	}


//	public Student(String name, University university) {
//		this.name = name;
//		this.university = university;
//	}

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

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", university=" + university + "]";
	}

	public List<University> getUniversity() {
		return university;
	}

	public void setUniversity(List<University> university) {
		this.university = university;
	}

	///////////Below code for @ManyToOne////////
//	 public University getUniversity() {
//	 return university;
//	}
//
//	 public void setUniversity(University university) {
//	 this.university = university;
//	 }
	
}
