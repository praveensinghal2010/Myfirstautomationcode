package StepDefinition;

import java.util.Map;

import org.openqa.selenium.WebDriver;
import io.cucumber.datatable.DataTable;
import Hooks.hooks;
import Pages.AlertNewTabPage;
import Pages.BSEINDIA2;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AlertNewTabSteps {


		
		private WebDriver _driver;
	   
	    private hooks hooks1;
	    private AlertNewTabPage alertNewTabPage;
	    
	    
	    public AlertNewTabSteps() {
	    	
        	hooks1= new hooks();
            this._driver = hooks.getDriver();
            alertNewTabPage=new AlertNewTabPage(_driver);
        }
	
	
	@Given("user is on the homepage url")
	public void user_is_on_the_homepage_url() {
	    
	}

	@Given("user clicks on alret button")
	public void user_clicks_on_alret_button() {
		
		alertNewTabPage.clickonalertbutton();
	 
	}

	@When("user accept the alert popup")
	public void user_accept_the_alert_popup() {
		
		alertNewTabPage.acceptalertpopup();
	 
	}

	@Then("alert should be closed and user should be on homepage")
	public void alert_should_be_closed_and_user_should_be_on_homepage() {
	
	}

//#####################################################################################################

	@When("user click on facebook button on homepage")
	public void user_click_on_facebook_button_on_homepage() {
	    
		alertNewTabPage.clickonfacebookbutton();
	}

	@Then("user should be move to new webpage {string}")
	public void user_should_be_move_to_new_webpage(String newtaburl) {
	    
		alertNewTabPage.validatenewtaburl(newtaburl);
	}

	@Then("user should be able to back to base url {string}")
	public void user_should_be_able_to_back_to_base_url(String oldurl) {
		
		alertNewTabPage.validateoldtaburl(oldurl);
	    
	}

//####################################################################################################
	
	
	@When("user click on a element of inner frame")
	public void user_click_on_a_element_of_inner_frame() {
		alertNewTabPage.clickoninnerframe();
	}

	@Then("user should able to access inner frame element")
	public void user_should_able_to_access_inner_frame_element() {
		alertNewTabPage.clickoninnerframeelement();
	    
	}

//######################################################################################################
	
	@When("user scrolls to the element and click on the link")
	public void user_scrolls_to_the_element_and_click_on_the_link() {
		alertNewTabPage.scrolltofindtheelement();
	}

	@Then("user should able to move the request url")
	public void user_should_able_to_move_the_request_url() {
	   
	}

//##############################################################################################################3
	
	
	@When("user upload a file in the input box and click on upload button")
	public void user_upload_a_file_in_the_input_box_and_click_on_upload_button() throws InterruptedException {
		alertNewTabPage.uploadfile();
	}

	@Then("user should able to upload the file")
	public void user_should_able_to_upload_the_file() {
	  
	}
//################################################################################################################3


}
