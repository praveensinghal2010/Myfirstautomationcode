package Pages;



import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



import io.cucumber.datatable.DataTable;


public class HomePage2 {

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

	
	
	public HomePage2(WebDriver _driver2) {
		this._driver = _driver2;
		PageFactory.initElements(_driver, this);
	}

	public void Clickonbutton() throws InterruptedException {
		Thread.sleep(5000);
		Actions actions = new Actions(_driver);
		actions.moveToElement(material).click().perform();

	}
	
	/*
	 * public void Validateheader(DataTable table1) {
	 * convertCucumberDataTableToJavaDataTable1 variant = new
	 * convertCucumberDataTableToJavaDataTable1();
	 * 
	 * List<List<String>> cucumberData =
	 * variant.convertCucumberTableToJavaDataTable(table1);
	 * 
	 * List<List<String>> webelementtable = new ArrayList<>(); List<String>
	 * headerRow = new ArrayList<>(); headerRow.add(highQuality.getText());
	 * headerRow.add(versatile.getText()); webelementtable.add(headerRow);
	 * List<String> valueRow = new ArrayList<>();
	 * valueRow.add(highQualityValue.getText());
	 * valueRow.add(versatileValue.getText()); webelementtable.add(valueRow);
	 * 
	 * 
	 * // Compare the two tables row by row if (cucumberData.size() !=
	 * webelementtable.size()) { System.out.println("Tables are not equal."); }
	 * 
	 * for (int i = 0; i < cucumberData.size(); i++) { List<String> row1 =
	 * cucumberData.get(i); List<String> row2 = webelementtable.get(i);
	 * 
	 * if (!row1.equals(row2)) { Assert.assertEquals(row1, row2,
	 * "Tables are not equal."); break; } }
	 * 
	 * 
	 * }
	 */
    
    }