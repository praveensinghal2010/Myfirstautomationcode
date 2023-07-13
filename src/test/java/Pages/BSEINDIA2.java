package Pages;
import static org.testng.Assert.fail;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.datatable.DataTable;


public class BSEINDIA2 {
	
	private final WebDriver _driver;
	
	
	
	
	
	
	public BSEINDIA2(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
	}
	
	
	
	public void validateNavigationOptions2(io.cucumber.
    		datatable.DataTable dataTable) {
		
		int lastMatchedIndex=0;
    	
        List<Map<String, String>> javaDataTable = dataTable.asMaps(String.class, String.class);
       // List<List<String>> javaDataTable3 = dataTable.asLists(String.class);
		
        WebElement navigationBar = _driver.findElement(By.id("main_nav"));
        List<WebElement> navigationOptions = navigationBar.findElements(By.cssSelector(".nav-item > .nav-link"));

        for (Map<String,String> row : javaDataTable) {
            String expectedOption = row.get("options");
            Map<String, String> firstRow = javaDataTable.get(0);

            boolean found = false;
            for (int i = lastMatchedIndex; i < navigationOptions.size(); i++) {
                WebElement option = navigationOptions.get(i);
                String actualOption = option.getText().trim();
                if (actualOption.equals(expectedOption)) {
                    found = true;
                    lastMatchedIndex = i + 1; // Update the index to start from the next value
                    break; // Exit the inner loop if a match is found
                }
                else
                {
                	Assert.assertEquals(actualOption, expectedOption);
                }
            }

            
        }
	

	}
	
	public void validateNavigationOptions3(io.cucumber.
    		datatable.DataTable dataTable)
	{
	
		List<List<String>> javaDataTable = dataTable.asLists(String.class);
		 List<String> rowData = new ArrayList<>();
		 WebElement tableElement = _driver.findElement(By.cssSelector("#mktsumm > table"));
 		
	        List<List<String>> webTable = new ArrayList<>();
	        List<WebElement> rows = tableElement.findElements(By.tagName("tr"));
	        for (WebElement row : rows) {
	            
	        	 List<WebElement> cells = row.findElements(By.tagName("td"));
	        	
	           

	          
	            for (WebElement cell : cells) {
	                
	                rowData.add(cell.getText());
	            }

	            webTable.add(rowData);
	        }

	        Assert.assertEquals(webTable, javaDataTable);
		
	} 
	
	
	
}


	








	


	
