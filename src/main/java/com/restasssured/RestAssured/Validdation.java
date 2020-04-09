package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.collection.HasItemInArray;
import org.testng.annotations.Test;

public class Validdation {

	@Test
	public void teststatuscode() {
		//Test status code adn logs
		
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test(priority = 1)
	public void verifysinglecontent() {
		
		given()
		
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
			
		.then()
			.statusCode(200)
			.body("title", equalTo("nesciunt quas odio"));
		}
	
//	@Test(priority = 2)
//	public void verifyMultipleContent() {
//		
//		given()
//		
//		.when()
//			.get("http://jsonplaceholder.typicode.com/posts")
//			
//		.then()
//			.statusCode(200)
//			.body("title",HasItemInArray("qui est esse","eum et est occaecati"));
//	}
	
	@Test(priority = 2)
	public void testparamandheaders() {
		
		given()
			.param("name","MAyur")
			.header("header","SApre")
		.when()
			.get("http://jsonplaceholder.typicode.com/posts/5")
		.then()
			.statusCode(200)
			.log().all();
	}
}
