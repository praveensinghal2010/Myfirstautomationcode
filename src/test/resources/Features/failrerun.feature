Feature: failrerun

  @Test @Sanity @Regression @rerun
  Scenario: Test multiselect option for the page
    Given user is on the home page
    When user is hello

  @Test @Sanity @Regression @rerun
  Scenario: Test hello option for the page
    Given user is on the home page
    When user is bello 

  @Exceldata
  Scenario: Read excel data
    Given user is reading the data from excel
