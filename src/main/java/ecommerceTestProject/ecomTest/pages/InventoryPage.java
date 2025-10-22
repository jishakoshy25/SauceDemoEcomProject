package ecommerceTestProject.ecomTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{
	@FindBy(className = "title")
    private WebElement inventoryTitle;
	
	@FindBy(css = "div[data-test='secondary-header'] span.title")
    private WebElement secondaryHeader;

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public boolean isAt() {
        return inventoryTitle.isDisplayed();
    }
    
    public String getSecondaryHeaderText() {
    	return secondaryHeader.getText();
    }
}


