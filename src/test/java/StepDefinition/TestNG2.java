package StepDefinition;


import org.openqa.selenium.WebDriver;

import Hooks.hooks;
import Pages.HomePage2;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class TestNG2 {

	
	private WebDriver _driver;
    private HomePage2 homePage;
    private hooks hooks1;
    
    
    public TestNG2() {
    	
        	hooks1= new hooks();
            this._driver = hooks.getDriver();
            homePage=new HomePage2(_driver);
        
        
    }


@When("user click on Material button")
public void user_click_on_material_button()throws InterruptedException {
	homePage.Clickonbutton();
}

@Then("user validate the below headers and values")
public void user_validate_the_below_headers_and_values(io.cucumber.datatable.DataTable dataTable) {
	//homePage.Validateheader(dataTable);
}
}