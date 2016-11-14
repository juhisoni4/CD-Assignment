package com.crud.with.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

//@WebServlet("")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name = "jdbc/student-tracker")
	public DataSource dataSource;
	public StudentDbUtil studentDbUtil;

	public void init() {
		studentDbUtil = new StudentDbUtil(dataSource);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("userName");
		String password = request.getParameter("password");

		Student student = new Student(firstName, lastName, email, username, password);

		if (student.isValidEmail(email) && student.isValidateUserName(username)) {

			Student student1 = studentDbUtil.findStudent(username, password);

			if (student1 == null) {
				studentDbUtil.addStudent(student);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
				dispatcher.forward(request, response);
			} else {
				PrintWriter out = response.getWriter();
				out.println("<h3>Login is already taken</h3>");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/sign-up.jsp");
				dispatcher.include(request, response);
			}
		} else {
			if (student.isValidEmail(email) == false && student.isValidateUserName(username) == false) {
				Map<String, String> errors = new HashMap<String, String>();
				errors.put("email", "Please Enter Valid E-mail id");
				errors.put("userName", "Please Enter Valid User Name");
				request.setAttribute("errors", errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("sign-up.jsp");
				dispatcher.forward(request, response);
			}

			else if (student.isValidateUserName(username) == false) {
				Map<String, String> errors = new HashMap<String, String>();
				errors.put("userName", "Please Enter Valid User Name");
				request.setAttribute("errors", errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("sign-up.jsp");
				dispatcher.forward(request, response);

			}

			else if (student.isValidEmail(email) == false) {
				Map<String, String> errors = new HashMap<String, String>();
				errors.put("email", "Please Enter Valid E-mail id");
				request.setAttribute("errors", errors);
				RequestDispatcher dispatcher = request.getRequestDispatcher("sign-up.jsp");
				dispatcher.forward(request, response);

			}

			/*
			 * if (student1 == null) { studentDbUtil.addStudent(student);
			 * RequestDispatcher dispatcher =
			 * request.getRequestDispatcher("/login.jsp");
			 * dispatcher.forward(request, response); } else { PrintWriter out =
			 * response.getWriter(); out.println(
			 * "<h3>Login is already taken</h3>"); RequestDispatcher dispatcher
			 * = request.getRequestDispatcher("/sign-up.jsp");
			 * dispatcher.include(request, response); }
			 */

		}

	}
}