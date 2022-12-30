package net.javaguides.springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import net.javaguides.springboot.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {


	
	
}
