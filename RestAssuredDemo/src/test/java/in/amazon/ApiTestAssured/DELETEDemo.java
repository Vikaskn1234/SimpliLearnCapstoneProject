package in.amazon.ApiTestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DELETEDemo {
	
	@Test
	public void deleteResources()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.basePath="/api/users/475";
		
		RestAssured
		    .when()
		          .delete()
		    .then()
		         .statusCode(204);
	}

}
