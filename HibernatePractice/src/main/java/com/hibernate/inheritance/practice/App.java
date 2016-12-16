package com.hibernate.inheritance.practice;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg4.xml").buildSessionFactory();
		
		Session session = factory.openSession();
		
		Book book1 = new Book("Two States");
		Book book2 = new Book("The Fountain Head");
		Book book3 = new Book("Wise and Otherwise");
		
		Publisher publisher1 = new Publisher("Hyder Ali","ABC123");
		Publisher publisher2 = new Publisher("Bobbs Merrill Company","DEF425");
		Publisher publisher3 = new Publisher("Penguin Books","NMG789");
		
		Author author1 = new Author("Chetan Bhagat");
		Author author2 = new Author("Any Rand");
		Author author3 = new Author("Sutha Murty");
		
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
		
		List<Publisher> publisherList = new ArrayList<Publisher>();
		publisherList.add(publisher1);
		publisherList.add(publisher2);
		publisherList.add(publisher3);
		
		List<Author> authorList = new ArrayList<Author>();
		authorList.add(author1);
		authorList.add(author2);
		authorList.add(author3);
		
		author1.setBook(bookList);
		author1.setPublisher(publisher1);
		publisher1.setAuthor(authorList);
		book1.setAuthor(authorList);
		
		session.beginTransaction();
		
		session.save(author1);
   	    session.save(publisher1);
		session.save(book1);
		 
//    	Book book4 = (Book) session.get(Book.class, 1);
//		System.out.println(book4);
		
		session.getTransaction().commit();
		session.close();

	}

}
