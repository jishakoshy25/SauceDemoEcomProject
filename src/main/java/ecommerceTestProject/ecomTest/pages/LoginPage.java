package ecommerceTestProject.ecomTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
	
	@FindBy(css = "div.login_logo")
	private WebElement headerTitle;

	@FindBy(id = "user-name")
	private WebElement usernameField;

	@FindBy(id = "password")
	private WebElement passwordField;

	@FindBy(id = "login-button")
	private WebElement loginButton;

	@FindBy(css = "[data-test='error']")
	private WebElement errorMessage;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void loginAs(String username, String password) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
	}

	public boolean isErrorVisible() {
		return errorMessage.isDisplayed();
	}

	public String getErrorText() {
		return errorMessage.getText();
	}
	
	public String getLoginHeaderTitle() {
		return headerTitle.getText();
	}
}
