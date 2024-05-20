package com.employeemanagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.model.Employee;
import com.employeemanagement.repository.EmployeeRepo;
import com.employeemanagement.service.EmployeeService;

@Service
public class ServiceImpl implements EmployeeService 
{
    
	private EmployeeRepo employeeRepo;
	@Autowired
	public ServiceImpl(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	@Override
	public String createEmployee(Employee employee)
	{
		Employee save = employeeRepo.save(employee);
		return "Recored Created Success Fully";
	}

	@Override
	public Employee getEmployeeById(Integer id) throws Exception
	{
		Optional<Employee> findById = employeeRepo.findById(id);
		if(findById.isPresent())
		{
			return findById.get();
		}
		else {
			throw new Exception("Employee Not Found "+id);  // Handle Custom Exception
		}
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		List<Employee> findAll = employeeRepo.findAll();
		return findAll;
	}

	@Override
	public Employee updateEmployeeById(Employee employee, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
