package Helper;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;

public class ExcelToDatatableHelper {
    public static List<Map<String, String>> readExcelData(String filePath, String sheetName) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sheet = workbook.getSheet(sheetName);

        List<Map<String, String>> excelData = new ArrayList<>();

        Row headerRow = sheet.getRow(0);
        int columnCount = headerRow.getLastCellNum();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Map<String, String> rowData = new LinkedHashMap<>();

            for (int j = 0; j < columnCount; j++) {
                Cell cell = row.getCell(j);
                String header = headerRow.getCell(j).toString();
                String value = (cell != null) ? cell.toString() : "";
                rowData.put(header, value);
            }

            excelData.add(rowData);
        }

        workbook.close();
        fileInputStream.close();

        return excelData;
    }
}
