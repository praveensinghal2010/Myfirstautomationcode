package Pages;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import Helper.WebTableParser;
import Helper.TableComparator;
import Helper.WebTableCreationLogic;
import java.util.LinkedHashMap;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



import io.cucumber.datatable.DataTable;

public class Regexwithtablepage {
	
	private final WebDriver _driver;
	
	@FindBy(css = "#main_nav > ul > li:nth-child(6) > a")
	private WebElement arrowbutton;
	
	public Regexwithtablepage(WebDriver _driver2) {
		this._driver = _driver2;
		PageFactory.initElements(_driver, this);
	}
	
	public void clickonarrowbutton() throws InterruptedException
	{
		WebElement foo = new WebDriverWait(_driver, Duration.ofSeconds(3))
		        .until(ExpectedConditions.elementToBeClickable(arrowbutton));
		
		Thread.sleep(5000);
		arrowbutton.click();
		
	}

	
	public void WebtableParser(DataTable table1)
	{
		
		List<Map<String, String>> javaDataTable = table1.asMaps(String.class, String.class);
		
		WebTableParser parser= new WebTableParser();
		
		String htmlbody="<table cellspacing=\"1\" cellpadding=\"4\" id=\"ContentPlaceHolder1_grvArchive\" style=\"width:100%;\">\r\n"
				+ "		<tbody><tr>\r\n"
				+ "			<th class=\"TTHeader\" scope=\"col\" style=\"font-weight:bold;\">Type of Instrument</th><th class=\"TTHeader\" scope=\"col\" style=\"font-weight:bold;\">Contracts Traded</th><th class=\"TTHeader\" scope=\"col\" style=\"font-weight:bold;\">No. of Trades</th><th class=\"TTHeader\" align=\"center\" scope=\"col\" style=\"font-weight:bold;\">Turnover (<img src=\"../../../include/images/rs.gif\" alt=\"my image\"> Cr)</th><th class=\"TTHeader\" align=\"center\" scope=\"col\" style=\"font-weight:bold;\">Mkt OI (No. Of Contracts)*</th>\r\n"
				+ "		</tr><tr>\r\n"
				+ "			<td class=\"TTRow_left\">Index Future</td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_lblissue_date_0\">962</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label1_0\">775</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label2_0\">60.67</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label4_0\">99</span>\r\n"
				+ "                                                </td>\r\n"
				+ "		</tr><tr>\r\n"
				+ "			<td class=\"TTRow_left\">Index Option (Call)</td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_lblissue_date_1\">46,84,310</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label1_1\">11,05,716</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label2_1\">2,96,533.00</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label4_1\">1,45,430</span>\r\n"
				+ "                                                </td>\r\n"
				+ "		</tr><tr>\r\n"
				+ "			<td class=\"TTRow_left\">Equity Option (Call)</td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_lblissue_date_2\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label1_2\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label2_2\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label4_2\">18,49,473</span>\r\n"
				+ "                                                </td>\r\n"
				+ "		</tr><tr>\r\n"
				+ "			<td class=\"TTRow_left\">Index Option (Put)</td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_lblissue_date_3\">49,26,393</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label1_3\">11,13,373</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label2_3\">3,10,043.15</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label4_3\">1,57,702</span>\r\n"
				+ "                                                </td>\r\n"
				+ "		</tr><tr>\r\n"
				+ "			<td class=\"TTRow_left\">Equity Future</td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_lblissue_date_4\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label1_4\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label2_4\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label4_4\">34,34,398</span>\r\n"
				+ "                                                </td>\r\n"
				+ "		</tr><tr>\r\n"
				+ "			<td class=\"TTRow_left\">Equity Option (Put)</td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_lblissue_date_5\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label1_5\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label2_5\">-</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label4_5\">10,94,371</span>\r\n"
				+ "                                                </td>\r\n"
				+ "		</tr><tr style=\"font-weight:bold;\">\r\n"
				+ "			<td class=\"TTRow_left\">Total</td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_lblissue_date_6\">96,11,665</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label1_6\">22,19,864</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label2_6\">6,06,636.81</span>\r\n"
				+ "                                                </td><td class=\"TTRow_right\" align=\"right\">\r\n"
				+ "                                                    <span id=\"ContentPlaceHolder1_grvArchive_Label4_6\">66,81,473</span>\r\n"
				+ "                                                </td>\r\n"
				+ "		</tr>\r\n"
				+ "	</tbody></table>";
		
		List<Map<String, String>> WebTable = parser.parseTable(htmlbody);
		WebElement tables= _driver.findElement(By.id("ContentPlaceHolder1_grvArchive"));
		
		
		

        
    }
	
	
	public void webtabledatacollection(DataTable table1)
	{
		List<Map<String, String>> javaDataTable = table1.asMaps(String.class, String.class);
		List<Map<String,String>>  webTable= new ArrayList<>();
		
		WebTableCreationLogic newtable = new WebTableCreationLogic();
		
		WebElement tables= _driver.findElement(By.cssSelector("#fontSize > div.container-fluid.marketstartarea > div > div:nth-child(3) > div.whitebox > div.largetable.mannn > table"));
		
		webTable= newtable.WebTabletoDatatable(tables);
		
		String abc= "hello";
		
	
	
	}
	
	
	public void checkingregularexpression(DataTable table2)
	{
		List<Map<String, String>> javaDataTable = table2.asMaps(String.class, String.class);
		


List<Map<String, String>> anothertable = new ArrayList<>();

Map<String, String> map1 = new LinkedHashMap<>();
map1.put("Key", "normal expression");
map1.put("Value", "As in 10/20/2023");


anothertable.add(map1);

Map<String, String> map2 = new LinkedHashMap<>();
map2.put("Key", "hello darling");
map2.put("Value", "maneshar hu main");


anothertable.add(map2);

boolean value=TableComparator.compareTables(javaDataTable, anothertable);


       
        
        

	}
	
}
