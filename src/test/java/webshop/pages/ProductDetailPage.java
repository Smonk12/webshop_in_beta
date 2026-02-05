package webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailPage extends BasePage {

    private final By title = By.cssSelector("div[data-test='inventory-item-name']");
    private final By description = By.cssSelector("div[data-test='inventory-item-desc']");
    private final By price = By.cssSelector("div[data-test='inventory-item-price']");
    private final By image = By.cssSelector("img.inventory_details_img");
    private final By backButton = By.id("back-to-products");

    public ProductDetailPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public boolean isTitleVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(title)).isDisplayed();
    }

    public boolean isDescriptionVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(description)).isDisplayed();
    }

    public boolean isPriceVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(price)).isDisplayed();
    }

    public boolean isImageVisible() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(image)).isDisplayed();
    }

    public void goBackToProducts() {
        wait.until(ExpectedConditions.elementToBeClickable(backButton)).click();
    }
}
