package Helper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebTableParser {
	public static List<Map<String, String>> parseTable(String tableHtml) {
        List<Map<String, String>> table = new ArrayList<>();

        Document document = Jsoup.parse(tableHtml);
        Element tableElement = document.select("table").first();
        Elements rows = tableElement.select("tr");

        // Get table headers
        Element headerRow = rows.first();
        Elements headerColumns = headerRow.select("th");
        List<String> headers = new ArrayList<>();
        for (Element headerColumn : headerColumns) {
            headers.add(headerColumn.text());
        }

        // Get table data
        for (int i = 1; i < rows.size(); i++) {
            Element row = rows.get(i);
            Elements columns = row.select("td");

            if (columns.size() == headers.size()) {
                Map<String, String> rowData = new HashMap<>();
                for (int j = 0; j < columns.size(); j++) {
                    rowData.put(headers.get(j), columns.get(j).text());
                }
                table.add(rowData);
            }
        }

        return table;
    }

}

