package webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {

    // Checkout-step-one
    private final By firstNameField = By.id("first-name");
    private final By lastNameField = By.id("last-name");
    private final By zipPostalCodeField = By.id("postal-code");
    private final By continueButton = By.id("continue");

    // Checkout-step-two
    private final By itemPrice = By.cssSelector("div[data-test='inventory-item-price']");
    private final By totalPrice = By.cssSelector("div[data-test='subtotal-label']");
    private final By finishButton = By.id("finish");

    // Checkout-final
    private final By completionConfirmation = By.cssSelector("h2[data-test='complete-header']");
    private final By backToHomeButton = By.id("back-to-products");

    public CheckoutPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void fillCheckoutInformation(String firstName, String lastName, String zip) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(zipPostalCodeField).sendKeys(zip);
        driver.findElement(continueButton).click();
    }

    public void finishCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(finishButton)).click();
    }

    public boolean isCheckoutComplete() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completionConfirmation)).isDisplayed();
    }

    public String getConfirmationText() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(completionConfirmation)).getText();
    }

    public void goBackToHome() {
        wait.until(ExpectedConditions.elementToBeClickable(backToHomeButton)).click();
    }
}
