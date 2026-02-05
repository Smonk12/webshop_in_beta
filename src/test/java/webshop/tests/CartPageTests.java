package webshop.tests;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webshop.pages.CartPage;
import webshop.pages.LoginPage;
import webshop.pages.MainPage;

import java.time.Duration;

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
    public void testUserCanAddAndRemoveItems() throws InterruptedException {
        mainPage.openCart();
        cartPage = new CartPage(driver, wait);
        cartPage.clearCart();

        mainPage.addToCartByName("Sauce Labs Backpack");
        mainPage.openCart();


        Assertions.assertTrue(
                cartPage.checkIfItemIsInCart("Sauce Labs Backpack"));

        cartPage.removeItemFromCartByName("Sauce Labs Backpack");

        Assertions.assertFalse(cartPage.checkIfItemIsInCart("Sauce Labs Backpack"));
    }

    @Test
    public void testCartTotalPriceUpdates() {
        mainPage.openCart();
        cartPage = new CartPage(driver, wait);
        cartPage.clearCart(); // Start with empty cart

        // Step 1: Add first product
        mainPage.addToCartByName("Sauce Labs Backpack");
        mainPage.openCart();
        Assertions.assertEquals(29.99, cartPage.getCartTotal());

        // Step 2: Add second product
        cartPage.clearCart(); // Optional: if you want to isolate, but you can just add another item
        mainPage.addToCartByName("Sauce Labs Bike Light");
        mainPage.openCart();
        Assertions.assertEquals(29.99 + 9.99, cartPage.getCartTotal());

        // Step 3: Remove first product
        cartPage.removeItemFromCartByName("Sauce Labs Backpack");
        Assertions.assertEquals(9.99, cartPage.getCartTotal());

        // Step 4: Final total check
        Assertions.assertEquals(9.99, cartPage.getCartTotal());
    }

}
