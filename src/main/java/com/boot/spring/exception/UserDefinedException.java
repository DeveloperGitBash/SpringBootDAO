package com.boot.spring.exception;

public class UserDefinedException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserDefinedException(String msg) {
		super(msg);
	}

}
