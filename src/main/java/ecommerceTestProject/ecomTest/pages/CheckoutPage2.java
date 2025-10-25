package ecommerceTestProject.ecomTest.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage2 extends BasePage {

	@FindBy(css = "div.header_secondary_container span.title")
	private WebElement title;
	
	@FindBy(css = "button#finish")
	private WebElement finishBtn;
	
	@FindBy(css = "div.inventory_item_name")
	private List<WebElement> inventoryNames;
	
	@FindBy(css = "div.cart_quantity")
	private List<WebElement> cartQuantities;

	public CheckoutPage2(WebDriver driver) {
		super(driver);
	}

	public String getSecondaryTitle() {
		return title.getText();
	}
	
	public void clickFinish() {
		finishBtn.click();
	}
	
	public String getInventoryName() {
		return inventoryNames.get(0).getText();
	}
	
	public String getCartQuantity() {
		return cartQuantities.get(0).getText();
	}
}
