package com.employeemanagement.service;

import java.util.List;

import com.employeemanagement.model.Employee;

public interface EmployeeService
{

	public String createEmployee(Employee employee);
	
	public Employee getEmployeeById(Integer id) throws Exception;
	public List<Employee> getAllEmployees();
	public Employee updateEmployeeById(Employee employee , Integer id);
	
	public String deleteEmployeeById(Integer id);
}
