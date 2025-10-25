package ecommerceTestProject.ecomTest.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationSideBar extends BasePage {

	@FindBy(xpath = "//button[@id='react-burger-menu-btn']")
	private WebElement burgerMenu;

	@FindBy(css = "div.bm-menu  a#logout_sidebar_link")
	private WebElement logoutLink;

	@FindBy(css = "a#about_sidebar_link")
	private WebElement aboutLink;

	@FindBy(css = "a#inventory_sidebar_link")
	private WebElement allItemsLink;

	public void clickBurgerMenu() {
		burgerMenu.click();
	}

	public NavigationSideBar(WebDriver driver) {
		super(driver);
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

	public void clickAllItemsLink() throws InterruptedException {
		burgerMenu.click();
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofMillis(3000));
		wait.until(ExpectedConditions.elementToBeClickable(allItemsLink));
		Actions actions = new Actions(getDriver());
		actions.moveToElement(allItemsLink).click().perform();
	}

}
