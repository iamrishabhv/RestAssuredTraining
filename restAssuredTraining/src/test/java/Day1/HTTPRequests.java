package Day1;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class HTTPRequests {
	
//	@Test
	void getUsers() {
		given()
		
		.when()
			.get("https://reqres.in/api/users?page=2")
		
		.then()
			.statusCode(200)
			.body("page",equalTo(2))
			.log().all();
	}
	
//	@Test
	void createUser() {
		
		HashMap data = new HashMap();
		  data.put("username","rishabhv");
		  data.put("email","rishabh.v@test.com");
		  data.put("password","12345");
		
		given()
			.header("x-api-key", "reqres-free-v1")
			.contentType("application/json")
			.body(data)
		
		.when()
			.post("https://reqres.in/api/users")
		
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	void getUserById() {
		given()
			.header("x-api-key", "reqres-free-v1")
		
		.when()
			.get("https://reqres.in/api/users?id=8")
		
		.then()
			.statusCode(200)
			.body("data.first_name",equalTo("Lindsay"))
			.log().all();
	} 
	

}
