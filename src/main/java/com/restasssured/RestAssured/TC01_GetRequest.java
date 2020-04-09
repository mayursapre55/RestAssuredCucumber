package com.restasssured.RestAssured;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class TC01_GetRequest {
	
	@Test
	public void getWeatherdetails() {
		given()
			.when()
				.get("http://restapi.demoqa.com/utilities/weather/city/Hyderabad")
				.then()
				.statusCode(200)
				.statusLine("HTTP/1.1 200 OK")
				.assertThat().body("City", equalTo("Hyderabad"))
				.header("Content-Type","application/json");
			
	}
}

