package com.restasssured.RestAssured;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.hamcrest.xml.HasXPath;
import org.testng.annotations.Test;

public class XmlValidation {

	@Test
	public void testsingleresponseinxml() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			
		.then()
			.statusCode(200)
			.body("CUSTOMER.ID",equalTo("15"))
			.log().all();
	}
	
	@Test(priority = 1)
	public void testmultiplecontentinxml() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
		
		.then()
			.body("CUSTOMER.ID",equalTo("15"))
			.body("CUSTOMER.FIRSTNAME",equalTo("Bill"));
	}	
	
	@Test(priority = 2)
	public void testallcontentinxml() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			
		.then()
			.body("CUSTOMER.text()",equalTo("15BillClancy319 Upland Pl.Seattle"))
			.log().all();
			
	}
	
	@Test(priority = 3)
	public void findvaluesusingxmalpathinxmlresposne() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			
		.then()
			.body(hasXPath("/CUSTOMER/FIRSTNAME",containsString("Bill")));
	}
	
	@Test(priority = 3)
	public void findvaluesusingxmale() {
		
		given()
		
		.when()
			.get("http://thomas-bayer.com/sqlrest/CUSTOMER/15")
			
		.then()
			.body(hasXPath("/INVOICELIST/INVOICE[text()='12']"))
			.logs().all();
		
	}
			


	
	
