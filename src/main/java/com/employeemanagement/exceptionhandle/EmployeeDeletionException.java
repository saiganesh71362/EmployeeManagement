package com.employeemanagement.exceptionhandle;

public class EmployeeDeletionException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	EmployeeDeletionException(String message)
	{
		super(message);
	}
	
}
