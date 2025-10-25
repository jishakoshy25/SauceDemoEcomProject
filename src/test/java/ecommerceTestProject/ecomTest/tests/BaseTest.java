package ecommerceTestProject.ecomTest.tests;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ecommerceTestProject.ecomTest.pages.CartPage;
import ecommerceTestProject.ecomTest.pages.CheckoutCompletePage;
import ecommerceTestProject.ecomTest.pages.CheckoutPage;
import ecommerceTestProject.ecomTest.pages.CheckoutPage2;
import ecommerceTestProject.ecomTest.pages.InventoryPage;
import ecommerceTestProject.ecomTest.pages.LoginPage;
import ecommerceTestProject.ecomTest.pages.NavigationSideBar;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected InventoryPage inventoryPage;
	protected CartPage cartPage;
	protected NavigationSideBar navigationSideBar;
	protected CheckoutPage checkoutPage;
	protected CheckoutPage2 checkoutPage2;
	protected CheckoutCompletePage checkoutCompletePage;

	@BeforeAll
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--disable-notifications");
		options.addArguments("--disable-popup-blocking");
		options.addArguments("--guest");
		options.addArguments("--disable-infobars");
		options.setExperimentalOption("prefs", new java.util.HashMap<String, Object>() {
			{
				put("reduce-security-for-testing", true);
			}
		});
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
		cartPage = new CartPage(driver);
		navigationSideBar = new NavigationSideBar(driver);
		checkoutPage =  new CheckoutPage(driver);
		checkoutPage2 =  new CheckoutPage2(driver);
		checkoutCompletePage =  new CheckoutCompletePage(driver);
	}

	@AfterAll
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
