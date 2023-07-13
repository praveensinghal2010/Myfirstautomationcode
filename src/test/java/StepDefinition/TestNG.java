package StepDefinition;

import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Hooks.hooks;
import Pages.HomePage1;
import org.testng.annotations.Test;



public class TestNG {

	
	private WebDriver _driver;
    private HomePage1 homePage;
    private hooks hooks1;
    
    
    public TestNG() {
    	
        	hooks1= new hooks();
            this._driver = hooks.getDriver();
            homePage=new HomePage1(_driver);
        }
        
    

@Test
@Given("user is on the home page")
public void user_is_on_the_home_page() throws InterruptedException{
	// Write code here that turns the phrase above into concrete actions
			homePage = new HomePage1(_driver); 
			homePage.GoToPage();
			
}

@When("user click on select option")
public void user_click_on_select_option()throws InterruptedException {
	// Write code here that turns the phrase above into concrete actions
			homePage.ClickonSelect();
}

@Then("user is able to select {string}")
public void user_is_able_to_select(String pizza)throws InterruptedException {
	// Write code here that turns the phrase above into concrete actions
			homePage.SelectValue(pizza);
}

}
