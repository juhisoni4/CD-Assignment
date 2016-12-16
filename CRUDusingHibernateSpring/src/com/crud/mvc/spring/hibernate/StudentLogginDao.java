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
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class StudentLogginDao {

	@Autowired
	public SessionFactory factory;
	
	public List<StudentLoggin> listStudentLoggin() {
		List<StudentLoggin> studentList = new ArrayList<>();
		studentList = factory.getCurrentSession().createQuery("from StudentLoggin")
				.list();
		return studentList;
	}
	
	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public  void saveOrUpdate(StudentLoggin studentLoggin) {	
		factory.getCurrentSession().saveOrUpdate(studentLoggin);		
	}
	
	
//	public  void save(Student student) {	
//		factory.getCurrentSession().save(student);			
//	}
//
//	public  void update(Student student) {	
//		factory.getCurrentSession().update(student);		
//	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void deleteStudent(String id){		
		StudentLoggin studentLoggin = getStudentLoggin(id);		
		factory.getCurrentSession().delete(studentLoggin);		
	}

	public StudentLoggin getStudentLoggin(String id) {		
        Session session = factory.getCurrentSession();
        int studentId = Integer.parseInt(id);
		StudentLoggin studentLoggin = (StudentLoggin) session.get(Student.class, studentId);		
		return studentLoggin;
		
	}
}
