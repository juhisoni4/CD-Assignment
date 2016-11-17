package com.hibernate.manyToMany;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg3.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		Student student1 = new Student("Juhi");
		Student student2 = new Student("Nehal");
		Student student3 = new Student("Vishal");
		
		List<Student> studentList = new ArrayList<Student>();
		studentList.add(student1);
		studentList.add(student2);
		studentList.add(student3);
		
		Subject subject1 = new Subject("Maths");
		Subject subject2 = new Subject("Physics");
		Subject subject3 = new Subject("Chemistry");
		Subject subject4 = new Subject("English");
		
		List<Subject> subjectList = new ArrayList<Subject>();
		
		subjectList.add(subject1);
		subjectList.add(subject2);
		subjectList.add(subject3);
		subjectList.add(subject4);
		
		student1.setSubjectList(subjectList);		
		subject1.setStudent(studentList);
		
		session.beginTransaction();
		
		session.save(subject1);
		session.save(subject2);
		session.save(subject3);
		session.save(subject4);
		session.save(student1);		
		session.save(student2);
		session.save(student3);
		//Student student5 = (Student) session.get(Student.class, 1);
		//System.out.println(student5);
		
		Subject subject5 = (Subject) session.get(Subject.class, 1);
	    System.out.println(subject5);
		
		session.getTransaction().commit();
		
		session.close();	

	}

}
