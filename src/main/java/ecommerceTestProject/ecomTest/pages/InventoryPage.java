package ecommerceTestProject.ecomTest.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage extends BasePage{
	@FindBy(className = "title")
    private WebElement inventoryTitle;
	
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

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return inventoryTitle.isDisplayed();
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
    	List<String> productNameList =  new ArrayList<String>();
    	for (WebElement productName: inventoryNames) {
    		productNameList.add(productName.getText());
    	}
    	return productNameList;
    }
    
    public List<String> getSortedListOfInventoryNames() {
    	List<String> productNameList =  new ArrayList<String>();
    	for (WebElement productName: inventoryNames) {
    		productNameList.add(productName.getText());
    	}
    	Collections.sort(productNameList, Collections.reverseOrder());
    	return productNameList;
    }
    
    public void selectFilterBasedOnNameZtoA() {
    	Select dropdown =  new Select(filterDropdown);
    	dropdown.selectByContainsVisibleText("Name (Z to A)");
    }
}


