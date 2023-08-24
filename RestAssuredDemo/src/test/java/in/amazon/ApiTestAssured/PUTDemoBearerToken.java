package in.amazon.ApiTestAssured;

import java.util.HashMap;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PUTDemoBearerToken {
	
	HashMap<String, String> map=new HashMap<String, String>();
	
	@BeforeMethod
	public void createPayload()
	{
		map.put("name", "Batmannnn2");
		map.put("email", "batman554466786@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI="https://gorest.co.in/";
		RestAssured.basePath="public/v2/users/ 4495285";
				
	}
	@Test
	public void updateResource()
	{
		Response response= RestAssured
		    .given()
		        .header("Authorization","Bearer 105065427fd0ddbfd8e698cc7d14e5171a78342e5d21aa420021be5e9053f627")
		        .body(map)
		    .when()
		       .put()
		     .then()
		       .extract().response();
		JsonPath jsonPath=response.jsonPath();
		
		
		Assert.assertTrue(jsonPath.get("name").toString().equals("Batmannnn2"));
	}

}
