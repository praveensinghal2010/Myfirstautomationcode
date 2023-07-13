Feature: Object API Testing

  @pojo1
  Scenario: Send a request using pojo class
    Given the base URI is "https://gorest.co.in"
    And the request body is
      """
      {
            "name": "chematiya11",
            "email": "sukar@gmail12.com",
            "gender": "female",
            "status": "Active"
        }
        
        """    
    When a POST request is made to "/public/v2/users"
    Then the response status code should be 200
  
