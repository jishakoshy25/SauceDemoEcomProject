package ecommerceTestProject.ecomTest.tests;

import static ecommerceTestProject.ecomTest.util.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ecommerceTestProject.ecomTest.util.PropertiesFileReader;

@TestInstance(Lifecycle.PER_CLASS)
public class CartTest extends BaseTest {
	@BeforeEach
	public void navigate() {
		driver.get(HOMEPAGE);
		loginPage.loginAs(PropertiesFileReader.get(VALID_USERNAME), PropertiesFileReader.get(VALID_PASSWORD));
	}

	@Test
	public void testCartItems() throws InterruptedException {
		inventoryPage.clickAddToCart();
		inventoryPage.clickCartLink();
		assertEquals(CART_URL, inventoryPage.getCurrentUrl());
		assertEquals("Your Cart", cartPage.getSecondaryTitle());
		assertEquals("Sauce Labs Backpack", cartPage.getCartItemName());
		assertEquals("carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with "
				+ "unequaled laptop and tablet protection.", cartPage.getCartItemDescription());
		assertEquals("$29.99", cartPage.getItemPrice());
		cartPage.clickRemoveBtn();
	}
	
	@Test
	public void testCheckout() {
		inventoryPage.clickAddToCart();
		inventoryPage.clickCartLink();
		cartPage.clickCheckoutBtn();
		assertEquals(CHECKOUT, cartPage.getCurrentUrl());
		cartPage.goBack();
		cartPage.clickRemoveBtn();
	}
	
	@Test
	public void testContinueShopping() {
		inventoryPage.clickAddToCart();
		inventoryPage.clickCartLink();
		cartPage.clickContinueBtn();
		assertEquals(INVENTORY_URL, inventoryPage.getCurrentUrl());
		inventoryPage.clickRemoveBtn();
	}

	@AfterEach
	public void logout() throws InterruptedException {
		navigationSideBar.clickLogout();
	}
}
