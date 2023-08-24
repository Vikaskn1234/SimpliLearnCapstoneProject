package in.amazon.ApiTestAssured;

import java.util.HashMap;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class PUTDemo {
	
	
	HashMap<String, String> map=new HashMap<String, String>();
	
	
	@BeforeTest
	public void createPayLoad()
	{
		map.put("name", "morpheus");
		map.put("job", "programmer");
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/user/475";
		
	}
	
	@Test
	public void updateResource()
	{
	  RestAssured
	      .given()
	           .contentType("application/json")
	           .body(map)
	      .when()
	            .put()
	      .then()
	            .statusCode(200)
	            .log().all();
		
	}

}
