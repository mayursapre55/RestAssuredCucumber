package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import org.testng.annotations.Test;

/* Test Status Code
 * Log Response
 * Verifying Single content in response body
 * Verifying multiple content in response body
 * Setting parametes and headers
 */

public class TC05_DEmo_JSONValidation {

	//***********Test Status Code and Log Response************//
	@Test(priority=1)
	public void teststatuscode() {
		
		when()
			.get("http://jsonplaceholder.typicode.com/posts/1")
		.then()
			.statusCode(200);
			//.log().all();
	}
	
	//*********Log*************//
	@Test(priority=2)
	public void testLogging() {
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
		
	}
	
	//********Verify single content in response body*****//
	@Test(priority=3)
	public void testSingleContent() {
		
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		
		.then()
			.statusCode(200)
			.body(".title", equalTo("nesciunt quas odio"));
		
	}
}
