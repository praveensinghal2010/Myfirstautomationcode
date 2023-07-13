
@tag
Feature: Test how to validate alert and new winow tab
  

  @alert @WithBrowser
  Scenario: Validate alert pop up accept and decline
    Given user is on the homepage url
    And user clicks on alret button
    When user accept the alert popup
    Then alert should be closed and user should be on homepage
     

  @NewTab @WithBrowser
  Scenario Outline: Validate new tab open for click button
    Given user is on the homepage url
    When user click on facebook button on homepage
    Then user should be move to new webpage "https://www.facebook.com/bseindia"
    And user should be able to back to base url "https://www.bseindia.com/"
    
    
    
    @Frameswitch @WithBrowser
  Scenario Outline: Validate frames in a webpage
    Given user is on the homepage url
    When user click on a element of inner frame
    Then user should able to access inner frame element
    
    
    
     @scrollelement @WithBrowser
  Scenario Outline: Validate select a element using scrolling
    Given user is on the homepage url
    When user scrolls to the element and click on the link
    Then user should able to move the request url
    
    
       @uploadfile  @WithBrowser
  Scenario Outline: Upload a file on webpage
    Given user is on the homepage url
    When user upload a file in the input box and click on upload button
    Then user should able to upload the file
    
    

    
