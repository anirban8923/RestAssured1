import io.restassured.path.json.JsonPath;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;




public class RestAssuredAPITest {
	 @Test //This annotation will mark this as test at compile time
	 public void GetStatus() {
	  RestAssured.baseURI = "https://reqres.in/api/users/"; // Set the base URL.
	  RequestSpecification httpRequest = RestAssured.given(); 
	  Response response = httpRequest.request(Method.GET, "");

	  System.out.println("status code " +response.statusCode());
	  Assert.assertEquals(response.getStatusCode(), 200);

	  System.out.println(response.statusLine());

	  System.out.println("Status received => " + response.getBody().asString()); //Print the status response

		 System.out.println(response.getHeader("Content-Type"));

		 Assert.assertEquals(response.getHeader("Content-Type"), "application/json; charset=utf-8");
	  
           //$.data[0].id
	  
	  System.out.println((Integer) (response.jsonPath().get("data[0].id")));
		 //response.jsonPath().get("data[0].id");
		 System.out.println("====================================");
		 JsonPath jsonPathEvaluator = response.jsonPath();
		 int title = jsonPathEvaluator.get("data[0].id");
		 System.out.println(title);




	  
	  
	 }
 }
