package StepDefinition27;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.net.http.HttpTimeoutException;

import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import POJOMapper.CreateEmployee;
import Utilities.FetchDataFromProperty;
import Utilities.SetExcelValue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


public class StepDefinition27 {
	
	RequestSpecification req;
	RequestSpecification respec;
	ResponseSpecification res;
	Response response;
	int Status_code=201;
	
	String URI_reqres= FetchDataFromProperty.getDataFromProperty().getProperty("base_uri");
	String apiKey_val=FetchDataFromProperty.getDataFromProperty().getProperty("api_key");
	String URI_gorest=FetchDataFromProperty.getDataFromProperty().getProperty("base_uri_gorest");
	String bearerToken=FetchDataFromProperty.getDataFromProperty().getProperty("bearer_token");
	
	@Given("user hits the reqres server with baseuri")
	public void user_hits_the_reqres_server_with_baseuri() 
	{
		req=new RequestSpecBuilder().setBaseUri(URI_reqres).setContentType(ContentType.JSON)
				.setRelaxedHTTPSValidation().addHeader("x-api-key", apiKey_val).build();
				
		
	}

	@Given("user passes the payload data along with request and hits the {string}")
	public void user_passes_the_payload_data_along_with_request_and_hits_the(String endpoint) throws JsonProcessingException 
	{
	   
		respec= given().log().all().     spec(req)
				.body(CreateEmployee.createEmp());
		
		 res=new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(Status_code).expectHeader("Server", "cloudflare").build();
		
		
		 response=	 respec.when().post(endpoint).then().log().all().
			spec(res).extract().response();
		
		
	}

	
	
	
	

	@When("user gets the response from the server")
	public void user_gets_the_response_from_the_server() 
	{
	   
		String res_String=response.asString();
		JsonPath js=new JsonPath(res_String);
	int ID=	js.getInt("id");
	if(ID>0)
	{
		System.out.println("Test case passed");
	}
	else
	{
		throw new ArithmeticException("ID not generated");
	}
	
	
	
		
		
	}

	@Then("user validates the reponse with {string}")
	public void user_validates_the_reponse_with(String response_code) throws HttpTimeoutException 
	{
	  long restime=  response.getTime();
	  if(restime>5000)
	  {
		  throw new HttpTimeoutException("Time limit exceeded");
	  }
	  
	  else
	  {
		  System.out.println("response time is within threshold");
	  }
	  
	  Integer code=response.getStatusCode();
	  String Actual_code=code.toString();
	  Assert.assertEquals(Actual_code, response_code);
	  
	  
		
		
	}
	
	
	@Given("user establish connection with server")
	public void user_establish_connection_with_server() 
	{
		req= new RequestSpecBuilder().setBaseUri(URI_gorest).setContentType(ContentType.JSON)
				.addHeader("Authorization",bearerToken).build();
	}

	@Given("user sends a payload body")
	public void user_sends_a_payload_body() throws IOException 
	{
	   respec= given().log().all().spec(req).body(SetExcelValue.setExcelValue());
	}

	@When("user hits the go rest endpoint with details as {string}")
	public void user_hits_the_go_rest_endpoint_with_details_as(String endpoint) 
	{
	 
		res=new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.build();
		 response=	 respec.when().post(endpoint).then().log().all().
					spec(res).extract().response();
		
	}

	@Then("user validates the response time and status code as {string}")
	public void user_validates_the_response_time_and_status_code_as(String status_code) throws HttpTimeoutException 
	{
	   
		
		 long restime=  response.getTime();
		  if(restime>5000)
		  {
			  throw new HttpTimeoutException("Time limit exceeded");
		  }
		  
		  else
		  {
			  System.out.println("response time is within threshold");
		  }
		  
		  Integer code=response.getStatusCode();
		  String Actual_code=code.toString();
		  Assert.assertEquals(Actual_code, status_code);
		
	}






	
	
	

}
