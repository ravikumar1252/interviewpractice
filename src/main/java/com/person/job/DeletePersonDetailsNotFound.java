package com.person.job;

public class DeletePersonDetailsNotFound extends Exception {
	
private static final long serialVersionUID = 1L;
	
	private String message;
	
	DeletePersonDetailsNotFound (String message){
		
		super(message);
		
	}

}
