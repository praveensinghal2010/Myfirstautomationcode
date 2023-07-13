package StepDefinition;

import org.openqa.selenium.WebDriver;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import Hooks.hooks;
import Pages.HomePage1;
import Pages.Regexwithtablepage;

import org.testng.annotations.Test;


public class Regexwithtablesteps {
	

		
		private WebDriver _driver;
	    private Regexwithtablepage regex;
	    private hooks hooks1;
	    
	    
	    public Regexwithtablesteps() {
	    	
	        	hooks1= new hooks();
	            this._driver = hooks.getDriver();
	            regex=new Regexwithtablepage(_driver);
	        }
	
	@When("user click on arrow buttnon")
	public void user_click_on_arrow_buttnon() throws InterruptedException {
	    
		regex.clickonarrowbutton();
	}

	@Then("user is able to view the below table")
	public void user_is_able_to_view_the_below_table(io.cucumber.datatable.DataTable
	 dataTable) {
		
		//regex.WebtableParser(dataTable);
		
		regex.webtabledatacollection(dataTable);
	  
	}

	
	@When("user is not doing anything")
	public void user_is_not_doing_anything()
	{
	    
	}

	@Then("user validation below table")
	public void user_validation_below_table(io.cucumber.datatable.DataTable dataTable)
	
	{
		regex.checkingregularexpression(dataTable);  
	}

	

}
