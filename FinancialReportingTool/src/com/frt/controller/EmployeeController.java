package com.frt.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frt.model.Employee;
import com.frt.service.EmployeeService;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	
	public void saveEmployee(Employee employee){
		
		employeeService.saveEmployee(employee);
	}
	
	public Employee getEmployeeById(Long id){
		
		Employee employee = employeeService.getEmployeetById(id);
		return employee;
	}
	
	public List<Employee> getAllEmployee(){
		
		List<Employee> employeeList = new ArrayList<>();		
		employeeList = employeeService.getAllEmployee();
		return employeeList;
	}
}
