package com.hibernate.practice.oneToOne.unidirection;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg1.xml").buildSessionFactory();

		Session session = factory.openSession();

		Address address1 = new Address("Naranpura", "Ahmedabad");
		Student student1 = new Student("Juhi", address1);

		Address address2 = new Address("Maninagar", "Ahmedabad");
		Student student2 = new Student("Charmy1", address2);

		session.beginTransaction();
		session.save(student1);
		session.save(student2);
		
		
//		Student student = (Student) session.get(Student.class, 1);
//		session.lock(student, LockMode.UPGRADE);
//		 
//		session.createQuery("from Student student" +
//		" where student.id = ?")
//		.setParameter(0, student.getId() )
//		.uniqueResult();
	
	
		
		Student tempStudent = (Student)session.get(Student.class, 1);
		
		System.out.println(tempStudent);
		
		session.getTransaction().commit();
		session.close();
	}

}
