package webshop.tests;

import org.junit.jupiter.api.*;
import webshop.pages.LoginPage;

public class LoginPageTests extends BaseTest {

    private LoginPage loginPage;

    @BeforeEach
    public void setUpTest() {
        loginPage = new LoginPage(driver, wait);
        driver.get(BASE_URL);
    }

    @AfterEach
    public void tearDownTest() {
        tearDown();
    }

    @Test
    public void testValidLogin() {
        loginPage.loginAs(VALID_USERNAME, VALID_PASSWORD);
        Assertions.assertTrue(loginPage.isLoginSuccessful(), "Expected login to succeed with valid credentials");
    }

    @Test
    public void testInvalidLogin() {
        loginPage.loginAs("wrong_user", "wrong_pass");
        Assertions.assertTrue(loginPage.hasErrorMessage("Epic sadface: Username and password do not match any user in this service"),
                "Expected error message for invalid credentials");
    }

    @Test
    public void testEmptyUsername() {
        loginPage.loginAs("", VALID_PASSWORD);
        Assertions.assertTrue(loginPage.hasErrorMessage("Epic sadface: Username is required"),
                "Expected error message when username is empty");
    }

    @Test
    public void testEmptyPassword() {
        loginPage.loginAs(VALID_USERNAME, "");
        Assertions.assertTrue(loginPage.hasErrorMessage("Epic sadface: Password is required"),
                "Expected error message when password is empty");
    }
}
