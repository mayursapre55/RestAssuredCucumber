package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC02_PostRequest {
	
	public static HashMap map=new HashMap();

	@BeforeClass
	public void postdata() {
		map.put("Firstname",RestUtils.getFirstName());
		map.put("Lastname",RestUtils.getLastname());
		map.put("Username",RestUtils.getUsername());
		map.put("Password",RestUtils.getPassword());
		map.put("Email",RestUtils.getEmail());
		
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
	}
	
	@Test
	public void testpost() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.post()
		.then()
			.statusCode(201)
			.and()
			.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
			.and()
			.body("Message", equalTo("Operation Completed Successfully"));
	}
}