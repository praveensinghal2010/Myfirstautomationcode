Feature: Object API Testing

  @api3
  Scenario: Create an object
    Given the base URI is "https://api.restful-api.dev"
    And the request body is:
      | name                | Apple MacBook Pro 16 |
      | data.year           |                 2019 |
      | data.price          |              1849.99 |
      | data.CPU model      | Intel Core i9        |
      | data.Hard disk size | 1 TB                 |
    When a POST request is made to "/objects"
    Then the response status code should be 200
    And the response body contains attribute "id"
    And the response body attribute name value "name" is "Apple MacBook Pro 16"
    And the response body attribute year value "data.year" is 2019
    And the response body attribute price value "data.price" is 1849.99
    And the response body attribute model value "data.CPU model" is "Intel Core i9"
    And the response body attribute size value "data.Hard disk size" is "1 TB"

  ###############################################################################
  @api6
  Scenario: Retrieve an object
    Given the base URI is "https://api.restful-api.dev"
    And an object ID is "7"
    When a GET request is made to "/objects/{id}"
    Then the response status code should be 200
    And the response body contains attribute "id"
    And the response body attribute name "name" is "Apple MacBook Pro 16"
    And the response body attribute year "data.year" is "2019"
    And the response body attribute price "data.price" is "1849.99"

  ###########################################################################################
  @api2
  Scenario: Create an object post request using csv request
    Given the base URI is "https://api.restful-api.dev"
    And the request body attributes are given in the excel
    When a post request is made for the excel sheet "/objects"
    Then the response status code should be 200
    And response attributes should be matched with excel attributes and values

  ###############################################################################################3
  @headers
  Scenario: Validate headers of a response
    Given the base URI is "https://api.restful-api.dev"
    And an object ID is "7"
    When a GET request is made to "/objects/{id}"
    Then the response status code should be 200
    And the response should contain the headers
      | HeaderName   | HeaderValue      |
      | Content-Type | application/json |
      | Connection   | keep-alive       |

  ####################################################################################################
  @api7
  Scenario: Retrieve an object from an array
    Given the base URI is "https://reqres.in"
    And an object ID is "2"
    When a GET request is made to "api/users?={id}"
    Then the response status code should be 200
    And the response body contains first name "George" where id is 1

  ###################################################################################################
  @api8
  Scenario: Post a request using bearer tokens
    Given the base URI is "https://gorest.co.in"
    #When a POST request is made to "public/v2/users"
    And the request body attributes are
      """
        {
            "name": "chematiya",
            "email": "sukar@gmail1234.com",
            "gender": "female",
            "status": "Active"
        }
      """
    Then the response status code should be 200

  ################################################################################################
  @api9
  Scenario: Create an object for json byte stream to map
    Given the base URI is "https://reqres.in"
    And the request body is:
      | firstName | Amodfdsfds |
      | lastName  | Mahajan    |
      | age       |         28 |
      | salary    |     200000 |
      | IsMarried | true       |
    And the request body contains an "Hobbies" array
      | Music    |
      | Computer |
      | Games    |
    And the request body contains an "TechSkills" dataobject
      | Programming language | Java         |
      | WebAutomation        | Selenium     |
      | API testing          | Rest Assured |
    When a POST request is made to "/api/users"
    Then the response status code should be 201

  ##################################################################################################
  @pojo1
  Scenario: Send a request using pojo class
    Given the base URI is "https://gorest.co.in"
    And the request body attribute is
      """
      {
        "name": "chematiya11",
        "email": "sukar@gmail12.com",
        "gender": "female",
        "status": "Active"
      }
      """
    When a POST request is made to "/public/v2/users" using pojo class and object mapper
    Then the response status code should be 200

  ###################################################################################################33
  @pojo2
  Scenario Outline: Send a request using pojo class
    Given the base URI is "https://api.restful-api.dev"
    And the request body attribute for restful api
      """
      {
      "name": "<Apple>",
      "data": {
        "year": "<Year>",
        "price": "<Price>",
        "CPU model": "<Model>",
        "Hard disk size": "<size>"
      }
      }
      """
    When a POST request is made to "/objects" using object mapper restful api
    Then the response status code should be 200

    Examples: 
      | Apple                | Year | Price   | Model         | size |
      | Apple MacBook Pro 16 | 2019 | 1849.99 | Intel Core i9 | 1 TB |
      
      
      
      
      
