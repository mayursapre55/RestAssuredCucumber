package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class POST {

	public static HashMap maps=new HashMap();
	
	@BeforeClass
	public void postdata() {
		maps.put("Firstname",RestUtils.getFirstName());
		maps.put("Lastname",RestUtils.getLastname());
		maps.put("Username",RestUtils.getUsername());
		maps.put("Password",RestUtils.getPassword());
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		RestAssured.basePath="/register";
	}
	
	@Test
	public void testpost() {
		given()
			.contentType("application/json")
			.body(maps)
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
