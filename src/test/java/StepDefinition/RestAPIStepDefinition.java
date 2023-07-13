package StepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import Pages.RestAPIPage;

public class RestAPIStepDefinition {
	
	RestAPIPage api=new RestAPIPage();
	
	@Given("the base URI is {string}")
	public void the_base_uri_is(String url) {
		api.setBaseUri(url);
	}

	@Given("an object ID is {string}")
	public void an_object_id_is(String id) {
		api.setObjectId(id);
	}

	@When("a GET request is made to {string}")
	public void a_get_request_is_made_to(String endpoint) {
		api.sendGetRequest(endpoint);
	}
	
	

	@Then("the response status code should be {int}")
	public void the_response_status_code_should_be(Integer responsecode) {
		api.verifyStatusCode(responsecode);
	}

	@Then("the response body contains attribute {string}")
	public void the_response_body_contains_attribute(String id) {
	 
		api.verifyResponseBodyContainsAttribute(id);
	}
	
	
	@Then("the response body attribute name {string} is {string}")
	public void the_response_body_attribute_name_is(String attribute, String value) {
		api.verifyResponseBodyAttribute(attribute, value);
	}

	

	@Then("the response body attribute year {string} is {string}")
	public void the_response_body_attribute_year_is(String attribute, String value) {
		api.verifyResponseBodyAttribute(attribute, value);
	}
	    
	
	@Then("the response body attribute price {string} is {string}")
	public void the_response_body_attribute_price_is(String attribute, String value) 
	{
		api.verifyResponseBodyAttribute(attribute, value);
	}

	@Then("the response body attribute model {string} is {string}")
	public void the_response_body_attribute_model_is(String attribute, String value) 
	{
		api.verifyResponseBodyAttribute(attribute, value);
	}

	@Then("the response body attribute size {string} is {string}")
	public void the_response_body_attribute_size_is(String attribute, String value) {
		api.verifyResponseBodyAttribute(attribute, value);
	}

	@Then("the response body contains attribute createdact {string}")
	public void the_response_body_contains_attribute_createdact(String attributecreate) {
	    
		api.verifyResponseBodyContainsAttribute(attributecreate);
	}
//#####################################################################################################################


	@Given("the request body is:")
	public void the_request_body_is(io.cucumber.datatable.DataTable dataTable) {
		api.setRequestBody(dataTable);
	}

	@When("a POST request is made to {string}")
	public void a_post_request_is_made_to(String endpoint) {
		api.sendPOSTRequest(endpoint); 
	}
	@Then("the response body attribute name value {string} is {string}")
	public void the_response_body_attribute_name_value_is(String string, String string2) {
	    //
	}

	@Then("the response body attribute year value {string} is {int}")
	public void the_response_body_attribute_year_value_is(String string, Integer int1) {
	    
	}

	@Then("the response body attribute price value {string} is {double}")
	public void the_response_body_attribute_price_value_is(String string, Double double1) {
	    
	}

	@Then("the response body attribute model value {string} is {string}")
	public void the_response_body_attribute_model_value_is(String string, String string2) {
	    
	}

	@Then("the response body attribute size value {string} is {string}")
	public void the_response_body_attribute_size_value_is(String string, String string2) {
	    
	}



	
	


	
//################################################################################################################################
	
	
	@Given("the request body attributes are given in the excel")
	public void the_request_body_attributes_are_given_in_the_excel() throws IOException {
		String csvFilename="request.csv";
		api.loadRequestAttributesFromCsv(csvFilename);
	
	}

	@When("a post request is made for the excel sheet {string}")
	public void a_post_request_is_made_for_the_excel_sheet(String endpoint) {
		api.makePostRequest(endpoint);
	}

	@Then("response attributes should be matched with excel attributes and values")
	public void response_attributes_should_be_matched_with_excel_attributes_and_values() throws IOException {
		String csvFilename="response.csv";
		api.validateResponseAttributesAgainstCsv(csvFilename);
		
	}
//#################################################################################################################

	@Then("the response should contain the headers")
	public void the_response_should_contain_the_headers(io.cucumber.datatable.DataTable dataTable) {
       
		api.validateResponseHeaders(dataTable);

	}

//#####################################################################################################
	
	
	@Then("the response body contains first name {string} where id is {int}")
	public void the_response_body_contains_first_name_where_id_is(String name, Integer id) {
	    api.verifyNameForDataObject(name,id);
	}

//###############################################################################################33
	
	@When("the request body attributes are")
	public void the_request_body_attributes_are(String docString) {
	    api.validateAPIRequest();
	}

//###################################################################################################3
	
	@Given("the request body contains an {string} array")
	public void the_request_body_contains_an_array(String hobbies, io.cucumber.datatable.DataTable dataTable) {
		
		api.Requestattriuteisarray(hobbies,dataTable);
	    
	}

	@Given("the request body contains an {string} dataobject")
	public void the_request_body_contains_an_dataobject(String TechSkills, io.cucumber.datatable.DataTable dataTable) {
	    
       api.Requestisdataobject(TechSkills,dataTable);
	
	}
	
	
	
//####################################################################################################################################3
	
	@Given("the request body attribute is")
	public void the_request_body_attribute_is(String docString) {
	    api.setRequestBody(docString);
	}


	@When("a POST request is made to {string} using pojo class and object mapper")
	public void a_post_request_is_made_to_using_pojo_class_and_object_mapper(String endpoint) {
	   api.makePostRequestusingPOJO(endpoint);
	}


//#######################################################################################################
	
	@Given("the request body attribute for restful api")
	public void the_request_body_attribute_for_restful_api(String docString) {
		api.setRequestBodyforrestful(docString);
	}

	
	

	
	@When("a POST request is made to {string} using object mapper restful api")
	public void a_post_request_is_made_to_using_object_mapper_restful_api(String endpoint) {
		 api.makePostRequestusingPOJOforrestful(endpoint);
	}
	
}
