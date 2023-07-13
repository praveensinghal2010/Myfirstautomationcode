package StepDefinition;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Hooks.hooks;
import Pages.failrerunspage;
import org.testng.annotations.Test;



public class failrerunsteps {

	
	private WebDriver _driver;
    private failrerunspage rerunpage;
    private hooks hooks1;
    
    
    public failrerunsteps() {
    	
        	hooks1= new hooks();
            this._driver = hooks.getDriver();
            rerunpage=new failrerunspage(_driver);
        }
        

	@When("user is hello")
	public void user_is_hello() {
     Assert.assertTrue(true);
	}

	@When("user is bello")
	public void user_is_bello() {
		Assert.assertTrue(false);
	}
	
	
	
	
	@Given("user is reading the data from excel")
	public void user_is_reading_the_data_from_excel() throws IOException {
		
		String filePath = "C:/Users/Dell/eclipse-workspace1/Classdata.xlsx";
        String sheetName = "Sheet1";
		
        try {
		rerunpage.readexceldata(filePath,sheetName);
	}catch (IOException e) {
	    e.printStackTrace();
	    // Handle the exception as needed
	}
	}
	
}
