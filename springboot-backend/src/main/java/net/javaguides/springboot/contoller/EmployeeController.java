package net.javaguides.springboot.contoller;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.RequestBody;

import net.javaguides.springboot.model.Employee;
import net.javaguides.springboot.service.EmployeeService;
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping()
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee)
	{
		 Employee x = employeeService.saveEmployee(employee);
		 System.out.println(x.getEmail());
		 System.out.println(x.getFirstname());
		 System.out.println(x.getLastname());
		 return new ResponseEntity<Employee>(x, HttpStatus.CREATED);	
	}
	
	@GetMapping()
	public List<Employee> getEmployee()
	{
		return employeeService.getEmployees();
	}
	
	@GetMapping("{employeeId}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable("employeeId")  long id )
	{
		
		Employee x  = employeeService.getEmployeeId(id);
		return new ResponseEntity<Employee>(x, HttpStatus.OK);
	}
	
	//update employee rest API	
	@PatchMapping("{employeeId}")
	public ResponseEntity<Employee> udpateEmployee(@RequestBody Employee em , @PathVariable("employeeId") long id)
	{
		Employee em1 = employeeService.updateEmployee(em, id);
		return new ResponseEntity<Employee>(em1, HttpStatus.OK);
	}
	@DeleteMapping("{employeeId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("employeeId") long id){
		
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deleted succesffuly",HttpStatus.OK);		
		
	}

}
