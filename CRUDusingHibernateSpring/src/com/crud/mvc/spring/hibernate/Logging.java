package com.crud.mvc.spring.hibernate;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Logging {

	 @Pointcut("execution(com.crud.mvc.spring.hibernate.StudentDao.*.*(..))")
	 private void selectAll(){}
	 
	 @Before("selectAll()")
	 public void authentication(){
		 String sql = "select form Student where userName=? and password=?";
	 }
}
