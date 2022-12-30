package net.javaguides.springboot.service;

import java.util.List;

import net.javaguides.springboot.model.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	List<Employee> getEmployees();
	Employee getEmployeeId(long id);
	Employee updateEmployee(Employee em , long id);
	void deleteEmployee(long id);
}


