package com.frt.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.frt.model.Employee;
import com.frt.repository.EmployeeRepository;
import com.frt.service.EmployeeService;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public void saveEmployee(Employee employee) {
		
		employeeRepository.saveEmployee(employee);
	}

	@Override
	public Employee getEmployeetById(Long id) {
		
		Employee employee = employeeRepository.getEmployeetById(id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		List<Employee> employeeList = new ArrayList<>();
		employeeList = employeeRepository.getAllEmployee();
		return employeeList;
		
	}	

}
