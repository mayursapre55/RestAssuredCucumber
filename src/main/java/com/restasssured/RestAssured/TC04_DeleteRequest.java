package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC04_DeleteRequest {
	
	@Test
	public void deleteEmployeeRecord() {
		
		Response response;
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/214126";
		
		given()
			
		.when()
			.delete()
		
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
			String jsonAsString=response.asString();
			Assert.assertEquals(jsonAsString.contains("successfully! deleted Records"),true);
		
			
	}
}
 