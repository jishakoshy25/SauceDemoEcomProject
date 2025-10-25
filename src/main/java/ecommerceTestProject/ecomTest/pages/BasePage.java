package ecommerceTestProject.ecomTest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

	private WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getCurrentUrl() {
		return driver.getCurrentUrl();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public String getPageTitle() {
		return driver.getTitle();
	}
	
	public void goBack() {
		driver.navigate().back();
	}
}
