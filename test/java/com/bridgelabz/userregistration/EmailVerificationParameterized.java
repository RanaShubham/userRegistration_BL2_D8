package com.bridgelabz.userregistration;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;


@RunWith(Parameterized.class)
public class EmailVerificationParameterized 
{
	private String emailToTest;
	private boolean expectedResult;
	
	//Constructor
	public EmailVerificationParameterized(String emailToTest, boolean result) 
	{
		this.emailToTest = emailToTest;
		this.expectedResult = result;
	}
	
	@Parameterized.Parameters
	public static Collection TestEmails()
	{
		return Arrays.asList(new Object[][]	{	
												{"abc",false},
												{"abc@.com.my",false},
												{"abc123@gmail.a",false},
												{"abc123@.com",false},
												{"abc123@.com.com",false},
												{".abc@abc.com",false},
												{"abc()*@gmail.com", false},
												{"abc@%*.com", false},
												{"abc..2002@gmail.com", false},
												{"abc.@gmail.com", false},
												{"abc@abc@gmail.com", false},
												{"abc@gmail.com.1a", false},
												{"abc@gmail.com.aa.au", false},
												{"abc@yahoo.com", true},
												{"abc-100@yahoo.com", true},
												{"abc.100@yahoo.com", true},
												{"abc111@abc.com", true},
												{"abc-100@abc.net", true},
												{"abc.100@abc.com.au", true},
												{"abc@1.com", true},	
												{"abc@gmail.com.com", true},
												{"abc+100@gmail.com", true},
											});
		
	}
	
	@Test
	public void givenEmailSampleCollection_ShouldReturnTrueWhenCorrectOtherwiseFalse ()
	{
		UserRegistration register = new UserRegistration();
		boolean result  = register.matchEmail(this.emailToTest);
		Assert.assertEquals(this.expectedResult, result);
	}
	
}
	
