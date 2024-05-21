package com.employeemanagement.exceptionhandle;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandle
{
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	 public ResponseEntity<ExceptionMessage> handleEmployeeNotFoundException(EmployeeNotFoundException exception, WebRequest request)
	{
		ExceptionMessage message = new ExceptionMessage(new Date(),exception.getMessage(),request.getDescription(false));
	
		return new ResponseEntity<ExceptionMessage>(message,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(EmployeeDeletionException.class)
	 public ResponseEntity<ExceptionMessage> handleEmployeeDeletionException(EmployeeDeletionException exception, WebRequest request)
	{
		ExceptionMessage message = new ExceptionMessage(new Date(),exception.getMessage(),request.getDescription(false));
		return new ResponseEntity<ExceptionMessage>(message,HttpStatus.NO_CONTENT);
	}

}
