package ecommerceTestProject.ecomTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

	@FindBy(css = "div.header_secondary_container span.title")
	private WebElement title;
	
	@FindBy(xpath = "//input[@id='first-name']")
	private WebElement firstName;
	
	@FindBy(xpath = "//input[@id='last-name']")
	private WebElement lastName;
	
	@FindBy(xpath = "//input[@id='postal-code']")
	private WebElement postalCode;
	
	@FindBy(css = "input#continue")
	private WebElement continueBtn;

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	public String getSecondaryTitle() {
		return title.getText();
	}
	
	public void enterFirstName(String fname) {
		firstName.sendKeys(fname);
	}
	
	public void enterLastName(String lname) {
		lastName.sendKeys(lname);
	}
	
	public void enterPostalCode(String pCode) {
		postalCode.sendKeys(pCode);
	}
	
	public void clickContinue() {
		continueBtn.click();
	}
}
