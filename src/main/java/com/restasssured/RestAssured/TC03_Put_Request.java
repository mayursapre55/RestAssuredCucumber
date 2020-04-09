package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class TC03_Put_Request {
	
	public static HashMap map=new HashMap();
	
	String empname=RestUtils.getEmpname();
	String empSalary=RestUtils.getSal();
	String empAge=RestUtils.getEmpage();
	
	int emp_id=11324;
	
	@BeforeClass
	public void putData() {
		map.put("name",empname);
		map.put("salary", empSalary);
		map.put("age", empAge);
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/update/"+emp_id;
	}
	
	@Test
	public void testPUT() {
		given()
			.contentType("application/json")
			.body(map)
		.when()
			.put()
		.then()
			.statusCode(200)
			.log().all();
	}

}
