package com.restasssured.RestAssured;

import org.apache.commons.lang3.RandomStringUtils;

public class RestUtils {

	public static String getFirstName() {
		String generatedstring=RandomStringUtils.randomAlphabetic(1);
		return ("John"+generatedstring);
	}
	
	public static String getLastname() {
		String generatedstring=RandomStringUtils.randomAlphabetic(1);
		return ("Kenedy"+generatedstring);
	}
	
	public static String getUsername() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		return ("John"+generatedstring);
	}
	
	public static String getPassword() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		return ("Kenedy"+generatedstring);
	}
	
	public static String getEmail() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		return (generatedstring+"@gmail.com");
	}
	
	public static String getEmpname() {
		String generatedstring=RandomStringUtils.randomAlphabetic(3);
		return ("John"+generatedstring);
	}
	
	public static String getSal() {
		String generatedstring=RandomStringUtils.randomNumeric(5);
		return generatedstring;
	}
	
	public static String getEmpage() {
		String generatedstring=RandomStringUtils.randomNumeric(2);
		return generatedstring;
	}
	
	
	
	
	
}
