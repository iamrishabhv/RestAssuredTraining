package restfulBooker;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

public class BookerRestfulAPIs {
	
	@Test
	void CreateToken() {
		HashMap HM = new HashMap();
		HM.put("username", "admin");
		HM.put("password", "password123");
		
		given()
			.contentType("application/json")
			.body(HM)
		
		.when()
			.post("https://restful-booker.herokuapp.com/auth")
		
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void GetBookingIds() {
		given()
			.header("token", "b90027bb0632b77")
		
		.when()
			.get("https://restful-booker.herokuapp.com/booking")
			
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void GetBookingIdByName() {
		given()
			.header("token", "b90027bb0632b77")
		
		.when()
			.get("https://restful-booker.herokuapp.com/booking?firstname=Sally&lastname=Brown")
		
		.then()
			.statusCode(200)
			.log().all();
	}

}
