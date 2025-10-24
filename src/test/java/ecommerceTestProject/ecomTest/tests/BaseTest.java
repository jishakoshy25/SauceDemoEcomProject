package ecommerceTestProject.ecomTest.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import ecommerceTestProject.ecomTest.pages.InventoryPage;
import ecommerceTestProject.ecomTest.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	protected WebDriver driver;
	protected LoginPage loginPage;
	protected InventoryPage inventoryPage;

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
		loginPage = new LoginPage(driver);
		inventoryPage = new InventoryPage(driver);
	}

	@AfterAll
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
