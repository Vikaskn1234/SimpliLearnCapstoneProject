package in.amazon.ApiTestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class GETDemoBearerToken {
	
	@Test
	public void verifyResource()
	{
		RestAssured
		    .given()
		        .contentType("application/json")
		        .header("Authorization","Bearer 105065427fd0ddbfd8e698cc7d14e5171a78342e5d21aa420021be5e9053f627")
		    .when()
		         .get("https://gorest.co.in/public/v2/users/ 4608986")
		    .then()
		        .statusCode(200)
		        .log().all();
		        
	}
	

}
