package com.crud.with.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/StudentController")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/student-tracker")
	public DataSource dataSource;
	public StudentDbUtil studentDbUtil;
	static String userName;

	public void init() {
		studentDbUtil = new StudentDbUtil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");
	
		
		if (command == null) {
			command = "LIST";
		}

		try {

			switch (command) {

			case "LIST":
				listStudent(request, response);
				break;

			case "LOAD":
				getStudent(request, response);
				break;

			case "DELETE":
				deleteStudent(request, response);
				break;

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, Exception {

		int id = Integer.parseInt(request.getParameter("StudentId"));

		studentDbUtil.deleteStudent(id);

		listStudent(request, response);

	}

	private void getStudent(HttpServletRequest request, HttpServletResponse response) throws Exception, IOException {

		int id = Integer.parseInt(request.getParameter("StudentId"));
		System.out.println(id);
		Student student = studentDbUtil.getStudent(id);

		request.setAttribute("STUDENT", student);

		RequestDispatcher dispatcher = request.getRequestDispatcher("update-student.jsp");
		dispatcher.forward(request, response);

	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, Exception, IOException {
		
		List<Student> students = studentDbUtil.listStudent();
		request.setAttribute("STUDENT_LIST", students);

		RequestDispatcher dispatcher = request.getRequestDispatcher("list-student.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String command = request.getParameter("command");

		if (command == null) {
			command = "LIST";
		}

		try {

			switch (command) {

			case "LIST":
				listStudent(request, response);
				break;

			case "ADD":
				addStudent(request, response);
				break;

			case "UPDATE":
				updateStudent(request, response);
				break;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, Exception {

		int id = Integer.parseInt(request.getParameter("id"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");

		Student student = new Student(id, firstName, lastName, email);

		studentDbUtil.updateStudent(student);

		listStudent(request, response);

	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, Exception {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		Student student = new Student(firstName, lastName, email, username, password);

		if (student.isValidEmail(email) && student.isValidateUserName(username)) {
			studentDbUtil.addStudent(student);
			listStudent(request, response);
		} else {
			if (student.isValidEmail(email) == false && student.isValidateUserName(username) == false) {
				Map<String, String> errors = new HashMap<String, String>();
				errors.put("email", "Please Enter Valid E-mail id");
				errors.put("userName", "Please Enter Valid User Name");
				request.setAttribute("errors", errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("add-student.jsp");
				dispatcher.forward(request, response);
			}

			else if (student.isValidateUserName(username) == false) {
				Map<String, String> errors = new HashMap<String, String>();
				errors.put("userName", "Please Enter Valid User Name");
				request.setAttribute("errors", errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("add-student.jsp");
				dispatcher.forward(request, response);

			}

			else if (student.isValidEmail(email) == false) {
				Map<String, String> errors = new HashMap<String, String>();
				errors.put("email", "Please Enter Valid E-mail id");
				request.setAttribute("errors", errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("add-student.jsp");
				dispatcher.forward(request, response);

			}
		}

	}
	
	public static String getCookie(HttpServletRequest request, HttpServletResponse response) {
		String userName = null;
		Cookie[] cookie = request.getCookies();
			if (cookie != null) {
			for (Cookie cookies : cookie) {
				if (cookies.getName().equals("user")) {
					userName = cookies.getValue();
				}
			}
		}
		return userName;

	}

}