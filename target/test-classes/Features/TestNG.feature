@tag2
Feature: TestNG
  
  //A short summary of the feature

@Test @Sanity @Regression
  Scenario: Test multiselect option for the page
    Given user is on the home page
    When user click on select option
    Then user is able to select " Pizza "

  