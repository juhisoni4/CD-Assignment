package com.frt.repository;

import java.util.List;

import com.frt.model.Employee;

public interface EmployeeRepository {

	public void saveEmployee(Employee employee);

	public Employee getEmployeetById(Long id);

	public List<Employee> getAllEmployee();
	
	public List<Employee> search(Employee employee);
	
	//public List<Employee> searchWithoutResourceCode(Employee employee);

}
