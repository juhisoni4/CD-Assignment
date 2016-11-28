package com.crud.mvc.spring.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class StudentService implements StudentRepository {

	@Autowired(required=true)
	StudentDao studentDao;
	
	public List<Student> listStudent() {	
		 
		return studentDao.listStudent();
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveOrUpdate(Student student) {
		
		studentDao.saveOrUpdate(student);

	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void deleteStudent(int id) {
		
		studentDao.getStudent(id);
	}

	public Student getStudent(int id) {
	
		return studentDao.getStudent(id);
	}

}
