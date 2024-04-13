package StepDefinations;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import Pages.AcademyHomePage;
import Pages.CartPage;
import Pages.ProductDetailsPage;
import Pages.SearchResultPage;
import Pages.WebDriverManager;
import Utility.ExcelUtility;
import Utility.ScreenshotUtility;
import Utility.SeleniumHighlighterUtility;
import Utility.WindowHandles;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

/**
 * @author Gopi Appapuram
 * 
 * This class contains step definitions for the Myntra website testing scenario.
 */

public class MyntraStepDefination {
	WebDriver driver; // WebDriver instance for browser automation
	AcademyHomePage homepage; // Page object for interactions with the Myntra homepage
	ProductDetailsPage ProductDetails; // Page object for interactions with the product details page
	SearchResultPage searchPage; // Page object for interactions with the search result page
	SeleniumHighlighterUtility highlighter; // Utility for highlighting elements in Selenium
	ScreenshotUtility Screenshot; // Utility for taking screenshots in Selenium
	CartPage cart; // Page object for interactions with the cart page
	WindowHandles handels; // Utility for managing browser windows
	ExcelUtility excel; // Utility for reading/writing data from/to Excel

	String HomePageTitle; // Stores the title of the Myntra homepage
	String SearchPageTitle; // Stores the title of the search result page
	String ProductDetailsPageTitle; // Stores the title of the product details page
	String CartPageTitle; // Stores the title of the cart page
	String CheckOutPageTitle; // Stores the title of the checkout page (not used in this code snippet)

	// This method is executed before each scenario
	@Before
	public void setUp() {
		driver = WebDriverManager.getChromeDriver(); // Initialize WebDriver for Chrome
		Screenshot = new ScreenshotUtility(driver); // Initialize ScreenshotUtility
		homepage = new AcademyHomePage(driver); // Initialize AcademyHomePage object
		searchPage = new SearchResultPage(driver); // Initialize SearchResultPage object
		ProductDetails = new ProductDetailsPage(driver); // Initialize ProductDetailsPage object
		cart = new CartPage(driver); // Initialize CartPage object
		handels = new WindowHandles(driver); // Initialize WindowHangels object
		String path = "D:\\ESoft_Solutions\\AutomationPractice\\BDD_Framework\\Myntra.xlsx";
		excel = new ExcelUtility(path); // Initialize ExcelUtility with specified path
	}

	@Given("I am on the Myntra website")
	public void i_am_on_myntra_website() {
		driver.get("https://www.myntra.com/");

	}

	@When("I search for any {string} in the search textbox")
	public void i_search_for_in_search_textbox(String productname) throws Exception {
		excel.setSheet("TestData"); // Sets the Excel sheet to read data from
		int RowSize = excel.rowCount(); // Gets the total number of rows in the Excel sheet
		Random random = new Random(); // Random object for selecting a random row
		int rowNum = random.nextInt(RowSize); // Generates a random row number
		productname = excel.readData(rowNum, 0); // Reads the product name from the Excel sheet
		homepage.searchForProduct(productname); // Enters the product name in the search box
		homepage.clickSearchButton(); // Clicks the search button to perform the search
		// Searches for the specified product on the Myntra website
		SearchPageTitle = searchPage.searchPageTitle();

	}

	@Then("I can see list of product list page")
	public void i_can_see_list_of_product_list() {
		searchPage.isProdListDisplayed();
	}

	@Given("I can see list of products")
	public void i_can_see_list_of_products() {
		searchPage.isProdListDisplayed();

	}

	@When("I applied any filter for price range")
	public void i_applied_any_filter_for_price_range() {
		searchPage.selectPriceRange();
		Screenshot.takeScreenshot("Pricerange");
	}

	@Then("I can see only products within the specified price range")
	public void i_can_see_only_products_within_the_specified_price_range() throws Exception {
		searchPage.filtersChecked();
		Screenshot.takeScreenshot("Filters_checked");
	}

	@And("I select a product with any index from the list")
	public void i_select_a_product_from_list() throws Exception {
		searchPage.clickOnAnyItem();
		ProductDetailsPageTitle = driver.getTitle();
		Screenshot.takeScreenshot("SelectedItem");

	}

	@When("I am on the product details page")
	public void i_am_on_the_product_details_page() {
		System.out.println("You are on " + ProductDetails.getProductDetailPageTitle() + "page.");
	}

	@Then("I should see the product name and price")
	public void i_should_see_product_name_and_price() throws Exception {
		// ProductDetailsPageTitle = driver.getTitle();
		// System.out.println(ProductDetailsPageTitle);
		handels.switchToWindow(ProductDetailsPageTitle);
		boolean isProductNameDisplayed = ProductDetails.prodNameIsDisplayed(); // This is used to check whether the product name and price is displayed or not
		Assert.assertTrue(isProductNameDisplayed, "Product name is not displayed.");
		boolean isProductPriceDisplayed = ProductDetails.prodPriceIsDisplayed();
		Assert.assertTrue(isProductPriceDisplayed, "Product price is not displayed.");
		System.out.println("Product Brand: " + ProductDetails.getProductBrand());// This is used to print the product brand.
		System.out.println("Product Name: " + ProductDetails.getProductName());// This is used to print the product name.
		System.out.println("Product Price: " + ProductDetails.getProductPrice());// This is used to print the product price.
		excel.setSheet("Product_Details"); // Sets the Excel sheet to read/write data from 

		String ProductBrand = ProductDetails.getProductBrand();
		String ProductName = ProductDetails.getProductName();
		String ProductPrice = ProductDetails.getProductPrice();

		String[] arrOfStr = ProductPrice.split("₹");
		for (String price : arrOfStr) {
			ProductPrice = price;
		}

		String[] productDetails = { 
				ProductBrand, 
				ProductName, 
				ProductPrice
		};
		
		

		excel.writeData(0, productDetails, "pink");

	}

	@Given("I selected a product variant from the list")
	public void i_selected_a_product_variant_from_the_list() throws Exception {
		try {
			ProductDetails.selectProductColour();
		} catch (Exception e) {
			System.out.println("No Colour variants for this product found");
		}
		try {
			ProductDetails.selectProductSize();
		} catch (Exception e) {
			System.out.println("No product Size is avilable");
		}
	}

	@When("I add the item to the cart")
	public void i_add_the_item_to_the_cart() throws Exception {
		ProductDetails.addToBag();
	}

	@And("I am on cart page")
	public void i_am_on_cart_page() throws Exception {
		ProductDetails.clickCartIcon();
		Screenshot.takeScreenshot("Cart_Page");
	}

	@Then("I can see the item in the cart")
	public void i_can_see_the_item_in_the_cart() {
		cart.isCartEmpty();
	}

	@When("Navigate to search details page")
	public void navigate_to_search_page() throws Exception {
		handels.switchToWindow(SearchPageTitle);
		System.out.println(SearchPageTitle);
	}

	@And("I select another product with any index from the list")
	public void i_Select_Another_Product_From_List() throws Exception {
		searchPage.clickOnAnyItem();
		Screenshot.takeScreenshot("SelectedItem");
	}

	@When("User removes the items from the cart")
	public void user_removes_the_items_from_the_cart() throws Exception {
		cart.selectAllItemsFromCart();
		cart.removeAllItems();
	}

	@Then("User should see an empty cart")
	public void user_should_see_an_empty_cart() {
		cart.isCartEmpty();
		Screenshot.takeScreenshot("Empty_Cart_Page");
	}

	@Then("Close the browser")
	public void close_the_browser() throws Exception {
		handels.closeAllTabs();
		driver.quit();
	}
}
