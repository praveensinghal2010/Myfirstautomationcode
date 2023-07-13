@tag2
Feature: TestNG2
  
  //A short summary of the feature

 @Test @Sanity @demo
  Scenario: Test Label and its value.
    Given user is on the home page
    When user click on Material button
    Then user validate the below headers and values
      | High quality                                                                                                 | Versatile                                                                                              |
      | Internationalized and accessible components for everyone. Well tested to ensure performance and reliability. | Provide tools that help developers build their own custom components with common interaction patterns. |
