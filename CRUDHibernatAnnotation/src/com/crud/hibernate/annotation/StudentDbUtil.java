package com.crud.hibernate.annotation;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class StudentDbUtil {

	// create a session factory
	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

	// create session
	static Session session = null;

	public static List<Student> listStudent() {

		session = factory.getCurrentSession();

		// start the transaction
		session.beginTransaction();

		// query student
		List<Student> theStudents = session.createQuery("from Student").list();

		// commit the transaction
		session.getTransaction().commit();

		return theStudents;
	}

	public static void addOrUpdateStudent(Student student1) {

		try {
			// create a session
			session = factory.getCurrentSession();
			System.out.println("getSession");

			// start the transaction
			session.getTransaction().begin();;
			System.out.println("begin Transaction");

			// save the student
			session.saveOrUpdate(student1);
			System.out.println("update the student");
			
			session.getTransaction().commit();
			System.out.println("commit the transaction");

		} catch (Exception e) {
			System.out.println("In catch block");
			e.printStackTrace();
		} 
	}

	public static Student getStudent(String theId) {

		// get student id from the controller
		int id = Integer.parseInt(theId);
		System.out.println(id);

		// create a session
		session = factory.getCurrentSession();

		// start the transaction
		session.beginTransaction();

		// load the student
		Student myStudent = (Student) session.get(Student.class, id);

		session.getTransaction().commit();
		
		return myStudent;
	}

	public static void deleteStudent(String theId) {

		// get student id from the controller
		int id = Integer.parseInt(theId);

		// get current session
		session = factory.getCurrentSession();

		// start the transaction
		session.beginTransaction();

		// create a session
		Student student = (Student) session.get(Student.class, id);

		session.delete(student);

		// commit the transaction
		session.getTransaction().commit();

	}

}
