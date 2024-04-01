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

public class SearchResultPage {

	WebDriver driver;
	SeleniumHighlighterUtility highlighter;
	ScreenshotUtility screenshot;
	ScrollUtility scroll;

//	@FindBys(@FindBy(xpath = "(//div[contains(@class,'product-detail-container')])")) //(//ul[@class='results-base']//li)
//	List<WebElement> productList;

	@FindBys(@FindBy(xpath = "(//ul[@class='results-base']//li[@class='product-base'])"))
	List<WebElement> productList;

	@FindBys(@FindBy(xpath = "(//ul[@class = 'price-list']/child::li)"))
	List<WebElement> priceCheckbox;

	@FindBys(@FindBy(xpath = "(//ul[@class = 'brand-list']/child::li)"))
	List<WebElement> brandCheckbox;

	@FindBys(@FindBy(xpath = "(//ul[@class = 'categories-list']/child::li)"))
	List<WebElement> catagoriesCheckbox;

	@FindBys(@FindBy(xpath = "(//li//div[@class = 'filter-summary-filter'])"))
	List<WebElement> filterSummary;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.scroll = new ScrollUtility(driver);
		this.highlighter = new SeleniumHighlighterUtility(driver);
	}

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

	public void clickOnAnyItem() throws Exception {
		int maxProducts = productList.size();
		Random random = new Random();
		int randomProduct = random.nextInt(maxProducts);
		// Click on the product
		scroll.scrollElementIntoView(productList.get(randomProduct));
		productList.get(randomProduct).click();
		Thread.sleep(3000);
//		String mainWindowHandle = driver.getWindowHandle();
//		// Switch to the new window
//		for (String windowHandle : driver.getWindowHandles()) {
//			if (!windowHandle.equals(mainWindowHandle)) {
//				driver.switchTo().window(windowHandle);
//				break;
//			}
//		}

	}

	public String searchPageTitle() {
		String title = driver.getTitle();
		return title;
	}

	int maxPriceFilters;
	int ramdomPriceFilter;

	public void selectPriceRange() {
		Random random = new Random();
		maxPriceFilters = priceCheckbox.size();
		System.out.println("Total no of proce filter are: " + maxPriceFilters);
		ramdomPriceFilter = random.nextInt(maxPriceFilters);
		scroll.scrollElementIntoView(priceCheckbox.get(ramdomPriceFilter));

		try {
			priceCheckbox.get(ramdomPriceFilter).click();
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void FiltersChecked() throws Exception {
		//System.out.println("method is working");
		int appliedFilters = filterSummary.size();
		if (priceCheckbox.get(ramdomPriceFilter).getText() != null) {	
			for (int i = 0; i < appliedFilters; i++) {
				if (priceCheckbox.get(ramdomPriceFilter).getText() == filterSummary.get(i).getText()) {
					scroll.scrollElementIntoView(filterSummary.get(i));
					System.out.println("Products are displayed within the range: " 
							+ filterSummary.get(i).getText()
							+ " price range");
					Thread.sleep(3000);
				}
			}
		} else {
			scroll.scrollElementIntoView(priceCheckbox.get(ramdomPriceFilter));
			System.out.println("Price filters are not applied.");
			driver.quit();
		}
	}

}