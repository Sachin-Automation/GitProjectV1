import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class Passanger {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://gorest.co.in";
		JSONObject request = new JSONObject();
		
//		request.put("id", 3703);
//		request.put("name", "Sweta Namboothiri")
//		request.put("name", "Sweta Namboothiri")
		
		given().log().all().body("{\"id\":3706,\"name\":\"Sweta Namboothiri\",\"email\":\"12abcsweta_namboothiri@mayer.co\",\"gender\":\"male\",\"status\":\"inactive\"}");
		given().header("Authorization", "Bearer 6f98c7399ca817c607e20c65a5acd392af158dced4c4b2967301052c62e2d068")
		.when().post("/public/v2/users")
		.then().log().all().assertThat().statusCode(201);
		// .body("job",equalTo("leader"))
		// .header("X-Powered-By", "Express")

	}

}
