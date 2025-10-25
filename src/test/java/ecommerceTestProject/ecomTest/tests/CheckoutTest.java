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
public class CheckoutTest extends BaseTest{
	@BeforeEach
	public void navigate() {
		driver.get(HOMEPAGE);
		loginPage.loginAs(PropertiesFileReader.get(VALID_USERNAME), PropertiesFileReader.get(VALID_PASSWORD));
	}
	
	@Test
	public void testCheckoutProductDetails() {
		inventoryPage.clickAddToCart();
		inventoryPage.clickCartLink();
		cartPage.clickCheckoutBtn();
		assertEquals(CHECKOUT, cartPage.getCurrentUrl());
		checkoutPage.enterFirstName("Jane");
		checkoutPage.enterLastName("George");
		checkoutPage.enterPostalCode("18888");
		checkoutPage.clickContinue();
		assertEquals(CHECKOUT2, checkoutPage.getCurrentUrl());
		assertEquals("Sauce Labs Backpack", checkoutPage2.getInventoryName());
		assertEquals("1", checkoutPage2.getCartQuantity());
		checkoutPage2.goBack();
		checkoutPage.goBack();
		cartPage.clickRemoveBtn();
	}
	
	@Test
	public void testCheckoutSuccess() {
		inventoryPage.clickAddToCart();
		inventoryPage.clickCartLink();
		cartPage.clickCheckoutBtn();
		assertEquals(CHECKOUT, cartPage.getCurrentUrl());
		checkoutPage.enterFirstName("Jane");
		checkoutPage.enterLastName("George");
		checkoutPage.enterPostalCode("18888");
		checkoutPage.clickContinue();
		assertEquals(CHECKOUT2, checkoutPage.getCurrentUrl());
		assertEquals("Sauce Labs Backpack", checkoutPage2.getInventoryName());
		assertEquals("1", checkoutPage2.getCartQuantity());
		checkoutPage2.clickFinish();
		assertEquals(CHECKOUT_COMPLETE, checkoutPage2.getCurrentUrl());
		assertEquals("Thank you for your order!", checkoutCompletePage.getOrderSucccessMessage());
		assertEquals("Your order has been dispatched, and will arrive just as fast as the pony can get there!", checkoutCompletePage.getTextMessage());
	}
	
	@AfterEach
	public void logout() throws InterruptedException {
		navigationSideBar.clickLogout();
	}

}
