package in.amazon.ApiTestAssured;

import java.util.HashMap;
import java.util.UUID;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.is;

public class Create_Update_Delete__Resource extends TestBase {
	HashMap<String, String> map=new HashMap<String, String>();
	UUID uuid=UUID.randomUUID();
	int id;
	Response response;
	JsonPath jsonPath;
	
	@Test(priority=0)
	public void createPlayload()
	{
		map.put("name", "Captain Planet");
		map.put("email", uuid+"@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI="https://gorest.co.in/";
		RestAssured.basePath="public/v2/users";
		logger.info("Payload created");
		
		
	}
	@Test(priority=1)
	public void createResource()
	{
		response=RestAssured
				             .given()
				               .contentType("application/json")
				               .body(map)
				               .header("Authorization", "Bearer 105065427fd0ddbfd8e698cc7d14e5171a78342e5d21aa420021be5e9053f627")
				             .when()
				               .post()
				             .then()
				         
				                .extract().response();
		logger.info("Resource created Sucessfully");
		jsonPath=response.jsonPath();
		id=jsonPath.get("id");
		System.out.println(id);
				               
	}
	
	@Test(priority=2)
	public void verifyResource()
	{
		System.out.println("ID ="+id);
		RestAssured
		.given()
		      .contentType("application/json")
		      .header("Authorization","Bearer 105065427fd0ddbfd8e698cc7d14e5171a78342e5d21aa420021be5e9053f627")
		 .when()
		      .get("https://gorest.co.in/public/v2/users/"+id)
		 .then()
		      .statusCode(200);
		      
		Assert.assertTrue(jsonPath.get("name").equals("Captain Planet"));
		logger.info("Resource verify sucefully");
		
	}
	
	@Test(priority=3)
	public void updateResource()
	{
		map.put("name", "Captain Planett");
		map.put("email", uuid+"@gmail.com");
		map.put("gender", "male");
		map.put("status", "active");
		RestAssured.baseURI="https://gorest.co.in/";
		RestAssured.basePath="public/v2/users/"+id;
		
		RestAssured
		   .given()
		        .contentType("application/json")
	            .header("Authorization","Bearer 105065427fd0ddbfd8e698cc7d14e5171a78342e5d21aa420021be5e9053f627")
	            .body(map)
	    .when()
	        .put()
	    .then()
	         .statusCode(200)
	        
	         .assertThat()
	         .body("name", is("Captain Planett"));
		
		logger.info("Resource Updated");
		
	}
	@Test(priority=4)
	public void deleteResource()
	{
		RestAssured.baseURI="https://gorest.co.in/";
		RestAssured.basePath="public/v2/users/"+id;
		
		RestAssured
		   .given()
		        .contentType("application/json")
	            .header("Authorization","Bearer 105065427fd0ddbfd8e698cc7d14e5171a78342e5d21aa420021be5e9053f627")
	       .when()
	            .delete()
	       .then()
	            .statusCode(204);
		logger.info("Resource deleted");
	}
	

}
