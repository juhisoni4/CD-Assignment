package com.crud.mvc.spring.hibernate;

import java.util.List;

public interface StudentDaoRepository {

	public List<Student> listStudent();
	
	public Student saveOrUpdate(Student student);
	
	public Student deleteStudent(String id);
	
	public Student getStudent(String id);
	
}
