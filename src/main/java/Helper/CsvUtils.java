package Helper;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.LinkedHashMap;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.*;

public class CsvUtils {
    public static Map<String, String> readCsvToMap(Path csvFilePath) throws IOException {
        Map<String, String> csvMap = new LinkedHashMap<>();

        try (BufferedReader reader = Files.newBufferedReader(csvFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    String key = parts[0].trim();
                    String value = parts[1].trim();
                    csvMap.put(key, value);
                }
            }
        }

        return csvMap;
    }
    
    
    
    
}

