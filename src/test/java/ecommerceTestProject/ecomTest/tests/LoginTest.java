package ecommerceTestProject.ecomTest.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import static ecommerceTestProject.ecomTest.util.Constants.*;
import ecommerceTestProject.ecomTest.util.PropertiesFileReader;

@TestInstance(Lifecycle.PER_CLASS)
public class LoginTest extends BaseTest {

	@BeforeEach
	public void navigate() {
		driver.get(HOMEPAGE);
	}

	@Test
	public void testSuccessfulLogin() {
		loginPage.loginAs(PropertiesFileReader.get(VALID_USERNAME), PropertiesFileReader.get(VALID_PASSWORD));
		Assertions.assertEquals("Products", inventoryPage.getSecondaryHeaderText());
		Assertions.assertEquals(inventoryPage.getCurrentUrl(), INVENTORY_URL);
	}

	@Test
	public void invalidLogin() {
		loginPage.loginAs(PropertiesFileReader.get(INVALID_USERNAME), PropertiesFileReader.get(INVALID_PASSWORD));
		assertTrue(loginPage.isErrorVisible());
		Assertions.assertEquals(loginPage.getCurrentUrl(), HOMEPAGE);
	}
}
