package com.person.job;

public class ErrorResponse {
	
	private int statusode;
	private String message;
	
	public ErrorResponse(int statusode ,String message) {
		
		super();
		this.statusode=statusode;
		this.message=message;
		
	}

	public int getStatusode() {
		return statusode;
	}

	public void setStatusode(int statusode) {
		this.statusode = statusode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
