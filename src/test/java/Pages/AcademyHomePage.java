package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.SeleniumHighlighterUtility;

/**
 * @author Gopi Appapuram
 * 
 * This class represents the Home Page of the application.
 * It contains methods to interact with elements on the Home Page.
 */
public class AcademyHomePage {

	WebDriver driver;
	SeleniumHighlighterUtility highlighter;

	/**
	 * Constructor to initialize the Academy Home Page
	 * 
	 * @param driver The WebDriver instance
	 */
	public AcademyHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.highlighter = new SeleniumHighlighterUtility(driver);
	}

	/*
	 * Web Elements on the Academy Home Page
	 * 
	 */
	
	@FindBy(xpath = "//input[contains(@placeholder,'Search for products')]")
	WebElement searchInput;

	@FindBy(xpath = "//a[@class='desktop-submit']")
	WebElement searchButton;

	/**
	 * Method to search for a product
	 * 
	 * @param productName The name of the product to search
	 */
	public void searchForProduct(String productName) {
		// Highlighting the search input field
		highlighter.highlightElement(searchInput);
		// Entering the product name in the search input field
		searchInput.sendKeys(productName);
		highlighter.highlightElementWithSpecifiedBodderAndColour(searchInput, "2px solid black");;
	}

	/**
	 * Method to click the search button
	 */
	public void clickSearchButton() {
		// Highlighting the search button
		highlighter.highlightElement(searchButton);
		// Clicking the search button
		searchButton.click();
	}

}
