package com.crud.mvc.spring.hibernate;

import java.util.List;

public interface StudentRepository {

	public List<Student> listStudent();

	public void saveOrUpdate(Student student);

	//public void save(Student student);

	//public void update(Student student);

	public void deleteStudent(String id);

	public Student getStudent(String id);

}
