package webshop.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.pages.LoginPage;
import webshop.pages.MainPage;
import webshop.pages.ProductDetailPage;

public class ProductDetailPageTests extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;
    private ProductDetailPage productDetailPage;

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
    public void testUserCanViewProductDetails() {
        mainPage.openProductByName("Sauce Labs Backpack");

        productDetailPage = new ProductDetailPage(driver, wait);

        Assertions.assertTrue(productDetailPage.isTitleVisible());
        Assertions.assertTrue(productDetailPage.isDescriptionVisible());
        Assertions.assertTrue(productDetailPage.isPriceVisible());
        Assertions.assertTrue(productDetailPage.isImageVisible());

        productDetailPage.goBackToProducts();

        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Expected to be back on product listing page");
    }

}
