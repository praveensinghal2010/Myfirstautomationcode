package Pages;
import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;


public class AlertNewTabPage {

	
	private final WebDriver _driver;
	
	
	@FindBy(xpath = "//button[@name='alertbox']")
	private WebElement alertbox;

	@FindBy(xpath = "//a[@aria-label='Facebook']")
	private WebElement Facebook;
	
	@FindBy(linkText= ("Get Quote"))
	private WebElement GetQuote;
	
	@FindBy(id= ("file-upload"))
	private WebElement fileupload;
	
	@FindBy(id= ("file-submit"))
	private WebElement filesubmit;
	
	
	
	public AlertNewTabPage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
	}
	
	
	public void clickonalertbutton()
	{
		alertbox.click();
	}
	
	
	public void acceptalertpopup()
	{
		Alert alert = _driver.switchTo().alert();
		alert.accept();
	}
	
//######################################################################################################33
	
	public void clickonfacebookbutton()
	{
	//_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));	
		WebDriverWait wait = new WebDriverWait(_driver,Duration.ofSeconds(3));
		wait.until(ExpectedConditions.elementToBeClickable(Facebook));
		Facebook.click();
		
	}
	
	public void validatenewtaburl(String url)
	{
		 Set<String> windowHandles = _driver.getWindowHandles();
		 for (String handle : windowHandles) {
	            _driver.switchTo().window(handle);
	            if (_driver.getCurrentUrl().equals(url)) {
	                System.out.println("New Tab - Title: " + _driver.getTitle());
	                break;
	            }
	        }
		//Assert.assertEquals(url,_driver.getTitle());
	}
	
	
	public void validateoldtaburl(String oldurl)
	{
		Set<String> windowHandles = _driver.getWindowHandles();
		//_driver.switchTo().defaultContent();
		 for (String handle : windowHandles) {
	            _driver.switchTo().window(handle);
	            if (_driver.getCurrentUrl().equals(oldurl)) {
	                System.out.println("old Tab - Title: " + _driver.getTitle());
	                break;
	            }
	        }
	}
//######################################################################################################3
	
	public void clickoninnerframe()
	{
		WebElement frame= _driver.findElement(By.xpath("//iframe[@name='packageFrame']"));
		_driver.switchTo().frame(frame);
		
	}
	
	
	public void clickoninnerframeelement()
	{
		_driver.findElement(By.linkText("AbstractAnnotations")).click();
		
		_driver.switchTo().defaultContent();
		
		
	}
//#############################################################################################################################3
	
	public void scrolltofindtheelement()
	{
	
		JavascriptExecutor js = (JavascriptExecutor) _driver;
        js.executeScript("arguments[0].scrollIntoView(true);", GetQuote);
        Actions actions = new Actions(_driver);
        
        WebDriverWait wait = new WebDriverWait(_driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(GetQuote));
        
        
        actions.moveToElement(GetQuote).click().perform();
	}
	
//##################################################################################################################################33
	
	
	public void uploadfile() throws InterruptedException
	{
		fileupload.sendKeys("C:/Users/Classdata.xlsx");
		filesubmit.click();
		
		Thread.sleep(7000);
	}
	
	
}
