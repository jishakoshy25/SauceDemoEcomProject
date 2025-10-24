package ecommerceTestProject.ecomTest.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InventoryPage extends BasePage {
	@FindBy(css = "div[data-test='secondary-header'] span.title")
	private WebElement secondaryHeader;

	@FindBy(css = "button#add-to-cart-sauce-labs-backpack")
	private WebElement addToCartBackpack;

	@FindBy(css = "a.shopping_cart_link>span")
	private WebElement cart;

	@FindBy(css = "a.shopping_cart_link")
	private WebElement cartLink;

	@FindBy(css = "button#remove-sauce-labs-backpack")
	private WebElement removeButton;

	@FindBy(css = "div.app_logo")
	private WebElement logo;

	@FindBy(css = "div.inventory_item_name")
	private List<WebElement> inventoryNames;

	@FindBy(css = "select.product_sort_container")
	private WebElement filterDropdown;

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement burgerMenu;

	@FindBy(css = "div.bm-menu  a#logout_sidebar_link")
	private WebElement logoutLink;

	@FindBy(css = "a#about_sidebar_link")
	private WebElement aboutLink;

	public InventoryPage(WebDriver driver) {
		super(driver);
	}

	public String getSecondaryHeaderText() {
		return secondaryHeader.getText();
	}

	public void clickAddToCart() {
		addToCartBackpack.click();
	}

	public int cartHasItems() {
		List<WebElement> childElements = cartLink.findElements(By.xpath("./*"));
		return childElements.size();
	}

	public String getCartItemCount() {
		return cart.getText();
	}

	public boolean isRemoveButtonVisible() {
		return removeButton.isDisplayed();
	}

	public void clickRemoveBtn() {
		removeButton.click();
	}

	public void clickLogo() {
		logo.click();
	}

	public List<String> getInventoryList() {
		List<String> productNameList = new ArrayList<String>();
		for (WebElement productName : inventoryNames) {
			productNameList.add(productName.getText());
		}
		return productNameList;
	}

	public List<String> getSortedListOfInventoryNames() {
		List<String> productNameList = new ArrayList<String>();
		for (WebElement productName : inventoryNames) {
			productNameList.add(productName.getText());
		}
		Collections.sort(productNameList, Collections.reverseOrder());
		return productNameList;
	}

	public void selectFilterBasedOnNameZtoA() {
		Select dropdown = new Select(filterDropdown);
		dropdown.selectByContainsVisibleText("Name (Z to A)");
	}

	public void clickBurgerMenu() {
		burgerMenu.click();
	}

	public void clickLogout() throws InterruptedException {
		burgerMenu.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(3000));
		wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(logoutLink).click().perform();
	}
	
	public void clickAboutLink() throws InterruptedException {
		burgerMenu.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(3000));
		wait.until(ExpectedConditions.elementToBeClickable(aboutLink));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(aboutLink).click().perform();
	}
}
