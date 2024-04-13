package Pages;

import java.util.List;
import java.util.Random;

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
 * This class represents the Product Details Page of the application.
 * It contains methods to interact with elements on the Product Details Page.
 */
public class ProductDetailsPage {

	WebDriver driver;
	SeleniumHighlighterUtility highlighter;
	ScreenshotUtility screenshot;
	ScrollUtility scroll;

	/*
	 * Web Elements on the Product Details Page
	 * 
	 */
	
	@FindBy(xpath = "//h1[contains(@class,'pdp-title')]")
	WebElement productBrand;

	@FindBy(xpath = "//h1[contains(@class,'pdp-name')]")
	WebElement productName;

	@FindBy(xpath = "//span[@class='pdp-price']")
	WebElement productPrice;

	@FindBys(@FindBy(xpath = "(//img[@class='colors-image'])"))
	List<WebElement> productColour;

	@FindBys(@FindBy(xpath = "(//button[contains(@class,'size-buttons-size-button size-buttons-size-button-default')])"))
	List<WebElement> productSize;

	@FindBy(xpath = "//div[contains(text(),'ADD TO BAG')]")
	WebElement addToBag;

	@FindBy(xpath = "//p[contains(text(), 'Added to bag')]")
	WebElement alertMessageOfAddToBag;

	@FindBy(xpath = "//span[contains(@class,'desktop-badge')]")
	WebElement nofCartItems;

	@FindBy(xpath = "(//div[@class='desktop-user'])")
	WebElement userIcon;

	@FindBy(xpath = "//div[@class='desktop-wishlist']")
	WebElement wishListIcon;

	@FindBy(xpath = "//span[contains(@class,'desktop-iconBag')]")
	WebElement cartIcon;

	/**
	 * Constructor to initialize the Product Details Page
	 * 
	 * @param driver The WebDriver instance
	 */
	public ProductDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.highlighter = new SeleniumHighlighterUtility(driver);
		this.scroll = new ScrollUtility(driver);
	}

	/**
	 * Method to get the product name
	 * 
	 * @return The product name
	 */
	public String getProductName() {
		highlighter.highlightElement(productName);
		return productName.getText();
	}

	/**
	 * Method to get the product brand
	 * 
	 * @return The product brand
	 */
	public String getProductBrand() {
		highlighter.highlightElement(productBrand);
		return productBrand.getText();
	}

	/**
	 * Method to get the product price
	 * 
	 * @return The product price
	 */
	public String getProductPrice() {
		highlighter.highlightElement(productPrice);
		return productPrice.getText();
	}

	/**
	 * Method to check if product price is displayed
	 * 
	 * @return true if product price is displayed, false otherwise
	 */
	public Boolean prodPriceIsDisplayed() {
		return productPrice.isDisplayed();
	}

	/**
	 * Method to check if product name is displayed
	 * 
	 * @return true if product name is displayed, false otherwise
	 */
	public Boolean prodNameIsDisplayed() {
		return productName.isDisplayed();
	}

	/**
	 * Method to get the title of the product details page
	 * 
	 * @return The title of the product details page
	 */
	public String getProductDetailPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	/**
	 * Method to select a random product colour
	 * 
	 * @throws Exception
	 */
	public void selectProductColour() throws Exception {
		int maxProductColours = productColour.size();
		if (maxProductColours >= 0) {
			Random random = new Random();
			int randomProductColour = random.nextInt(maxProductColours);
			scroll.scrollElementIntoView(productColour.get(randomProductColour));
			highlighter.highlightElement(productColour.get(randomProductColour));
			productColour.get(randomProductColour).click();
			Thread.sleep(5000);
		} else {
			System.out.println("No product colours for the selected product.");
		}

	}

	/**
	 * Method to select a random product size
	 * 
	 * @throws Exception
	 */
	public void selectProductSize() throws Exception {
		int maxProductSizes = productSize.size();
		Random random = new Random();
		if (maxProductSizes >= 0) {
			int randomProductSize = random.nextInt(maxProductSizes);
			scroll.scrollElementIntoView(productSize.get(randomProductSize));
			highlighter.highlightElement(productSize.get(randomProductSize));
			productSize.get(randomProductSize).click();
			Thread.sleep(5000);
		} else {
			System.out.println("No product Size for this product");
		}

	}

	/**
	 * Method to add the product to the bag
	 * 
	 * @throws Exception
	 */
	public void addToBag() throws Exception {
		highlighter.highlightElement(addToBag);
		addToBag.click();
		Thread.sleep(1500);
		if (alertMessageOfAddToBag.getText().equals("Added to bag")) {
			System.out.println("Product added successfully");
		} else {
			System.out.println("Please try again to add the product to the cart");
		}
		Thread.sleep(3000);
	}

	/**
	 * Method to click on the Cart icon
	 * 
	 * @throws Exception
	 */
	public void clickCartIcon() throws Exception {
		highlighter.highlightElement(cartIcon);
		cartIcon.click();
		Thread.sleep(3000);
		if (driver.getTitle().equals("SHOPPING BAG")) {
			System.out.println("You are in CART page");
		} else {
			System.out.println("You are in " + driver.getTitle() + " page");
		}
	}

	/**
	 * Method to click on the Wishlist icon
	 */
	public void clickWishListIcon() {
		wishListIcon.click();
		if (driver.getTitle().equals("Wishlist")) {
			highlighter.highlightElement(wishListIcon);
			System.out.println("You are in WISHLIST page");
		} else {
			System.out.println("You are in " + driver.getTitle() + " page");
		}
	}

}
