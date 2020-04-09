package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class GET {

	@Test
	public void getRequest() {
		
		given()
			
		.when()
			.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
		.then()
			.statusCode(200)
			.statusLine("HTTP/1.1 200 OK")
			.header("Content-TYpe", "application/json")
			.assertThat().body("City", equalTo("Hyderabad"));
	}
}
