package com.hibernate.oneToOne.bidirection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Session session = factory.openSession();

		Address address1 = new Address("Naranpura", "Ahmedabad");
		Student student1 = new Student("Juhi");

		Address address2 = new Address("Maninagar", "Ahmedabad");
		Student student2 = new Student("Charmy1");
		
		student1.setAddress(address1);
		student2.setAddress(address2);
		
		address1.setStudent(student1);
		address2.setStudent(student2);

		session.beginTransaction();
		session.save(student1);
		session.save(student2);
				
		Student tempStudent = (Student)session.get(Student.class, 1);
		Address address = (Address) session.get(Address.class, 2);
		
		//student1.setName("Juhi1");
		//session.update(student1);
		
		System.out.println(tempStudent);
		System.out.println(address);
		
//		Student tempStudent1 = (Student)session.get(Student.class, 3);
//		System.out.println(tempStudent1);
		
		session.getTransaction().commit();
		session.close();
	}

}
