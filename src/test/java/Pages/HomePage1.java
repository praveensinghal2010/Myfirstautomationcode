package Pages;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage1 {

	private final WebDriver _driver;

	@FindBy(xpath = "//*[text()=' Select ']")
	private WebElement selectElement;

	@FindBy(xpath = "//mat-select[@role='combobox']")
	private WebElement selectElement1;

	@FindBy(xpath = "//*[text()=' Checkbox ']")
	private WebElement checkbox;

	@FindBy(xpath = "//*[text()='Material']")
	private WebElement material;

	@FindBy(xpath = "//*[text()='High quality']")
	private WebElement highQuality;

	@FindBy(xpath = "//*[text()='Versatile']")
	private WebElement versatile;

	@FindBy(xpath = "//*[contains(text(),'accessible components for everyone')]")
	private WebElement highQualityValue;

	@FindBy(xpath = "//*[contains(text(),'build their own custom components')]")
	private WebElement versatileValue;

	@FindBy(xpath = "//*[text()=' Table ']")
	private WebElement table;

	@FindBy(css = "[role='table']")
	private WebElement tableElement;

	public HomePage1(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
	}

	public void GoToPage() throws InterruptedException {
		
	}

	public void ClickonSelect() throws InterruptedException {
		
		
		WebElement foo = new WebDriverWait(_driver, Duration.ofSeconds(3))
		        .until(ExpectedConditions.elementToBeClickable(selectElement1));

         foo.click();

	}

	@Test
	public void SelectValue(String pizza) throws InterruptedException {
		
		//WebElement element2 = _driver.findElement(By.xpath("//*[contains(text(),'Tree')]"));
		//element2.click();
		//WebElement element1 = _driver.findElement(By.xpath("//mat-tree-node[@role='treeitem']/button/span[3]"));
		//element1.click();
		
		Thread.sleep(3000);
		WebElement optionElement = _driver.findElement(By.xpath("//*[@id=\"mat-option-1\"]"));
		WebElement foo = new WebDriverWait(_driver, Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(optionElement));

		foo.click();
	}

	
    }
	
        


        

    
