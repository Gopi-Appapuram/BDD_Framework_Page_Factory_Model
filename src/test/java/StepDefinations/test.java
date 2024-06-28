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
        LinkedHashMap<String, List<String>> Data = extractTableData(driver);
        System.out.println(Data);
        //driver.close();
    }


    public static LinkedHashMap<String, List<String>> extractTableData(WebDriver driver) throws InterruptedException {
        LinkedHashMap<String, List<String>> tableData = new LinkedHashMap<>();
        List<WebElement> headers = driver.findElements(By.tagName("th"));
        List<String> headerList = new ArrayList<>();
        for (int i = 0; i < 6/*headers.size()*/; i++) {
            headerList.add(headers.get(i).getText());
        }

        // Initialize the tableData with headers
        for (String header : headerList) {
            tableData.put(header, new ArrayList<>());
        }

        // Extract the table rows
        List<WebElement> rows = driver.findElements(By.tagName("tr"));

        // Iterate through each row
        for (int i = 1; i < 11/*rows.size()*/; i++) { // Start from 1 to skip header row
            WebElement row = rows.get(i);
            List<WebElement> cells = row.findElements(By.tagName("td"));

            for (int j = 0; j < cells.size(); j++) {
                String cellText = cells.get(j).getText();
                String header = headerList.get(j);
                tableData.get(header).add(cellText);
            }
        }

        return tableData;
    }


}
