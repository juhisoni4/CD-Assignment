package com.hibernate.concurrency.pessimistic;

import org.hibernate.LockMode;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App {

	static SessionFactory factory = new Configuration().configure("hibernate.cfg5.xml").addAnnotatedClass(Student.class).buildSessionFactory();



	public static void main(String[] args) {

		Session session = factory.openSession();

		session.beginTransaction();

		Student student = new Student("Juhi");

		session.save(student);

		session.getTransaction().commit();

		session.close();

		Thread thread1 = new Thread(new Runnable() {

			public void run() {
							
				try {
					
					Session session1 = factory.openSession();
					
					session1.beginTransaction();
					
					Student student1 = (Student) session1.get(Student.class, 1);
					
					session1.lock(student1, LockMode.UPGRADE);
					
					student1.setName("Charmy");
					
					Thread.sleep(100);
					
					session1.flush();
					
					session1.getTransaction().commit();
					
					session1.close();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		Thread thread2 = new Thread(new Runnable() {

			public void run() {
							
				try {
					
					Thread.sleep(100);
					
				    Session session2 = factory.openSession();
					
					session2.beginTransaction();
					
					Student student1 = (Student) session2.get(Student.class, 1);
					
					session2.lock(student1, LockMode.UPGRADE);					
							
					student1.setName("Nehal");	
					
					Thread.sleep(100);
					
					session2.flush();
					
					session2.getTransaction().commit();
					
					session2.close();
					
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				}
			}
		});
		
		thread1.start();
		thread2.start();
	}

}
