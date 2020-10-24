package com.bridgelabz.userregistration;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.runners.Parameterized.Parameters;

import com.bridgelabz.userregistration.InvalidUserDetailException.ExceptionType;

public class UserRegistration {
	
	static Scanner input = new Scanner (System.in).useDelimiter("\n");
	
	//Variables
	String firstName;
	String lastName;
	String email;
	String phoneNumber;
	String password;
	
	//Regex patterns
	static String FIRST_NAME = "^[A-Z]{1}[a-z]{2,}$";
	static String LAST_NAME = "^[A-Z]{1}[a-z]{2,}$";
	static String EMAIL = "^[[a-z]]{1,}([._+-][0-9]{1,})*[0-9]{0,}@([0-9]|[[a-z]]){1,}[.][[a-z]]{2,4}([.][[a-z]]{2,4}){0,1}$";
	static String PHONE_NUMBER = "^(91 ){0,1}[7-9][0-9]{9}$";
	static String PASSWORD = "^.{8}$";
	static String PASSWORD_2 = "[A-Z]{1,}";
	static String PASSWORD_3 = "[0-9]{1,}";
	static String PASSWORD_4 = "[^A-Za-z0-9]{1}";
	static String PASSWORD_5 = "[^A-Za-z0-9]{2,}";
	
	public static void main(String[] args) 
	{
		System.out.println("Welcome to user registration program");
		
		UserRegistration register = new UserRegistration();

		System.out.println("Enter first name");
		register.firstName = input.next();
		System.out.println("Enter last name");
		register.lastName = input.next();
		System.out.println("Enter email");
		register.email = input.next();
		System.out.println("Enter mobile number");
		register.phoneNumber = input.next();
		System.out.println("Enter password");
		register.password = input.next();
				
		register.matchFirstName(register.firstName);
		register.matchLastName(register.lastName);
		register.matchEmail(register.email);
		register.matchPhoneNumber(register.phoneNumber);
		register.matchPassword(register.password);

	}

	//To verify password
	boolean matchPassword(String password) 
	{
		try {


			Pattern p = Pattern.compile(PASSWORD);
			Pattern p2 = Pattern.compile(PASSWORD_2);
			Pattern p3 = Pattern.compile(PASSWORD_3);
			Pattern p4 = Pattern.compile(PASSWORD_4);
			Pattern p5 = Pattern.compile(PASSWORD_5);
			
			Matcher m = p.matcher(password);
			Matcher m2 = p2.matcher(password);
			Matcher m3 = p3.matcher(password);
			Matcher m4 = p4.matcher(password);
			Matcher m5 = p5.matcher(password);

			if (password.isBlank())
				throw new InvalidUserDetailException(ExceptionType.ENTERED_EMPTY,"Password cannot be empty");
			
			if (m.find() && m2.find() && m3.find() && m4.find() && !m5.find())
				return true;
			else
				return false;
			
		} catch (NullPointerException e) {
			throw new InvalidUserDetailException(ExceptionType.ENTERED_NULL, "Password cannot be null");
		}
	}

	//To verify phone number
	boolean matchPhoneNumber(String phoneNumber) 
	{
		try {
			Pattern p = Pattern.compile(PHONE_NUMBER);
			Matcher m = p.matcher(phoneNumber);
			if (phoneNumber.isBlank()) {
				throw new InvalidUserDetailException(ExceptionType.ENTERED_EMPTY, "Phone number cannot be empty");
			}
			return m.find();
		} catch (NullPointerException e) {
			throw new InvalidUserDetailException(ExceptionType.ENTERED_NULL, "Phone number cannot be null");
		}
	}

	//To verify email
	boolean matchEmail(String email) 
	{
		try {

			Pattern p = Pattern.compile(EMAIL);
			Matcher m = p.matcher(email);
			
			if (email.isBlank()) {
				throw new InvalidUserDetailException(ExceptionType.ENTERED_EMPTY, "Email cannot be empty");
			}
			return m.find();
		
		} catch (NullPointerException e) {
			throw new InvalidUserDetailException(ExceptionType.ENTERED_EMPTY, "Email cannot be null");
		}
	}

	//To verify last name
	boolean matchLastName(String lastName) 
	{
		try {

			Pattern p = Pattern.compile(LAST_NAME);
			Matcher m = p.matcher(lastName);
			
			if (lastName.isBlank()) {
				throw new InvalidUserDetailException(ExceptionType.ENTERED_EMPTY,"Last name cannot be empty");
			}
			return m.find();
		
		} catch (NullPointerException e) {
			throw new InvalidUserDetailException(ExceptionType.ENTERED_NULL, "Last name cannot be null");
		}
	}

	//To verify first name
	boolean matchFirstName(String firstName) 
	{
		try {

			Pattern p = Pattern.compile(FIRST_NAME);
			Matcher m = p.matcher(firstName);
			
			if(firstName.isBlank())
			{
				throw new InvalidUserDetailException(ExceptionType.ENTERED_EMPTY, "First name cannot be empty");
			}
			return m.find();
		
		} catch (NullPointerException e) {
			throw new InvalidUserDetailException(ExceptionType.ENTERED_NULL, "First name cannot be null");
		}
	}

}
