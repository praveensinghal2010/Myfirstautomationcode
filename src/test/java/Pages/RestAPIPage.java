package Pages;

import org.testng.Assert;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import io.restassured.http.ContentType;
import Helper.CsvUtils;
import io.restassured.http.Header;
import org.json.JSONArray;
import org.json.JSONObject;


import static org.testng.Assert.fail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import org.testng.Assert;
import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;

public class RestAPIPage {
	
	private String baseUri;
    private String objectId;
    private Response response;
    private ObjectMapper objectMapper;
    private User user;
    private Product product;
    String requestbody;
  
    private JSONObject requestBody;
    private Map<String, String> requestAttributes = new LinkedHashMap<>();
    private Map<String, String> responseAttributes = new LinkedHashMap<>();
    List<Map<String, String>> tabledata = new ArrayList<>();

	
    
    public void setBaseUri(String uri) {
        this.baseUri = uri;
    }
    
    public void setObjectId(String id) {
        this.objectId = id;
    }
    
    public void sendGetRequest(String endpoint) {
        response = RestAssured.given().baseUri(baseUri).pathParam("id", objectId).get(endpoint);
       // response = RestAssured.given().baseUri(baseUri).pathParam("id", objectId).auth().basic("abc", "abc").get(endpoint);
        //response=RestAssured.get(baseUri);
    }
    
    public void verifyStatusCode(int expectedStatusCode) {
        int actualStatusCode = response.getStatusCode();
        String statusline =response.getStatusLine();
        Assert.assertEquals(expectedStatusCode, actualStatusCode);
    }

    
    public void verifyResponseBodyContainsAttribute(String attribute) {
        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains(attribute));
    }

 
    public void verifyResponseBodyAttribute(String attribute, String expectedValue) {
        String actualValue = response.jsonPath().getString(attribute);
        Assert.assertEquals(expectedValue, actualValue);
    }
//###################################################################################################################
    
    public void setRequestBody(io.cucumber.datatable.DataTable dataTable) {
        requestBody = new JSONObject();
        dataTable.asLists().forEach(row -> requestBody.put(row.get(0), row.get(1)));
    }
    
    public void sendPOSTRequest(String endpoint) {
    	String filePath="abc";
    	response = RestAssured.given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(endpoint);
    	
    	
    	
    //Note:--When need to upload a file or image use below code in post request
    //	.multiPart("file", new File(filePath), "multipart/form-data")
    }
    
    
    public void validateStatusCode(int statusCode) {
        response.then().statusCode(statusCode);
    }
    
 //#####################################################################################################
    
    
    public void loadRequestAttributesFromCsv(String csvFilename) throws IOException {
    	
        Path csvFilePath = Paths.get("src/test/resources", csvFilename);
        requestAttributes = CsvUtils.readCsvToMap(csvFilePath);
        requestBody = new JSONObject();
        JSONObject dataObject = new JSONObject();
        for (Map.Entry<String, String> entry : requestAttributes.entrySet()) {
            String key = entry.getKey().replace("=", ".");
            String value = entry.getValue();
            key = key.replaceAll("\"", ""); // Remove the extra backslashes
            value= value.replaceAll("\"", "");
            if (key.startsWith("data.")) {
                // Extract the nested key
                String nestedKey = key.substring(5); // Remove "data." prefix

                // Add the nested key-value pair to the data object
                dataObject.put(nestedKey, value);
            } else {
                // Add the key-value pair directly to the request body
                requestBody.put(key, value);
            }
            
        }
        requestBody.put("data", dataObject);
        String jsonRequest = requestBody.toString();
    }
    
    public void makePostRequest(String endpoint) {
        
    	response = RestAssured.given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(requestBody.toString())
                .post(endpoint);
    	String responseBody = response.getBody().asString();
        String abc=":a";
}
    
    
    public void validateResponseAttributesAgainstCsv(String csvFilename) throws IOException {
        Path csvFilePath = Paths.get("src/test/resources", csvFilename);
        responseAttributes = CsvUtils.readCsvToMap(csvFilePath);
       // for (Map<String, String> expectedAttribute : responseAttributes) {
            for (Map.Entry<String, String> entry : responseAttributes.entrySet()) {
                String attributeName = entry.getKey();
                String expectedValue = entry.getValue();
                attributeName = attributeName.replaceAll("\"", ""); // Remove the extra backslashes
                expectedValue= expectedValue.replaceAll("\"", "");
                
                String actualValue = response.jsonPath().getString(attributeName);

                if (expectedValue.startsWith("/") && expectedValue.endsWith("/")) {
                    // Attribute value is a regex pattern
                    String regexPattern = expectedValue.substring(1, expectedValue.length() - 1);
                    Pattern pattern = Pattern.compile(regexPattern);
                    Assert.assertTrue(actualValue.matches(regexPattern),
                            "Attribute value does not match regex pattern: " + regexPattern);
                } else {
                    // Attribute value is an exact match
                	String responseBody = response.getBody().asString();
                    Assert.assertEquals("Attribute value does not match", expectedValue, actualValue);
                }
            }
        }
    
    
 // ############################################################################################################3
  
    public void validateResponseHeaders(DataTable table) {
    	
    	List<Map<String,String>> headers= table.asMaps(String.class,String.class);
        for (Map<String, String> header : headers) {
            String headerName = header.get("HeaderName");
            String headerValue = header.get("HeaderValue");

            String responseHeader = response.getHeader(headerName);
            
            if(!headerValue.equals(responseHeader))
            {
            	Assert.fail();
            }

            
        }
    }
    
//###########################################################################################3
    
    
    public void verifyNameForDataObject(String name, int id)
    {
    	
    	 List<Map<String, Object>> dataArray = response.jsonPath().getList("data");

         // Find the data object with the desired id
         Map<String, Object> targetDataObject = null;
         for (Map<String, Object> dataObject : dataArray) {
             int id1 = (int) dataObject.get("id");
             if (id == id1) {
                 targetDataObject = dataObject;
                 break;
             }
         }

         // Perform assertions on the targetDataObject
         if (targetDataObject != null) {
             String firstName = (String) targetDataObject.get("first_name");
             String lastName = (String) targetDataObject.get("last_name");

             // Perform your assertions on firstName, lastName, or any other attributes
             String expectedFirstName = name;
             String expectedLastName = "Expected Last Name";

             Assert.assertEquals(expectedFirstName, firstName);
             Assert.assertEquals(expectedLastName, lastName);
         } else {
             Assert.fail("Data object with id=" + objectId + " not found in the response.");
         }
     }
 
 //####################################################################################################3
    
    
    public void validateAPIRequest() {
       
        String endpoint = "public/v2/users";

        // Create the request payload
        String requestBody = "{\n" +
                "    \"name\": \"fsdfsdfsdfsdfsdfds\",\n" +
                "    \"email\": \"uytyuewrtertertdfdf@gmail.com\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"Active\"\n" +
                "}";

        // Send the POST request
        Response response = RestAssured.given()
                .baseUri(baseUri).headers("Authorization","Bearer ddcdc2ba3b033ac535f191e9b9e32b4934e0048de2a29a45d4f5f0bc5a9c2cbe")
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(endpoint);

        String abc=response.body().asString();
        String abc1="abc";
    
    
    String fdsfsdf="fsdfs";
    
    }
    
    
    
//############################################################################################################################3  
    
    public void Requestattriuteisarray(String hobbies, DataTable table) 
    
    {
    	JSONArray addressArray = new JSONArray();
    	
    	
    	for (String address : table.asList()) {
            addressArray.put(address);
        }
    	requestBody.put(hobbies, addressArray);
    	
    }
    
    
    public void Requestisdataobject(String TechSkills,DataTable dataTable) {
        JSONObject dataObject = new JSONObject();
        dataTable.asLists().forEach(row -> dataObject.put(row.get(0), row.get(1)));
        
              requestBody.put(TechSkills, dataObject);
              
            
              String jsonRequest = requestBody.toString();
              String abc="abc";
              
    }
    
    
    
 //#######################################################################################################3   
    
    
    public void setRequestBody(String requestBody) {
        objectMapper = new ObjectMapper();
        user=new User();
        try {
            user = objectMapper.readValue(requestBody, User.class);
            String a="abc";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    public void makePostRequestusingPOJO(String endpoint) {
    
        response = RestAssured.given()
                .baseUri(baseUri).headers("Authorization","Bearer ddcdc2ba3b033ac535f191e9b9e32b4934e0048de2a29a45d4f5f0bc5a9c2cbe")
                .contentType(ContentType.JSON)
                .body(user)
                .post(endpoint);
        
        
        String body=response.body().asString();
        
       
    }
    
    
//############################################################################################################
    
    public void setRequestBodyforrestful(String requestBody) {
        objectMapper = new ObjectMapper();
        product=new Product();
        try {
            product = objectMapper.readValue(requestBody, Product.class);
            String a="abc";
        } catch (Exception e) {
            e.printStackTrace();
        }
    	
    	
    //	this.requestbody=requestBody;
    	
    }
    
    
    public void makePostRequestusingPOJOforrestful(String endpoint) {
        
        response = RestAssured.given()
                .baseUri(baseUri)
                .contentType(ContentType.JSON)
                .body(product)
                .post(endpoint);
        
        
//        response = RestAssured.given()
//                .baseUri(baseUri)
//                .contentType(ContentType.JSON)
//                .body(requestbody)
//                .post(endpoint);
        
        
//        String body=response.body().asString();
//        
//       String abc="abc";
    }
    
    
    
//########################################################################################################################3
    
//This is the code to authenticate microsoft azure using auth 2.0
    
    //1. we can get client id/secret key/tenant id from azure portal
    
//    import io.restassured.RestAssured;
//    import io.restassured.http.ContentType;
//    import io.restassured.response.Response;
//    import org.junit.Assert;
//
//    public class MyAPITest {
//
//        private String accessToken;
//
//        @Given("I authenticate with the API")
//        public void authenticateWithAPI() {
//            // Step 1: Open a browser window and authenticate the user using Selenium
//            // ...
//            // Obtain the authorization code from the redirected URL
//
//            // Step 2: Exchange authorization code for access token
//            String tokenEndpoint = "https://gorest.co.in/oauth/token";
//            String clientId = "your-client-id";
//            String clientSecret = "your-client-secret";
//            String redirectUri = "https://your-redirect-uri";
//
//            Response response = RestAssured.given()
//                    .baseUri(tokenEndpoint)
//                    .contentType(ContentType.URLENC)
//                    .param("grant_type", "authorization_code")
//                    .param("code", "your-authorization-code")
//                    .param("client_id", clientId)
//                    .param("client_secret", clientSecret)
//                    .param("redirect_uri", redirectUri)
//                    .post();
//
//            // Retrieve the access token from the response
//            accessToken = response.jsonPath().getString("access_token");
//        }
//
//        @When("I send a request to the API endpoint")
//        public void sendRequestToAPIEndpoint() {
//            String apiEndpoint = "https://gorest.co.in/public/v2/users";
//
//            Response response = RestAssured.given()
//                    .baseUri(apiEndpoint)
//                    .header("Authorization", "Bearer " + accessToken)
//                    .get();
//
//            // Perform assertions or validations on the API response
//            // ...
//        }
//
//        @Then("I validate the API response")
//        public void validateAPIResponse() {
//            // Assert the expected results or perform validations on the API response
//            // ...
//        }
//    }
//
//    
    
    
    
    
}

    

    
    
//}
