package com.boot.spring.exception;

import javax.xml.ws.soap.Addressing;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DepartmentExceptionHandler {
	
	@ExceptionHandler(value= {UserDefinedException.class})
	public ResponseEntity<Object> hendlDepartmentException(UserDefinedException userDefinedException)
	{
		ExceptionDetails expDetails = new ExceptionDetails(userDefinedException.getMessage(),HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<>(expDetails,HttpStatus.NOT_FOUND);
	}
}
