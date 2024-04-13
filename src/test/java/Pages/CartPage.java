package Pages;

import java.util.List;

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
 * This class represents the Cart Page of the application.
 * It contains methods to interact with elements on the Cart Page.
 */
public class CartPage {

	WebDriver driver;
	SeleniumHighlighterUtility highlighter;
	ScrollUtility scroll;
	ScreenshotUtility screenshot;

	/*
	 * List of Web Elements on the Cart Page
	 * 
	 */
	
	@FindBys(@FindBy(xpath = "(//div[contains(@class,'itemContainer-base-brand')])"))
	List<WebElement> brandNameInCart;

	@FindBys(@FindBy(xpath = "(//body/div[@class='layout']/div[@id='mountRoot']/div[@id='appContent']/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[3]//*[name()='svg'])"))
	List<WebElement> productCheckbox;

	@FindBys(@FindBy(xpath = "(//div[contains(@class,'itemComponents-base-selectionIconContainer')])"))
	List<WebElement> checkBoxArea;

	@FindBys(@FindBy(xpath = "(//body/div[@class='layout']/div[@id='mountRoot']/div[@id='appContent']/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/div[3]//*[name()='svg']//*[name()='path' and contains(@fill,'#000')])"))
	List<WebElement> productCrossMark;

	@FindBys(@FindBy(xpath = "(//button[contains(text(),'REMOVE')])"))
	List<WebElement> removeButton;

	/**
	 * Constructor to initialize the Cart Page
	 * 
	 * @param driver The WebDriver instance
	 */
	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.scroll = new ScrollUtility(driver);
		this.highlighter = new SeleniumHighlighterUtility(driver);
	}

	/**
	 * Method to select all items from the cart
	 * 
	 * @throws InterruptedException
	 */
	public void selectAllItemsFromCart() throws InterruptedException {
		if (brandNameInCart.isEmpty()) {
	        System.out.println("Cart is already empty");
	    } else {
			for (int i = 0; i < checkBoxArea.size(); i++) {
				WebElement checkbox = checkBoxArea.get(i);
				scroll.scrollElementIntoView(checkbox);
				// highlighter.highlightElement(checkbox);
				if (checkbox.isSelected()) {
					highlighter.highlightElement(checkbox);
					Thread.sleep(3000);
				} else {
					highlighter.highlightElement(checkbox);
					checkbox.click();
					Thread.sleep(3000);
				}
			}
		}
	}

	/**
	 * Method to remove all items from the cart
	 * 
	 * @throws Exception
	 */
	public void removeAllItems() throws Exception {
		highlighter.highlightElement(removeButton.get(0));
		removeButton.get(0).click();
		Thread.sleep(5000);
		highlighter.highlightElement(removeButton.get(1));
		removeButton.get(1).click();
		Thread.sleep(5000);
	}

	/**
	 * Method to check if the cart is empty
	 */
	public void isCartEmpty() {
		if (checkBoxArea.isEmpty()) {
			System.out.println("Cart is empty");
		} else {
			// highlighter.highlightElements(productCheckbox);
			for (int i = 0; i < checkBoxArea.size(); i++) {
				System.out.println("The list of products in the cart are: ");
				String productNameInCart = brandNameInCart.get(i).getText();
				System.out.println(productNameInCart);
			}
		}
	}
}
