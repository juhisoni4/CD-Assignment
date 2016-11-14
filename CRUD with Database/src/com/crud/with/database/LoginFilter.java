package com.crud.with.database;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

//@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

	@Resource(name = "jdbc/student-tracker")
	public DataSource dataSource;
	public StudentDbUtil studentDbUtil;

	public LoginFilter() {
		// TODO Auto-generated constructor stub

	}

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession(false);

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		Cookie cookie = new Cookie("user", username);
		cookie.setMaxAge(60 * 60 * 24);
		response.addCookie(cookie);

		if (username != null && password != null) {
			Student student = studentDbUtil.findStudent(username, password);
			if (student != null) {
				session.setAttribute("user", student);
			}
		}

		boolean loggedIn = (session != null) && (session.getAttribute("user") != null);

		if (loggedIn) {				
			chain.doFilter(request, response);
		} else {		 
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
			dispatcher.forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		studentDbUtil = new StudentDbUtil(dataSource);
	}

}
