package ecommerceTestProject.ecomTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutCompletePage extends BasePage{

	public CheckoutCompletePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "div.header_secondary_container span.title")
	private WebElement title;
	
	@FindBy(css = "h2.complete-header")
	private WebElement header;
	
	@FindBy(css = "div.complete-text")
	private WebElement textMessage;
	
	@FindBy(css="button#back-to-products")
	private WebElement backToHomeBtn;
	
	public String getSecondaryTitle() {
		return title.getText();
	}
	
	public String getOrderSucccessMessage() {
		return header.getText();
	}
	
	public String getTextMessage() {
		return textMessage.getText();
	}
	
	public void clickBackBtn() {
		backToHomeBtn.click();
	}

}
