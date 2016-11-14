package com.crud.with.database;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MyListener implements HttpSessionListener,ServletRequestListener {


	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		ServletRequest servletRequest = servletRequestEvent.getServletRequest();
		System.out.println("Request Destroyed");		
	}

	
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {
		ServletRequest servletRequest = servletRequestEvent.getServletRequest();
		System.out.println("Got a request from the user");			
	}

	@Override
	public void sessionCreated(HttpSessionEvent sessionEvent) {
			System.out.println("Session created "+sessionEvent.getSession().getId());		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent sessionEvent) {
		System.out.println("Session destroyed "+sessionEvent.getSession().getId());		
	}

    
}
