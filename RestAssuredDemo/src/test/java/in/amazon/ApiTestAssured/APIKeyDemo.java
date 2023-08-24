package in.amazon.ApiTestAssured;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIKeyDemo {
	
	@Test
	public void getweatherInfo()
	{
		RestAssured
		    .given()
		          .param("q", "chennai")
		          .param("appid", "ae44543fbc391fb5c98131059f6bce49")
		    .when()
		         .get("https://api.openweathermap.org/data/2.5/weather")
		         
		     .then()
		          .statusCode(200)
                  .log().all();		          
	}

}
