package ecommerceTestProject.ecomTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

	@FindBy(css ="div.header_secondary_container span.title")
	private WebElement title;
	
	@FindBy(css ="div.inventory_item_name")
	private WebElement cartItemName;
	
	@FindBy(css = "div.inventory_item_desc")
	private WebElement itemDescription;
	
	@FindBy(css = "div.inventory_item_price")
	private WebElement itemPrice;
	
	@FindBy(css = "button#remove-sauce-labs-backpack")
	private WebElement removeBtn;
	
	@FindBy(css = "button#checkout")
	private WebElement checkoutBtn;
	
	@FindBy(css = "button#continue-shopping")
	private WebElement continueBtn;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public String getSecondaryTitle() {
		return title.getText();
	}
	
	public String getCartItemName() {
		return cartItemName.getText();
	}
	
	public String getCartItemDescription() {
		return itemDescription.getText();
	}
	
	public String getItemPrice() {
		return itemPrice.getText();
	}
	
	public void clickCheckoutBtn() {
		checkoutBtn.click();
	}
	
	public void clickRemoveBtn() {
		removeBtn.click();
	}
	
	public void clickContinueBtn() {
		continueBtn.click();
	}
}
