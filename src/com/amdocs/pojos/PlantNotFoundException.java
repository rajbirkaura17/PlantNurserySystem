package com.amdocs.pojos;

public class PlantNotFoundException extends RuntimeException {
	private String message;
	public PlantNotFoundException()
	{
	
	}
	public PlantNotFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String toString() {
		return "PlantNotFoundException [message=" + message + "]";
	}
	

}
