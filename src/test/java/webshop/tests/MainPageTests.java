package webshop.tests;

import com.sun.tools.javac.Main;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import webshop.pages.LoginPage;
import webshop.pages.MainPage;
import webshop.pages.ProductDetailPage;

import java.util.List;

public class MainPageTests extends BaseTest {

    private LoginPage loginPage;
    private MainPage mainPage;


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
    public void testProductsAreSortedByName() {
        List<String> actualNames = mainPage.getAllProductNames();

        List<String> sortedNames = new java.util.ArrayList<>(actualNames);
        java.util.Collections.sort(sortedNames);

        Assertions.assertEquals(sortedNames, actualNames,
                "Expected products to be sorted by name");
    }


    @Test
    public void testUserCanViewProductDetails() {
        mainPage.openProductByName("Sauce Labs Backpack");

        ProductDetailPage detailsPage = new ProductDetailPage(driver, wait);

        Assertions.assertTrue(detailsPage.isTitleVisible());
        Assertions.assertTrue(detailsPage.isDescriptionVisible());
        Assertions.assertTrue(detailsPage.isPriceVisible());
        Assertions.assertTrue(detailsPage.isImageVisible());

        detailsPage.goBackToProducts();

        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"),
                "Expected to be back on product listing page");
    }



}
