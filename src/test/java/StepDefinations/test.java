package StepDefinations;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import Utility.ScrollUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class test {

    public static void main(String[] args) throws InterruptedException {

       /* By WEATHERFORECAST_Element = By.xpath("//h2[@class='daily-list-header']");
        By temparatures_list = By.xpath("//span[@class='temp-hi']");


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.accuweather.com/en/in/chennai/206671/weather-forecast/206671");
        Thread.sleep(5000);
        Actions actions = new Actions(driver);
        WebElement temparatureList = driver.findElement(WEATHERFORECAST_Element);
        actions.moveToElement(temparatureList).build().perform();
        List<WebElement> temparatures_list_data = driver.findElements(temparatures_list);
        List<String> temparatures_values = new ArrayList<>();

        for (WebElement temparature : temparatures_list_data) {
            temparatures_values.add(temparature.getText());
        }

        List<Integer> temparatures_Int_values = new ArrayList<>();
        for (String highestVlues : temparatures_values) {
            String filteredData = highestVlues.replace("°", "");
            temparatures_Int_values.add(Integer.parseInt(filteredData));
        }

        int HighestValue = 0;
        for(int value : temparatures_Int_values){
            if(value > HighestValue){
                value += HighestValue;
            }

        }
        System.out.println("Highest Value is: " + HighestValue);*/

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://datatables.net/extensions/buttons/examples/initialisation/export.html");
        //LinkedHashMap<String, List<String>> Data = extractTableData(driver);
        //System.out.println(Data);
        //driver.close();
    }


    /**
     * Extracts data from an HTML table and returns it as a LinkedHashMap.
     * Each key in the map represents a table header, and the corresponding value
     * is a list of strings representing the data in each column under that header.
     *
     * @param driver   The WebDriver instance controlling the browser session.
     * @param headerLocator Locator for table headers (e.g., By.tagName("th")).
     * @param rowLocator Locator for table rows (e.g., By.tagName("tr")).
     * @param cellLocator Locator for table cells (e.g., By.tagName("td")).
     * @return A LinkedHashMap where keys are table headers and values are lists of table cell data.
     * @throws InterruptedException If the WebDriver operations are interrupted.
     */
    public static LinkedHashMap<String, List<String>> extractTableData(WebDriver driver,
                                                                       By headerLocator,
                                                                       By rowLocator,
                                                                       By cellLocator) throws InterruptedException {
        // Initialize a LinkedHashMap to store the table data with headers as keys and lists of cell data as values
        LinkedHashMap<String, List<String>> tableData = new LinkedHashMap<>();

        // Find all the table header elements using the provided locator
        List<WebElement> headers = driver.findElements(headerLocator);
        List<String> headerList = new ArrayList<>();

        // Iterate through the header elements to extract their text
        for (int i = 0; i < headers.size(); i++) {
            headerList.add(headers.get(i).getText());
        }

        // Initialize tableData with empty lists for each header
        for (String header : headerList) {
            tableData.put(header, new ArrayList<>());
        }

        // Find all table rows using the provided locator
        List<WebElement> rows = driver.findElements(rowLocator);

        // Iterate through each row (starting from 1 to skip header row)
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(cellLocator);

            // Iterate through each cell in the row
            for (int j = 0; j < cells.size(); j++) {
                String cellText = cells.get(j).getText(); // Extract text from the cell
                String header = headerList.get(j); // Get the corresponding header for this cell
                tableData.get(header).add(cellText); // Add cell text to the corresponding header's list
            }
        }

        // Return the populated tableData LinkedHashMap
        return tableData;
    }

    /**
     * Extracts data from an HTML table and returns it as a list of LinkedHashMaps.
     * Each LinkedHashMap represents a table row with headers as keys and row data as values.
     *
     * @param driver       The WebDriver instance controlling the browser session.
     * @param headerLocator Locator for table headers (e.g., By.tagName("th")).
     * @param rowLocator    Locator for table rows (e.g., By.tagName("tr")).
     * @param cellLocator   Locator for table cells (e.g., By.tagName("td")).
     * @return A list of LinkedHashMaps where keys are table headers and values are table cell data.
     * @throws InterruptedException If the WebDriver operations are interrupted.
     */
    public static List<LinkedHashMap<String, String>> extractTableDataList(WebDriver driver,
                                                                       By headerLocator,
                                                                       By rowLocator,
                                                                       By cellLocator) throws InterruptedException {
        List<LinkedHashMap<String, String>> tableDataList = new ArrayList<>();

        // Find all the table rows using the provided locator
        List<WebElement> rows = driver.findElements(rowLocator);

        // Find all the table headers using the provided locator
        List<WebElement> headers = driver.findElements(headerLocator);
        List<String> headerList = new ArrayList<>();

        // Iterate through the headers to extract their text
        for (int i = 0; i < headers.size(); i++) {
            headerList.add(headers.get(i).getText());
        }

        // Iterate through each row (starting from 1 to skip header row)
        for (int i = 1; i < rows.size(); i++) {
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(cellLocator);

            LinkedHashMap<String, String> rowData = new LinkedHashMap<>();

            // Iterate through each cell in the row
            for (int j = 0; j < cells.size(); j++) {
                String cellText = cells.get(j).getText(); // Extract text from the cell
                String header = headerList.get(j); // Get the corresponding header for this cell
                rowData.put(header, cellText); // Add cell text to the corresponding header in rowData
            }

            // Add the rowData LinkedHashMap to the tableDataList
            tableDataList.add(rowData);
        }

        return tableDataList;
    }


}
