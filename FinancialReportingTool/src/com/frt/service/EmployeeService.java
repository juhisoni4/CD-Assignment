package com.frt.service;

import java.util.List;

import com.frt.model.Employee;

public interface EmployeeService {

	public void saveEmployee(Employee employee);

	public Employee getEmployeetById(Long id);

	public List<Employee> getAllEmployee();
	
	public List<Employee> search(Employee employee);
	
	//public List<Employee> searchWithoutResourceCode(Employee employee);

}
