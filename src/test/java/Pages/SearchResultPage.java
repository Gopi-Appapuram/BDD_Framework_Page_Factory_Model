package Pages;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import Utility.ScreenshotUtility;
import Utility.ScrollUtility;
import Utility.SeleniumHighlighterUtility;

/**
 * @author Gopi Appapuram
 * 
 * This class represents the Search Result Page of the application.
 * It contains methods to interact with elements on the Search Result Page.
 */
public class SearchResultPage {

	WebDriver driver;
	SeleniumHighlighterUtility highlighter;
	ScreenshotUtility screenshot;
	ScrollUtility scroll;

	/*
	 * Web Elements on the Search Result Page
	 * 
	 */
	
	@FindBys(@FindBy(xpath = "(//ul[@class='results-base']//li[@class='product-base'])"))
	List<WebElement> productList;

	@FindBys(@FindBy(xpath = "(//ul[@class = 'price-list']/child::li)"))
	List<WebElement> priceCheckbox;

	@FindBys(@FindBy(xpath = "(//ul[@class = 'brand-list']/child::li)"))
	List<WebElement> brandCheckbox;

	@FindBys(@FindBy(xpath = "(//ul[@class = 'categories-list']/child::li)"))
	List<WebElement> categoriesCheckbox;

	@FindBys(@FindBy(xpath = "(//li//div[@class = 'filter-summary-filter'])"))
	List<WebElement> filterSummary;

	/**
	 * Constructor to initialize the Search Result Page
	 * 
	 * @param driver The WebDriver instance
	 */
	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.scroll = new ScrollUtility(driver);
		this.highlighter = new SeleniumHighlighterUtility(driver);
	}

	/**
	 * Method to check if the product list is displayed
	 * 
	 * @return true if product list is displayed, false otherwise
	 */
	public boolean isProdListDisplayed() {
		int prodlist = productList.size();
		try {
			System.out.println("Total no of products in the list are :" + prodlist + ".");
			return prodlist > 0;
		} catch (NullPointerException e) {
			System.out.println("Product list is empty.");
			return false;
		}
	}

	/**
	 * Method to click on any random item in the product list
	 * 
	 * @throws Exception
	 */
	public void clickOnAnyItem() throws Exception {
		int maxProducts = productList.size();
		Random random = new Random();
		int randomProduct = random.nextInt(maxProducts);
		// Click on the product
		scroll.scrollElementIntoView(productList.get(randomProduct));
		productList.get(randomProduct).click();
		Thread.sleep(3000);
	}

	/**
	 * Method to get the title of the search result page
	 * 
	 * @return The title of the search result page
	 */
	public String searchPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	// Variables for Price Range Filter
	int maxPriceFilters;
	int randomPriceFilter;

	/**
	 * Method to select a random price range filter
	 */
	public void selectPriceRange() {
		Random random = new Random();
		maxPriceFilters = priceCheckbox.size();
		System.out.println("Total no of price filters are: " + maxPriceFilters);
		randomPriceFilter = random.nextInt(maxPriceFilters);
		scroll.scrollElementIntoView(priceCheckbox.get(randomPriceFilter));

		try {
			priceCheckbox.get(randomPriceFilter).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * Method to check if the applied filters are displayed in the filter summary
	 * 
	 * @throws Exception
	 */
	public void filtersChecked() throws Exception {
		int appliedFilters = filterSummary.size();
		if (priceCheckbox.get(randomPriceFilter).getText() != null) {	
			for (int i = 0; i < appliedFilters; i++) {
				if (priceCheckbox.get(randomPriceFilter).getText().equals(filterSummary.get(i).getText())) {
					scroll.scrollElementIntoView(filterSummary.get(i));
					System.out.println("Products are displayed within the range: " 
							+ filterSummary.get(i).getText()
							+ " price range");
					Thread.sleep(3000);
				}
			}
		} else {
			scroll.scrollElementIntoView(priceCheckbox.get(randomPriceFilter));
			System.out.println("Price filters are not applied.");
			driver.quit();
		}
	}

}
