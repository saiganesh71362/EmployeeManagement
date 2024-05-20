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
			
			Employee save = employeeRepo.save(findById);
			
		}
		return null;
	}

	@Override
	public String deleteEmployeeById(Integer id) {
	    Optional<Employee> findById = employeeRepo.findById(id);
	    if (findById.isPresent()) {
	        try {
	            employeeRepo.deleteById(id);
	            return "Record deleted successfully.";
	        } catch (Exception e) {
	            // Handle or log the exception appropriately
	            return "An error occurred while deleting the record.";
	        }
	    } else {
	        return "There is no record with ID: " + id;
	    }
	}

}
