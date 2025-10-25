package ecommerceTestProject.ecomTest.tests;

import static ecommerceTestProject.ecomTest.util.Constants.CART_URL;
import static ecommerceTestProject.ecomTest.util.Constants.HOMEPAGE;
import static ecommerceTestProject.ecomTest.util.Constants.VALID_PASSWORD;
import static ecommerceTestProject.ecomTest.util.Constants.VALID_USERNAME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import ecommerceTestProject.ecomTest.util.PropertiesFileReader;

@TestInstance(Lifecycle.PER_CLASS)
public class InventoryTest extends BaseTest {
	@BeforeEach
	public void navigate() {
		driver.get(HOMEPAGE);
		loginPage.loginAs(PropertiesFileReader.get(VALID_USERNAME), PropertiesFileReader.get(VALID_PASSWORD));
	}

	@Test
	public void testAddingProductToCart() throws InterruptedException {
		inventoryPage.clickAddToCart();
		assertEquals("1", inventoryPage.getCartItemCount());
		assertTrue(inventoryPage.isRemoveButtonVisible());
		inventoryPage.clickRemoveBtn();
	}

	@Test
	public void testRemovingProductFromCart() throws InterruptedException {
		inventoryPage.clickAddToCart();
		assertEquals("1", inventoryPage.getCartItemCount());
		assertTrue(inventoryPage.isRemoveButtonVisible());
		inventoryPage.clickRemoveBtn();
		assertTrue(inventoryPage.cartHasItems() == 0);
	}

	@Test
	public void testSortProducts() throws InterruptedException {
		List<String> sortedList = inventoryPage.getSortedListOfInventoryNames();
		inventoryPage.selectFilterBasedOnNameZtoA();
		assertEquals(sortedList, inventoryPage.getInventoryList());
	}
	
	@Test
	public void testCart() throws InterruptedException {
		inventoryPage.clickAddToCart();
		inventoryPage.clickCartLink();
		assertEquals(CART_URL, inventoryPage.getCurrentUrl());
		assertEquals("Your Cart", cartPage.getSecondaryTitle());
		navigationSideBar.clickAllItemsLink();
		inventoryPage.clickRemoveBtn();
	}
	
	@AfterEach
	public void logout() throws InterruptedException {
		navigationSideBar.clickLogout();
	}
}
