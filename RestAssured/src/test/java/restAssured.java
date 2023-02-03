
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
        import org.testng.annotations.Test;

        import static io.restassured.RestAssured.given;
        import static org.hamcrest.Matchers.equalTo;

public class restAssured {

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

    @Test
    public void GetStatus() {
        RestAssured.baseURI = "https://reqres.in/api/users"; // Set the base URL.
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "");
        System.out.println("Status received => " + response.getStatusLine()); //Print the status response--200
    }

    @Test
    public void ValidateHeaders() {
        RestAssured.baseURI = "https://reqres.in/api/users/";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();

        String contentType = response.header("Content-Type"); // Access header with a given name. Header = Content-Type
        System.out.println(contentType);

        Assert.assertEquals(contentType /* actual value */, "application/json; charset=utf-8" /* expected value */);

         String serverType = response.header("Server");
        System.out.println(serverType);
        Assert.assertEquals(serverType /* actual value */, "cloudflare" /* expected value */);

    }

    @Test
    public void GetShelveBody()
    {
        RestAssured.baseURI = "https://reqres.in/api/users/";;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("");
        ResponseBody body = response.getBody(); //Get the response body
        System.out.println("Response Body is: " + body.asString());// By using this we //can have the response as string
    }

    @Test
    public void VerifyTitleInJsonResponse()
    {
        RestAssured.baseURI = "https://reqres.in/api/users/";
        RequestSpecification  httpRequest = RestAssured.given();
        Response response = httpRequest.get();
// First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();
// Then simply query the JsonPath object to get a String value of the node
        String title = jsonPathEvaluator.get("data[1].email");
// Let us print the city variable to see what we got
        System.out.println("City received from Response " + title);
// Validate the response
        Assert.assertEquals(title, "janet.weaver@reqres.in", "Error");
    }

    @Test
    public void VerifyPlaceInJsonResponse()
    {
        RestAssured.baseURI = "https://reqres.in/api/users/";
        RequestSpecification  httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        JsonPath jsonPathEvaluator = response.jsonPath();
// speciﬁed by JsonPath: Place (Note: You should not put $. in the Java code)
        String place = jsonPathEvaluator.get("data[2].avatar");
        System.out.println("Avatar Name " + place);
        Assert.assertEquals(place, "https://reqres.in/img/faces/3-image.jpg", "Correct place name is not received in the Response");
    }

    @Test
    public void DisplayAllNodesInWeatherAPI()
    {
        RestAssured.baseURI = "https://reqres.in/api/users/";
        RequestSpecification  httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        JsonPath jsonPathEvaluator = response.jsonPath();
        System.out.println("Id-1 " + jsonPathEvaluator.get("data[0].id"));
        System.out.println("Id-2 " + jsonPathEvaluator.get("data[1].id"));
        System.out.println("Id-3 " + jsonPathEvaluator.get("data[2].first_name")); // emma
        System.out.println("Id-4 " + jsonPathEvaluator.get("data[3].id"));
    }

}