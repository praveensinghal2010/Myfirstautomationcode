package StepDefinition;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import Hooks.hooks;
import Pages.BSEINDIA2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class BSEINDIA {


		
		private WebDriver _driver;
	    private BSEINDIA2 bseindia;
	    private hooks hooks1;
	    
	    
	    public BSEINDIA() {
	    	
	        	hooks1= new hooks();
	            this._driver = hooks.getDriver();
	            bseindia=new BSEINDIA2(_driver);
	        }
	        
	    

	
	
	@Given("I am on the BSE India website")
	public void i_am_on_the_bse_india_website() {
	   
	}

	@Then("the navigation bar should contain the following options:")
	public void the_navigation_bar_should_contain_the_following_options(io.cucumber.
	datatable.DataTable dataTable) {
	   

		
		
		bseindia.validateNavigationOptions2(dataTable);
	}

	@Then("the system should contain the following Market summary:")
	public void the_system_should_contain_the_following_market_summary(io.cucumber.
	datatable.DataTable dataTable) 
	{
		bseindia.validateNavigationOptions3(dataTable);
	}
}

	

	


