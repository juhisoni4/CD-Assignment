package com.crud.mvc.spring.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class StudentDao {

	@Autowired
	public SessionFactory factory;

	public List<Student> listStudent() {

		List<Student> studentList = new ArrayList<>();

		studentList = factory.getCurrentSession().createQuery("from Student")
				.list();

		return studentList;
	}

	public void saveOrUpdate(Student student) {

		factory.getCurrentSession().saveOrUpdate(student);
	}

	public void deleteStudent(int id) {

		Student student = getStudent(id);
		
		factory.getCurrentSession().delete(student);
	}

	public Student getStudent(int id) {
		
       Session session = factory.getCurrentSession();
		
		Student student = (Student) session.get(Student.class, id);
		
		return student;
		
	}
}
