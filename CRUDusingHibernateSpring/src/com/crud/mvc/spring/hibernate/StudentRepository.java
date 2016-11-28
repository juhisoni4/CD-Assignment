package com.crud.mvc.spring.hibernate;

import java.util.List;

public interface StudentRepository {

	public List<Student> listStudent();
	
	public void saveOrUpdate(Student student);
	
	public void deleteStudent(int id);
	
	public Student getStudent(int id);
	
}
