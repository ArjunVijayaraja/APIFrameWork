package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.IOException;
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
import resources.API_Resources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils {

	RequestSpecification req;
	ResponseSpecification resSpec;
	Response response;
	TestDataBuild data = new TestDataBuild();

//	This is for normal without dyanmic data
//	@Given("Add Place Payload")
//	public void add_place_payload() throws IOException {
//		// Write code here that turns the phrase above into concrete actions
//		
//		req = given().spec(requestSpecification()).body(data.addPlacePayload());
//	}

	// This is for dynamic data
	@Given("Add Place Payload with {string} {string} {string}")
	public void add_Place_Payload_with(String name, String language, String address) throws IOException {
		req = given().spec(requestSpecification()).body(data.addPlacePayload(name, language, address));
	}

	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resourceEndPoint, String httpMethod) {
		// Write code here that turns the phrase above into concrete actions
		API_Resources APIsource = API_Resources.valueOf(resourceEndPoint);
		System.out.println(APIsource.getResource());
		resSpec = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		
		if(httpMethod.equalsIgnoreCase("POST"))
			response = req.when().post(APIsource.getResource());
		else if (httpMethod.equalsIgnoreCase("GET")) 
				response = req.when().get(APIsource.getResource());
		
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
		assertEquals(js.getString(keyValue).toString(), expectedValue);
	}

}
