package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete {

	@Test
	public void delete() {
		
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RestAssured.basePath="/delete/230231";
		Response response=
		
		given()
		
		.when()
			.delete()
			
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.log().all()
			.extract().response();
		
			String jsontostring=response.asString();
			Assert.assertEquals(jsontostring.contains("successfully! deleted Records"),true);
			
				
	}
}
