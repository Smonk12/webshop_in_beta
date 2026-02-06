package webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    private final By burgerMenu = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");
    private final By inventoryItems = By.cssSelector("div[data-test='inventory-item']");
    private final By itemName = By.cssSelector("div[data-test='inventory-item-name']");
    private final By addToCartButton = By.cssSelector("button");
    private final By shoppingCartButton = By.cssSelector("a[data-test='shopping-cart-link']");

    public void logout() {
        wait.until(ExpectedConditions.elementToBeClickable(burgerMenu)).click();
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }

    public List<String> getAllProductNames() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItems));

        List<WebElement> items = driver.findElements(inventoryItems);
        List<String> names = new ArrayList<>();

        for (WebElement item : items) {
            names.add(item.findElement(itemName).getText());
        }

        return names;
    }


    public void openProductByName(String name) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItems));

        List<WebElement> items = driver.findElements(inventoryItems);

        for (WebElement item : items) {
            String currentName = item.findElement(itemName).getText();

            if (currentName.equals(name)) {
                wait.until(ExpectedConditions.elementToBeClickable(item.findElement(itemName))).click();
                return;
            }
        }

        throw new RuntimeException("Product not found: " + name);
    }


    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartButton)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("continue-shopping")));
    }

    public void addToCartByName(String name) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(inventoryItems));

        List<WebElement> items = driver.findElements(inventoryItems);
        for (WebElement item : items) {
            String currentName = item.findElement(itemName).getText();
            if (currentName.equals(name)) {
                WebElement button = item.findElement(addToCartButton);
                wait.until(ExpectedConditions.elementToBeClickable(button)).click();
                return;
            }
        }

        throw new RuntimeException("Item not found: " + name);
    }






}
