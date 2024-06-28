package Utility;

import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

/**
 * @author Gopi Appapuram
 * <p>
 * Utility class to perform operations on Excel files.
 */
public class ExcelUtility {

    private WebDriver driver;
    private Workbook workbook;
    private Sheet sheet;
    private String filePath;

    /**
     * Constructor to initialize ExcelUtility with the file path to an Excel file.
     *
     * @param filePath The file path of the Excel file.
     */
    public ExcelUtility(String filePath) {
        this.filePath = filePath;
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            this.workbook = WorkbookFactory.create(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Set the Excel sheet by name.
     *
     * @param sheetName The name of the sheet to set.
     */
    public void setSheet(String sheetName) {
        this.sheet = workbook.getSheet(sheetName);
        if (this.sheet == null) {
            throw new IllegalArgumentException("Sheet '" + sheetName + "' not found in the Excel file.");
        }
    }

    /**
     * Set the Excel sheet by index.
     *
     * @param sheetIndex The index of the sheet to set.
     */
    public void setSheet(int sheetIndex) {
        this.sheet = workbook.getSheetAt(sheetIndex);
        if (this.sheet == null) {
            throw new IllegalArgumentException("Sheet at index " + sheetIndex + " not found in the Excel file.");
        }
    }

    /**
     * Get the total number of rows in the current Excel sheet.
     *
     * @return The total number of rows in the sheet.
     */
    public int rowCount() {
        return sheet.getLastRowNum();
    }

    /**
     * Read data from a specific cell in the Excel sheet.
     *
     * @param rowNum The row number of the cell.
     * @param colNum The column number of the cell.
     * @return The data in the specified cell as a String.
     */
    public String readData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            return "";
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            return "";
        }
        return cell.toString();
    }

    /**
     * Write data to a specific cell in the Excel sheet.
     *
     * @param rowNum The row number of the cell.
     * @param colNum The column number of the cell.
     * @param data   The data to write to the cell.
     */
    public void writeDataOnSefColRow(int rowNum, int colNum, String data) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellValue(data);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Write data to multiple cells in the Excel sheet with specified cell styling.
     *
     * @param startCol  The starting column index for writing data.
     * @param data      The array of data to write to the cells.
     * @param colorName The name of the color to apply to the cell background.
     */
    public void writeData(int startCol, String[] data, String colorName) {
        int rowNum = findNextEmptyRow();

        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }

        for (int i = 0; i < data.length; i++) {
            Cell cell = row.getCell(startCol + i);
            if (cell == null) {
                cell = row.createCell(startCol + i);
            }
            cell.setCellValue(data[i]);

            CellStyle style = workbook.createCellStyle();
            style.setWrapText(true);
            style.setVerticalAlignment(VerticalAlignment.TOP);
            style.setAlignment(HorizontalAlignment.LEFT);
            style.setBorderTop(BorderStyle.MEDIUM);
            style.setBorderBottom(BorderStyle.MEDIUM);
            style.setBorderLeft(BorderStyle.MEDIUM);
            style.setBorderRight(BorderStyle.MEDIUM);
            style.setFillForegroundColor(IndexedColors.WHITE1.getIndex());

            try {
                IndexedColors indexedColor = IndexedColors.valueOf(colorName.toUpperCase());
                short colorIndex = indexedColor.getIndex();
                style.setFillForegroundColor(colorIndex);
                style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
            } catch (IllegalArgumentException e) {
                System.out.println("Color name not found: " + colorName);
            }

            cell.setCellStyle(style);
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            workbook.write(fileOutputStream);
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Find the next empty row in the Excel sheet.
     *
     * @return The index of the next empty row.
     */
    private int findNextEmptyRow() {
        int rowNum = 0;
        while (sheet.getRow(rowNum) != null) {
            rowNum++;
        }
        return rowNum;
    }

    /**
     * Close the Excel workbook.
     */
    public void close() {
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Read data from all cells in the Excel sheet.
     *
     * @return A map of row numbers to a list of cell data as strings.
     */
    public Map<Integer, List<String>> readAllData() {
        Map<Integer, List<String>> dataMap = new HashMap<>();
        int rows = sheet.getPhysicalNumberOfRows();
        for (int rowNum = 0; rowNum < rows; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                List<String> rowData = new ArrayList<>();
                int cells = row.getPhysicalNumberOfCells();
                for (int colNum = 0; colNum < cells; colNum++) {
                    Cell cell = row.getCell(colNum);
                    String cellValue = (cell == null) ? "" : cell.toString();
                    rowData.add(cellValue);
                }
                dataMap.put(rowNum, rowData);
            }
        }
        return dataMap;
    }


    /**
     * Read data from the Excel sheet and return as a LinkedHashMap.
     *
     * @return A LinkedHashMap where keys are headers and values are lists of row data.
     */
    public LinkedHashMap<String, List<String>> readDataAsLinkedHashMap() {
        LinkedHashMap<String, List<String>> dataMap = new LinkedHashMap<>();
        int rows = sheet.getPhysicalNumberOfRows();

        // Read headers from the first row
        Row headerRow = sheet.getRow(0);
        List<String> headers = new ArrayList<>();
        for (Cell cell : headerRow) {
            headers.add(cell.getStringCellValue());
        }

        // Initialize dataMap with empty lists for each header
        for (String header : headers) {
            dataMap.put(header, new ArrayList<>());
        }

        // Read data for each row starting from the second row
        for (int rowNum = 1; rowNum < rows; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                for (int colNum = 0; colNum < headers.size(); colNum++) {
                    Cell cell = row.getCell(colNum);
                    String cellValue = (cell == null) ? "" : cell.toString();
                    String header = headers.get(colNum);
                    dataMap.get(header).add(cellValue);
                }
            }
        }

        return dataMap;
    }

    /**
     * Read data from the Excel sheet and return as a list of LinkedHashMaps,
     * where each LinkedHashMap represents a row with headers as keys and row data as values.
     *
     * @return A list of LinkedHashMaps where keys are headers and values are row data.
     */
    public List<LinkedHashMap<String, String>> readDataAsListOfMaps() {
        List<LinkedHashMap<String, String>> dataList = new ArrayList<>();
        int rows = sheet.getPhysicalNumberOfRows();

        // Read headers from the first row
        Row headerRow = sheet.getRow(0);
        List<String> headers = new ArrayList<>();
        for (Cell cell : headerRow) {
            headers.add(cell.getStringCellValue());
        }

        // Read data for each row starting from the second row
        for (int rowNum = 1; rowNum < rows; rowNum++) {
            Row row = sheet.getRow(rowNum);
            if (row != null) {
                LinkedHashMap<String, String> rowData = new LinkedHashMap<>();
                for (int colNum = 0; colNum < headers.size(); colNum++) {
                    Cell cell = row.getCell(colNum);
                    String cellValue = (cell == null) ? "" : cell.toString();
                    String header = headers.get(colNum);
                    rowData.put(header, cellValue);
                }
                dataList.add(rowData);
            }
        }

        return dataList;
    }

    @Test
    public void test() {
        ExcelUtility excelUtility = new ExcelUtility("D:\\ESoft_Solutions\\AutomationPractice\\BDD_Framework\\Myntra.xlsx");
        excelUtility.setSheet(1);
        List<LinkedHashMap<String, String>> dataMap = excelUtility.readDataAsListOfMaps();
        for (int i = 0; i < dataMap.size(); i++) {

            System.out.println(dataMap.get(i));
        }
//        // Print dataMap
//        for (Map.Entry<String, List<String>> entry : dataMap.entrySet()) {
//            String header = entry.getKey();
//            List<String> values = entry.getValue();
//
//            System.out.println();
//        }

        excelUtility.close();

    }
}
