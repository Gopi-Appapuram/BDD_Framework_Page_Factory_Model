package Utility;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Utility class to perform operations on CSV files.
 */
public class CSVUtility {

    private String filePath;
    private String delimiter; // CSV delimiter (e.g., "," or ";")

    /**
     * Constructor to initialize CSVUtility with the file path and delimiter.
     *
     * @param filePath  The file path of the CSV file.
     * @param delimiter The delimiter used in the CSV file.
     */
    public CSVUtility(String filePath, String delimiter) {
        this.filePath = filePath;
        this.delimiter = delimiter;
    }

    /**
     * Read data from the CSV file and return as a list of rows.
     *
     * @return A list where each element is a list of strings representing the data in each row.
     */
    public List<List<String>> readData() {
        List<List<String>> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(delimiter);
                List<String> row = new ArrayList<>();
                for (String value : values) {
                    row.add(value);
                }
                data.add(row);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }

    /**
     * Write data to the CSV file.
     *
     * @param data A list where each element is a list of strings representing a row of data.
     */
    public void writeData(List<List<String>> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (List<String> row : data) {
                StringBuilder line = new StringBuilder();
                for (int i = 0; i < row.size(); i++) {
                    if (i > 0) {
                        line.append(delimiter);
                    }
                    line.append(row.get(i));
                }
                bw.write(line.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read data from the CSV file and return as a LinkedHashMap with headers as keys and lists of values as values.
     *
     * @return A LinkedHashMap where keys are headers and values are lists of row data.
     */
    public LinkedHashMap<String, List<String>> readDataAsLinkedHashMap() {
        LinkedHashMap<String, List<String>> dataMap = new LinkedHashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] headers = headerLine.split(delimiter);
                for (String header : headers) {
                    dataMap.put(header, new ArrayList<>());
                }

                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(delimiter);
                    for (int i = 0; i < values.length && i < headers.length; i++) {
                        dataMap.get(headers[i]).add(values[i]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataMap;
    }

    /**
     * Read data from the CSV file and return as a list of LinkedHashMaps,
     * where each LinkedHashMap represents a row with headers as keys and row data as values.
     *
     * @return A list of LinkedHashMaps where keys are headers and values are row data.
     */
    public List<LinkedHashMap<String, String>> readDataAsListOfMaps() {
        List<LinkedHashMap<String, String>> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String headerLine = br.readLine();
            if (headerLine != null) {
                String[] headers = headerLine.split(delimiter);

                String line;
                while ((line = br.readLine()) != null) {
                    String[] values = line.split(delimiter);
                    LinkedHashMap<String, String> rowMap = new LinkedHashMap<>();
                    for (int i = 0; i < values.length && i < headers.length; i++) {
                        rowMap.put(headers[i], values[i]);
                    }
                    dataList.add(rowMap);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }

    // Other methods as needed: findNextEmptyRow, rowCount, etc.
}

