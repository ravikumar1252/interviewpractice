package com.person.job;

public class PersonDetailsNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String message;
	
	
	
	PersonDetailsNotFound(String message){
		
		super(message);
	}

}
