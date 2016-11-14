package com.crud.hibernate.xml;

import java.util.List;


import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jdk.nashorn.internal.ir.RuntimeNode.Request;


public class StudentDbUtil {

	// create a session factory
	static SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class).buildSessionFactory();

	// create session
	static Session session = null;

	public static List<Student> listStudent() {

		session = factory.openSession();

		// start the transection
		session.beginTransaction();

		// query student
		List<Student> theStudents = session.createQuery("from Student").list();

		// commit the transaction
		session.getTransaction().commit();

		return theStudents;
	}

	public static void addOrUpdateStudent(Student student1) {

		// create a session
		session = factory.openSession();

		// start the transaction
		session.beginTransaction();

		// save the student
		session.saveOrUpdate(student1);

		// commit the transaction
		session.getTransaction().commit();
	}

	public static Student getStudent(String theId) {

		// get student id from the controller
		int id = Integer.parseInt(theId);
		System.out.println(id);

		// create a session
		session = factory.openSession();

		// start the transaction
		session.beginTransaction();

		// load the student
		Student myStudent = (Student) session.get(Student.class, id);

		return myStudent;
	}

	public static void deleteStudent(String theId) {

		// get student id from the controller
		int id = Integer.parseInt(theId);

		// get current session
		session = factory.openSession();

		// start the transaction
		session.beginTransaction();

		// create a session
		Student student = (Student) session.get(Student.class, id);

		session.delete(student);

		// commit the transaction
		session.getTransaction().commit();

	}

}
