package ecommerceTestProject.ecomTest.base;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import static ecommerceTestProject.ecomTest.util.Constants.*;
import ecommerceTestProject.ecomTest.util.PropertiesFileReader;

@TestInstance(Lifecycle.PER_CLASS)
public class InventoryTest extends BaseTest {
	@BeforeEach
	public void navigate() {
		driver.get(HOMEPAGE);
		loginPage.loginAs(PropertiesFileReader.get(VALID_USERNAME), PropertiesFileReader.get(VALID_PASSWORD));
	}

	@Test
	public void testAddingProductToCart() {
		inventoryPage.clickAddToCart();
		assertEquals("1", inventoryPage.getCartItemCount());
		assertTrue(inventoryPage.isRemoveButtonVisible());
		inventoryPage.clickRemoveBtn();
	}

	@Test
	public void testRemovingProductToCart() {
		inventoryPage.clickAddToCart();
		assertEquals("1", inventoryPage.getCartItemCount());
		assertTrue(inventoryPage.isRemoveButtonVisible());
		inventoryPage.clickRemoveBtn();
		assertTrue(inventoryPage.cartHasItems() == 0);
	}

	@Test
	public void testSortProducts() {
		List<String> sortedList = inventoryPage.getSortedListOfInventoryNames();
		System.out.println("unsorted:" + inventoryPage.getInventoryList());
		System.out.println("sorted:" + sortedList);
		inventoryPage.selectFilterBasedOnNameZtoA();
		System.out.println("after filter select:" + inventoryPage.getInventoryList());
		assertEquals(sortedList, inventoryPage.getInventoryList());
	}

}
