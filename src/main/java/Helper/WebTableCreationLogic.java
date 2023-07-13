package Helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebTableCreationLogic {

    public static List<Map<String, String>> WebTabletoDatatable(WebElement tables)
    {
    	List<Map<String,String>>  webTable= new ArrayList<>();
    	List<WebElement> rows = tables.findElements(By.tagName("tr"));

		// Extract table headers
		WebElement headerRow = rows.get(0); // Assuming the first row contains the headers
		List<WebElement> headerColumns = headerRow.findElements(By.tagName("th"));
		List<String> headers = new ArrayList<>();

		for (WebElement headerColumn : headerColumns) {
		    String headerText = headerColumn.getText();
		    headers.add(headerText);
		}

		// Extract table rows
		for (int i = 1; i < rows.size(); i++) { // Start from index 1 to skip the header row
		    WebElement row = rows.get(i);
		    List<WebElement> columns = row.findElements(By.tagName("td"));
		    Map<String, String> rowData = new HashMap<>();

		    for (int j = 0; j < columns.size(); j++) {
		        String header = headers.get(j);
		        String value = columns.get(j).getText();
		        rowData.put(header, value);
		    }

		    webTable.add(rowData);
		}
		
		return webTable;
    	
    }
}
