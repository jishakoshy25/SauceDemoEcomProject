package ecommerceTestProject.ecomTest.base;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;


@TestInstance(Lifecycle.PER_CLASS)
public class LoginTest extends BaseTest {
	
	@BeforeEach
	public void navigate() {
		driver.get("https://www.saucedemo.com/");
	}

	@Test
	public void testSuccessfulLogin() {
		loginPage.loginAs("standard_user", "secret_sauce");
		assertTrue(inventoryPage.isAt(), "User should be redirected to inventory page after login.");
		Assertions.assertEquals("Products", inventoryPage.getSecondaryHeaderText());
		Assertions.assertEquals(inventoryPage.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
	}

	@Test
	public void invalidLogin() {
		loginPage.loginAs("standard_user1", "secret_sauce1");
		assertTrue(loginPage.isErrorVisible());
		Assertions.assertEquals(loginPage.getCurrentUrl(), "https://www.saucedemo.com/");
	}
}
