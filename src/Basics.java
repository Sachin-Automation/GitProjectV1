import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.SynchronousQueue;

import org.hamcrest.Matchers;
import org.testng.Assert;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       
		
		// given -all input details
		//when - submit the API -resorce,http Method
		//Then - Validate the response
	RestAssured.baseURI="https://reqres.in/api";
		String response= given().log().all().body("{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}").when().post("/users")
		.then().assertThat().statusCode(201).extract().response().asString();
		//.body("name",equalTo("morpheus"));
		//.header("X-Powered-By", "Express")
		
		
		System.out.println(response);
		
		JsonPath js =new JsonPath(response); //for parsing json
		int id = js.getInt("id");
		System.out.println("Print id ="+js.getString("id"));
		System.out.println(id); 
		
		System.out.println("Strart PUT Method");
		
		//Update name
		String responsePut =given().log().all().body("{\r\n" + 
				"    \"name\": \"Sachin\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}")
				.when().put("/users/2")
		.then().assertThat().statusCode(200).extract().response().asString();
		//.body("name", equalTo("Sachin"));
		
		System.out.println(responsePut);
		
		JsonPath jsput =new JsonPath(response); //for parsing json
		String updateAt = jsput.getString("updatedAt");
		System.out.println(updateAt);
		//Assert.assertEquals("updateAt", "Sachin");
		
		System.out.println("Strat GET Method");
		
		String responseGet = given().log().all()
		.when().get("/users?page=2")
		.then().assertThat().statusCode(200).extract().response().asString();
		//.body("total", equalTo("12"))
		 
		System.out.println(responseGet);
		
		JsonPath jsGet = new JsonPath(responseGet);
		System.out.println(jsGet);
		int ref = jsGet.getInt("total");
		System.out.println("Value of Total:"+ref);
		//Assert.assertEquals(ref, 12);
		
	}

}
