package com.crud.mvc.spring.hibernate;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.SUPPORTS, readOnly=true)
public class StudentService implements StudentRepository {

	@Autowired
	StudentDaoRepository studentDaoRepository;

	public List<Student> listStudent() {
		List<Student> studentList = new ArrayList<Student>();
		studentList = studentDaoRepository.listStudent();
		return studentList;
	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void saveOrUpdate(Student student) {
		 studentDaoRepository.saveOrUpdate(student);

	}
	
//	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
//	public void save(Student student) {
//		 studentDaoRepository.save(student);
//
//	}
//	
//	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
//	public void update(Student student) {
//		 studentDaoRepository.update(student);
//
//	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public void deleteStudent(String id) {
		studentDaoRepository.deleteStudent(id);
	}

	public Student getStudent(String id) {		
		Student student = studentDaoRepository.getStudent(id);
		return student;
	}

	@Override
	public Student getStudentByUserName(String userName) {
		Student student = studentDaoRepository.getStudentByUserName(userName);
		return student;
	}

}
