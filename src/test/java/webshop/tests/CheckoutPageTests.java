package webshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.pages.CartPage;
import webshop.pages.CheckoutPage;
import webshop.pages.LoginPage;
import webshop.pages.MainPage;

public class CheckoutPageTests extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @BeforeEach
    public void setUpTest() {
        loginPage = new LoginPage(driver, wait);
        driver.get(BASE_URL);
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);

        mainPage = new MainPage(driver, wait);
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }

    @Test
    public void testCheckoutWithEmptyCartIsNotAllowed() {
        mainPage.openCart();
        cartPage = new CartPage(driver, wait);

        cartPage.clearCart();
        mainPage.openCart();

        cartPage.clickCheckout();

        Assertions.assertTrue(
                driver.getCurrentUrl().contains("cart"),
                "User should not be able to proceed to checkout with empty cart"
        );
    }

    @Test
    public void testSuccessfulCheckout() {
        mainPage.addToCartByName("Sauce Labs Backpack");

        mainPage.openCart();
        cartPage = new CartPage(driver, wait);

        cartPage.clickCheckout();

        checkoutPage = new CheckoutPage(driver, wait);
        checkoutPage.fillCheckoutInformation("John", "Doe", "12345");

        checkoutPage.finishCheckout();

        Assertions.assertTrue(checkoutPage.isCheckoutComplete(), "Checkout should be completed");

        Assertions.assertTrue(
                checkoutPage.getConfirmationText().toLowerCase().contains("thank"),
                "Confirmation message should be visible"
        );
    }
}
