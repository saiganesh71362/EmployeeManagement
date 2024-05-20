package com.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.model.Employee;
import com.employeemanagement.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController
{

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@PostMapping("/newEmployee")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee)
    {
		String createEmployee = employeeService.createEmployee(employee);
    	
    	return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);
	}
    
	@GetMapping("/{id}")
	 public ResponseEntity<Employee> getEmployeeById(@PathVariable Integer id) throws Exception
	{
		Employee employeeById = employeeService.getEmployeeById(id);
		
		return new ResponseEntity<>(employeeById,HttpStatus.OK);
	}
	
	 @GetMapping("/allEmployees")
	 public ResponseEntity<List<Employee>> getAllEmployees(){
		 
		 List<Employee> allEmployees = employeeService.getAllEmployees();
		 return new ResponseEntity<List<Employee>>(allEmployees,HttpStatus.OK);
		
	}
}
