package com.frt.repository.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.frt.model.Employee;
import com.frt.model.Employee;
import com.frt.repository.EmployeeRepository;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	SessionFactory factory;

	@Override
	public void saveEmployee(Employee employee) {

		factory.getCurrentSession().saveOrUpdate(employee);

	}

	@Override
	public Employee getEmployeetById(Long id) {

		Employee employee = (Employee) factory.getCurrentSession().get(
				Employee.class, id);
		return employee;

	}

	@Override
	public List<Employee> getAllEmployee() {

		List<Employee> employeeList = new ArrayList<>();
		employeeList = factory.getCurrentSession().createQuery("from Employee")
				.list();
		return employeeList;
	}

	public List<Employee> search(Employee Employee) {

		Example EmployeeExample = Example.create(Employee);
		List<Employee> EmployeeList = factory.getCurrentSession()
				.createCriteria(Employee.class).add(EmployeeExample).list();

		return EmployeeList;

	}

/*	public List<Employee> searchWithoutResourceCode(Employee employee) {

		Example EmployeeExample = Example.create(employee).excludeProperty("resourceCode");
		List<Employee> EmployeeList = factory.getCurrentSession()
				.createCriteria(Employee.class).add(EmployeeExample).list();

		return EmployeeList;

	}*/

}
