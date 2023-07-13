package Helper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class TableComparator {
    public static boolean compareTables(List<Map<String, String>> table1, List<Map<String, String>> table2) {
        // Check if the number of rows is the same
        if (table1.size() != table2.size()) {
            return false;
        }

        // List to store mismatched values
        List<String> mismatchedValues = new ArrayList<>();

        // Iterate over the rows of table1
        for (int rowIndex = 0; rowIndex < table1.size(); rowIndex++) {
            Map<String, String> row1 = table1.get(rowIndex);
            Map<String, String> row2 = table2.get(rowIndex);

            // Check if the number of columns is the same
            if (row1.size() != row2.size()) {
                return false;
            }

            // Iterate over the columns of row1
            for (String columnName : row1.keySet()) {
                // Get the values from both tables
                String value1 = row1.get(columnName);
                String value2 = row2.get(columnName);

                // Check if value1 is a regular expression
                if (value1.startsWith("/") && value1.endsWith("/")) {
                    // Remove the regex delimiters
                    String regex = value1.substring(1, value1.length() - 1);

                    // Perform a regex match with value2
                    if (!Pattern.matches(regex, value2)) {
                        mismatchedValues.add(columnName + ": " + value1 + " != " + value2);
                    }
                } else {
                    // Compare the values normally
                    if (!value1.equals(value2)) {
                        mismatchedValues.add(columnName + ": " + value1 + " != " + value2);
                    }
                }
            }
        }

        // Print the mismatched values
        if (!mismatchedValues.isEmpty()) {
            System.out.println("Mismatched values:");
            for (String mismatchedValue : mismatchedValues) {
                System.out.println(mismatchedValue);
            }
        }

        // Return true if all rows and columns are the same
        return mismatchedValues.isEmpty();
    }
}

