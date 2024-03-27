package com.hexaware.exception;

@SuppressWarnings("serial")
public class AdminNotFoundException extends Exception{
	public AdminNotFoundException(String message) {
		super(message);
	}
}
