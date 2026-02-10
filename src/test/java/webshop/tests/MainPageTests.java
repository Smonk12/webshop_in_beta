package webshop.tests;

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

}
