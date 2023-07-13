package Hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import ConfigProperties.Configuration;



public class hooks {

	private static WebDriver driver;

	@Before("@WithBrowser")
	public void setUp(Scenario scenario) throws InterruptedException {
		System.out.println("Before scenario: " + scenario.getName());
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://material.angular.io/components/select/overview");
		//driver.get("https://www.bseindia.com/");
		//driver.get("https://nxtgenaiacademy.com/alertandpopup/");
		//driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		driver.get("https://the-internet.herokuapp.com/upload");
		//driver.get(Configuration.getProperty("url"));
		
		
		
		

		if (isElementPresent(driver, By.xpath("//*[contains(text(),'Ok, Got it')]")))

		{
			driver.findElement(By.xpath("//*[contains(text(),'Ok, Got it')]")).click();

		}
	}

	private static boolean isElementPresent(WebDriver driver, By locator) {
		return driver.findElements(locator).size() > 0;

	}

	@After
	public void tearDown(Scenario scenario) {
		System.out.println("After scenario: " + scenario.getName());
		// Close the browser
		if (scenario.isFailed()) {
			// Take a screenshot
			byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "Screenshot");
		}
		if (driver != null) {
            driver.quit();
        }
		
	}

	public static WebDriver getDriver() {
		return driver;
	}
}
