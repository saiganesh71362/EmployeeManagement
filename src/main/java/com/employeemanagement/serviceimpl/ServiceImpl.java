package com.employeemanagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.appconstants.AppConstants;
import com.employeemanagement.exceptionhandle.EmployeeDeletionException;
import com.employeemanagement.exceptionhandle.EmployeeNotFoundException;
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
		 employeeRepo.save(employee);
		return AppConstants.RECORD_CREATD;
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
			throw new EmployeeNotFoundException(AppConstants.NO_RECORD+id);  // Handle Custom Exception
		}
	}

	@Override
	public List<Employee> getAllEmployees() 
	{
		List<Employee> findAll = employeeRepo.findAll();
		return findAll;
	}

	@Override
	public Employee updateEmployeeById(Employee employee, Integer id)
	{
		Employee findById = employeeRepo.findById(id).orElse(null);
		if(findById != null)
		{
			findById.setName(employee.getName());
			findById.setSalary(employee.getSalary());
			findById.setContact(employee.getContact());
			findById.setExperience(employee.getExperience());
			findById.setDepartment(employee.getDepartment());
			findById.setUpdatedBy(employee.getUpdatedBy());
			findById.setUpdatedData(employee.getUpdatedData());
			
		     employeeRepo.save(findById);
			
		}
		return null;
	}

	@Override
	public String deleteEmployeeById(Integer id) {
	    Optional<Employee> findById = employeeRepo.findById(id);
	    if (findById.isPresent()) {
	        try {
	            employeeRepo.deleteById(id);
	            return AppConstants.DELETED_RECORD;
	        } catch (EmployeeDeletionException e) {
	            // Handle or log the exception appropriately
	            return AppConstants.DELETE_ERROR;
	        }
	    } else {
	        return AppConstants.NO_RECORD + id;
	    }
	}

}
