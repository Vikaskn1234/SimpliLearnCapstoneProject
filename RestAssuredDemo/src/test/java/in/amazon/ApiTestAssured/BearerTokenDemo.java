package in.amazon.ApiTestAssured;

import java.util.HashMap;
import java.util.UUID;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BearerTokenDemo {
	
	HashMap<String, String> map=new HashMap<String, String>();
	UUID uuid=UUID.randomUUID();
	
	@BeforeMethod
	public void createPlayLoad()
	{
		map.put("name", "Batman");
		map.put("email",  uuid+"@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI="https://gorest.co.in/";
		RestAssured.basePath="public/v2/users";
				
		
	}
	
	@Test
	public void createResource()
	{
		RestAssured
		    .given()
		          .contentType("application/json")
		          .body(map)
		          .header("Authorization", "Bearer 105065427fd0ddbfd8e698cc7d14e5171a78342e5d21aa420021be5e9053f627")
		     .when()
		         .post()
		     .then()
		          .statusCode(201)
		          .log().all();
	}

}
