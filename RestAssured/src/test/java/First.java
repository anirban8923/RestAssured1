import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class First {

// pushed into github
    @Test
    public void test() {




        Response response = RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(response.statusCode());
        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.statusLine());
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);

    }

    @Test
    public void test1() {
      /*  given().get("https://reqres.in/api/users/").then().statusCode(200).body("data.first_name[0]", equalTo("George"));*/
        given().get("https://reqres.in/api/users/1").then().statusCode(200).body("data.id", equalTo(1));
        given().get("https://reqres.in/api/users/").then().statusCode(200).body("data.id[0]", equalTo(1));

    }
}