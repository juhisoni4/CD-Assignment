package com.crud.hibernate.annotation;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the command parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing,then default to listing the student
			if (theCommand == null) {
				theCommand = "LIST";
			}

			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listStudents(request, response);
				break;			

			case "LOAD":
				loadSudents(request, response);
				break;			

			case "DELETE":
				deleteStudent(request, response);
				break;

			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			// read the command parameter
			String theCommand = request.getParameter("command");
			
			// if the command is missing,then default to listing the student
			if (theCommand == null) {
				theCommand = "LIST";
			}

			// route to the appropriate method
			switch (theCommand) {
			case "LIST":
				listStudents(request, response);
				break;			
				
			case "UPDATE":
				addOrUpdateStudent(request, response);
				break;				
			}

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read the student id from the dat
		String theId = request.getParameter("studentId");

		// delete student from database
		StudentDbUtil.deleteStudent(theId);

		// send them back to the list student page
		listStudents(request, response);
	}

	private void addOrUpdateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Student student3 = null;
		
		String id = request.getParameter("studentId");
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");		
		
		if (id == "") {			
			student3 = new Student(firstName, lastName, email);
			StudentDbUtil.addOrUpdateStudent(student3);			
			// send them back to the list student page
			listStudents(request, response);
			
		}else{
			student3 = StudentDbUtil.getStudent(id);
			student3.setFirstName(firstName);
			student3.setLastName(lastName);
			student3.setEmail(email);
			
			// pass updated object to the database
			StudentDbUtil.addOrUpdateStudent(student3);
			
			// send them back to the list student page
			listStudents(request, response);					
		}
	
	}

	private void loadSudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read the student id from the data
		String theId = request.getParameter("studentId");
		

		// get the student from the database
		Student student2 = StudentDbUtil.getStudent(theId);

		// place student in the request attribute
		request.setAttribute("THE_STUDENT", student2);

		// send to jsp page: update-student-form.jsp
		RequestDispatcher dispacher = request.getRequestDispatcher("/update-student.jsp");
		dispacher.forward(request, response);

	}	

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// get the students from the studentDbUtil
		List<Student> students = StudentDbUtil.listStudent();

		// add the students to the request object
		request.setAttribute("STUDENT_LIST", students);

		// send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/student-list.jsp");
		dispatcher.forward(request, response);
	}

}
