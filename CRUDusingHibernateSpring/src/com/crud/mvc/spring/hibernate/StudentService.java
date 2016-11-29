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
	public Student saveOrUpdate(Student student) {
		return studentDaoRepository.saveOrUpdate(student);

	}

	@Transactional(propagation=Propagation.REQUIRED, readOnly=false)
	public Student deleteStudent(String id) {
		return studentDaoRepository.deleteStudent(id);
	}

	public Student getStudent(String id) {		
		Student student = studentDaoRepository.getStudent(id);
		return student;
	}

}
