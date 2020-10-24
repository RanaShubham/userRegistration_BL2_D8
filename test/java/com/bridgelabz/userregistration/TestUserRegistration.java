package com.bridgelabz.userregistration;

import org.junit.Assert;
import org.junit.Test;

public class TestUserRegistration {
	
	static UserRegistration registartion  = new UserRegistration();
	
	//FirstName test cases_______________________________________________________________________
	@Test
	public void givenFirstName_WhenProper_ShouldReturnTrue() 
	{
		boolean result = registartion.matchFirstName("Shubham");
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenFirstName_WhenImproper_ShouldReturnFalse()
	{
		boolean result = registartion.matchFirstName("shubham");
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenFirstName_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		registartion.matchFirstName("");
	}

	
	//LastName test cases_______________________________________________________________________
	@Test
	public void givenLastName_WhenProper_ShouldReturnTrue()
	{
		boolean result = registartion.matchLastName("Rana");
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenLastName_WhenImporper_ShouldReturnFalse()
	{
		boolean result = registartion.matchLastName("rana");
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenLastName_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		registartion.matchLastName("");
	}
	
	
	//Password test cases_______________________________________________________________________
	@Test
	public void givenPassword_WhenProper_ShouldReturnTrue()
	{
		boolean result = registartion.matchPassword("Abcd123$");
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenPassword_WhenNoCapitalChar_ShouldReturnFalse()
	{
		boolean result = registartion.matchPassword("abcd123$");
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenNoSpecialChar_ShouldReturnFalse()
	{
		boolean result = registartion.matchPassword("Abcd1234");
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenNoNumberinPassword_ShouldReturnFalse()
	{
		boolean result = registartion.matchPassword("Abcdefgh");
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenMoreThanOneScpecialChar_ShouldReturnFalse()
	{
		boolean result = registartion.matchPassword("Abcd12#$");
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPassword_WhenPasswordLengthShortThan8_ShouldReturnFalse()
	{
		boolean result = registartion.matchPassword("Abd12#$");
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenPassword_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		registartion.matchPassword("");
	}
	
	//PhoneNumber test cases_______________________________________________________________________
	@Test
	public void givenPhoneNumber_WhenProper_ShouldReturnTrue()
	{
		boolean result = registartion.matchPhoneNumber("91 8249167495");
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenPhoneNumber_WhenWithoutCountryCode_ShouldReturnTrue()
	{
		boolean result = registartion.matchPhoneNumber("8249167495");
		Assert.assertEquals(true, result);
	}
	
	@Test
	public void givenPhoneNumber_WhenNoSpaceAfterCountryCode_ShouldReturnFalse()
	{
		boolean result = registartion.matchPhoneNumber("918249167495");
		Assert.assertEquals(false, result);
	}
	
	@Test
	public void givenPhoneNumber_WhenImproper_ShouldReturnFalse()
	{
		boolean result = registartion.matchPhoneNumber("495");
		Assert.assertEquals(false, result);
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenPhoneNumber_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		registartion.matchPhoneNumber("");
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenPhoneNumber_WhenNull_ShouldThrowInvalidUserDetailException()
	{
		registartion.matchPhoneNumber(null);
	}
	
	//Email exception test cases_____________________________________________________________
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenEmail_WhenEmpty_ShouldThrowInvalidUserDetailException()
	{
		registartion.matchEmail("");
	}
	
	@Test(expected = InvalidUserDetailException.class)
	public void givenEmail_WhenNull_ShouldThrowInvalidUserDetailException()
	{
		registartion.matchEmail(null);
	}
}

