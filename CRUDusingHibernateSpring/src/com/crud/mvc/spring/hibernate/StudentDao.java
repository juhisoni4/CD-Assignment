package com.crud.mvc.spring.hibernate;

import java.util.ArrayList;


import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDao implements StudentDaoRepository{

	@Autowired
	public SessionFactory factory;

	public List<Student> listStudent() {
		List<Student> studentList = new ArrayList<>();
		studentList = factory.getCurrentSession().createQuery("from Student")
				.list();
		return studentList;
	}
	
	public  void saveOrUpdate(Student student) {	
		factory.getCurrentSession().saveOrUpdate(student);		
	}
	
	
//	public  void save(Student student) {	
//		factory.getCurrentSession().save(student);			
//	}
//
//	public  void update(Student student) {	
//		factory.getCurrentSession().update(student);		
//	}

	public void deleteStudent(String id){		
		Student student = getStudent(id);		
		factory.getCurrentSession().delete(student);		
	}

	public Student getStudent(String id) {		
        Session session = factory.getCurrentSession();
        int studentId = Integer.parseInt(id);
		Student student = (Student) session.get(Student.class, studentId);		
		return student;
		
	}

}
