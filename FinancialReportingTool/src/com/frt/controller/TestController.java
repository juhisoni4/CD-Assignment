package com.frt.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frt.service.ClientService;
import com.frt.service.EmployeeService;
import com.frt.service.FinancialDataService;
import com.frt.service.ProjectService;
import com.frt.service.SubProjectService;

@RestController
@RequestMapping(value="/test")
public class TestController {

	@Autowired
	HttpServletResponse response;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	ClientService clientService;	

	@Autowired
	ProjectService projectService;

	@Autowired
	FinancialDataService financialDataService;

	@Autowired
	SubProjectService subProjectService;
	
	@Autowired
	EmployeeService employeeService;	

	@RequestMapping(value="/list")
	public void test(){
		
	}
}
