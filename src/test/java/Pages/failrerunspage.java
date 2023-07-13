package Pages;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import Helper.ExcelToDatatableHelper;


public class failrerunspage {

	private final WebDriver _driver;

	public failrerunspage(WebDriver driver) {
		this._driver = driver;
		PageFactory.initElements(_driver, this);
	}

	public void readexceldata(String filepath, String filename) throws IOException {
		
		try {
		
		ExcelToDatatableHelper varity = new ExcelToDatatableHelper();
		
		List<Map<String, String>> table = ExcelToDatatableHelper.readExcelData(filepath, filename);
		
		List<Map<String, String>> table2 = new ArrayList<>();
		

		List<WebElement> demo=_driver.findElements(By.className("hello")); 
		
		
		for(Map<String,String> abc : table)
		{
			Collection<String> values=abc.values();
			Collection<String> keys=abc.keySet();
			System.out.print(abc);
			System.out.print(table.get(0));
			String mlass=abc.get("Name");
			//String blass= abc.get(0).get(1);
		}
		
		System.out.println(table);
	}
		catch (IOException e) {
		    e.printStackTrace();
		    // Handle the exception as needed
		}
	}

}