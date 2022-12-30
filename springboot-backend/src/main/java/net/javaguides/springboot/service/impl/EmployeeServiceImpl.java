package net.javaguides.springboot.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.repo.EmployeeRepo;
import net.javaguides.springboot.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	
	private EmployeeRepo employeeRepo;
	
	public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
		super();
		this.employeeRepo = employeeRepo;
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
	 return employeeRepo.save(employee);	
		
	}

	@Override
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeId(long id) {
		// TODO Auto-generated method stub
		Optional<Employee> employee = employeeRepo.findById(id);
		if(employee.isPresent())
			return employee.get();
		else {
			throw new ResourceNotFoundException("Emploee", "id", id);
		}
	}

	@Override
	public Employee updateEmployee(Employee em , long id) {
		// TODO Auto-generated method stub
		Employee existingEmoloyee;
		Optional<Employee> em1 = employeeRepo.findById(id);
		if(em1.isPresent())
		{
		      existingEmoloyee =  em1.get();
		}
		else {
			throw new ResourceNotFoundException("employee", "id", id);
		}
		existingEmoloyee.setEmail(em.getEmail());
		existingEmoloyee.setFirstname(em.getFirstname());
		existingEmoloyee.setLastname(em.getLastname());
		//existingEmoloyee.setId(em.getId());
		return employeeRepo.save(existingEmoloyee);
	}

	@Override
	public void deleteEmployee(long id) {
		// TODO Auto-generated method stub
		employeeRepo.findById(id).orElseThrow(() -> 
		
				new ResourceNotFoundException("employee", "id", id));
		employeeRepo.deleteById(id);
	}
		
}
