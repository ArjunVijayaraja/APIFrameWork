package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
//import pojo.Location;
//import pojo.PlaceData;
import resourses.TestDataBuild;
import resourses.Utils;

public class StepDefinition extends Utils {

	RequestSpecification req;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();

	@Given("Add Place Payload")
	public void add_place_payload() {
		// Write code here that turns the phrase above into concrete actions
		
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		req = given().spec(requestSpecification()).body(data.addPlacePayload());
	}

	@When("user calls {string} with POST http request")
	public void user_calls_with_post_http_request(String string) {
		// Write code here that turns the phrase above into concrete actions
		response = req.when().post("/maps/api/place/add/json").then().spec(resSpec).log().body().extract().response();
				//.asString();
	}
	
	

	@Then("the API call is success with status code {int}")
	public void the_api_call_is_success_with_status_code(Integer int1) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(response.getStatusCode(), 200);
		
		
	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String keyValue, String expectedValue) {
		// Write code here that turns the phrase above into concrete actions
		String resp = response.asString();
		JsonPath js = new JsonPath(resp);
		assertEquals(js.getString(keyValue).toString(),expectedValue);
	}

}
