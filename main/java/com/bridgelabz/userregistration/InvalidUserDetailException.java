package com.bridgelabz.userregistration;

public class InvalidUserDetailException extends RuntimeException {

	//My enum
	enum ExceptionType
	{
		ENTERED_NULL,
		ENTERED_EMPTY
	}
	
	//Variable to hold enum obj
	ExceptionType type;
	
	public InvalidUserDetailException(ExceptionType type, String message)
	{
		super(type+": "+message);
		this.type = type;
	}
}
