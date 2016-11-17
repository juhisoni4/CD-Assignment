package com.hibernate.oneToMany.unidirection;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg2.xml").buildSessionFactory();
		
		University university1 = new University("MIT", "USA");
		University university2 = new University("Harvard","USA");
	
		Student student1 = new Student("Juhi");		
				
		List<University> universityList = new ArrayList<University>();
		
		universityList.add(university1);
		universityList.add(university2);
		
		student1.setUniversity(universityList);
		
//		Student student2 = new Student("Charmy");
//		Student student3 = new Student("Nehal");
//		Student student4 = new Student("Vishal");
//		
//		student1.setUniversity(university1);
//		student2.setUniversity(university1);
//		student3.setUniversity(university1);
//		student4.setUniversity(university1);
//		
//		List<Student> students = new ArrayList<Student>();
//		students.add(student1);
//		students.add(student2);		
//		students.add(student3);
//		students.add(student4);
//		
//		university1.setStudents(students);
		
		
		Session session = factory.openSession();
		
		session.beginTransaction();
		
		//session.persist(university1);
		
		/*University university = (University) session.get(University.class, 1);
		System.out.println(university);*/
				
		session.save(student1);
		
		Student student = (Student) session.get(Student.class, 1);
		System.out.println(student);
		
		session.getTransaction().commit();
		
		session.close();

	}

}
