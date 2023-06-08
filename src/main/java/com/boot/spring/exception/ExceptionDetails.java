package com.boot.spring.exception;

import org.springframework.http.HttpStatus;

public class ExceptionDetails {

	String exceptionMessage;
	HttpStatus statusCode;
	
	public ExceptionDetails() {
		// TODO Auto-generated constructor stub
	}
	

	public ExceptionDetails(String exceptionMessage, HttpStatus statusCode) {
		super();
		this.exceptionMessage = exceptionMessage;
		this.statusCode = statusCode;
	}


	public String getExceptionMessage() {
		return exceptionMessage;
	}

	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

}
