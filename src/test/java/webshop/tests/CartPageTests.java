package webshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.pages.CartPage;
import webshop.pages.LoginPage;
import webshop.pages.MainPage;

public class CartPageTests extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private CartPage cartPage;

    @BeforeEach
    public void setUpTest() {
        loginPage = new LoginPage(driver, wait);
        driver.get(BASE_URL);
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);

        mainPage = new MainPage(driver, wait);
    }

    @AfterEach
    public void tearDownTest()
    {
        tearDown();
    }

    @Test
    public void testUserCanAddAndRemoveItems(){
        mainPage.openCart();
        cartPage = new CartPage(driver, wait);
        cartPage.clearCart();

        // Add item
        mainPage.addToCartByName("Sauce Labs Backpack");
        mainPage.openCart();

        // Check if item is in cart
        Assertions.assertTrue(
                cartPage.checkIfItemIsInCart("Sauce Labs Backpack"));

        // Remove item
        cartPage.removeItemFromCartByName("Sauce Labs Backpack");

        // Check if item is out of cart
        Assertions.assertFalse(cartPage.checkIfItemIsInCart("Sauce Labs Backpack"));
    }

    @Test
    public void testCartTotalPriceUpdates() {
        mainPage.openCart();
        cartPage = new CartPage(driver, wait);
        cartPage.clearCart();

        // Add first product
        mainPage.addToCartByName("Sauce Labs Backpack");
        mainPage.openCart();
        Assertions.assertEquals(29.99, cartPage.getCartTotal());
        cartPage.returnToMainPage();

        // Add second product
        mainPage.addToCartByName("Sauce Labs Bike Light");
        mainPage.openCart();
        Assertions.assertEquals(29.99 + 9.99, cartPage.getCartTotal());

        // Remove first product
        cartPage.removeItemFromCartByName("Sauce Labs Backpack");
        Assertions.assertEquals(9.99, cartPage.getCartTotal());

        // Final total check
        Assertions.assertEquals(9.99, cartPage.getCartTotal());
    }

}
