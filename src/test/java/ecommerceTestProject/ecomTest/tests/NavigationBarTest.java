package ecommerceTestProject.ecomTest.tests;

import static ecommerceTestProject.ecomTest.util.Constants.ABOUT_URL;
import static ecommerceTestProject.ecomTest.util.Constants.CART_URL;
import static ecommerceTestProject.ecomTest.util.Constants.HOMEPAGE;
import static ecommerceTestProject.ecomTest.util.Constants.INVENTORY_URL;
import static ecommerceTestProject.ecomTest.util.Constants.VALID_PASSWORD;
import static ecommerceTestProject.ecomTest.util.Constants.VALID_USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ecommerceTestProject.ecomTest.util.PropertiesFileReader;

@TestInstance(Lifecycle.PER_CLASS)
public class NavigationBarTest extends BaseTest {
	@BeforeEach
	public void navigate() {
		driver.get(HOMEPAGE);
		loginPage.loginAs(PropertiesFileReader.get(VALID_USERNAME), PropertiesFileReader.get(VALID_PASSWORD));
	}

	@Test
	public void testLogout() throws InterruptedException {
		navigationSideBar.clickLogout();
		Assertions.assertEquals(HOMEPAGE, navigationSideBar.getCurrentUrl());
		assertEquals("Swag Labs", loginPage.getLoginHeaderTitle());
	}

	@Test
	public void testAboutLink() throws InterruptedException {
		navigationSideBar.clickAboutLink();
		Assertions.assertEquals(ABOUT_URL, navigationSideBar.getCurrentUrl());
	}
	
	@Test
	public void testAllItemsLink() throws InterruptedException {
		inventoryPage.clickAddToCart();
		inventoryPage.clickCartLink();
		assertEquals(CART_URL, inventoryPage.getCurrentUrl());
		navigationSideBar.clickAllItemsLink();
		Assertions.assertEquals(INVENTORY_URL, navigationSideBar.getCurrentUrl());
		Assertions.assertEquals("Products", inventoryPage.getSecondaryHeaderText());
	}
}
