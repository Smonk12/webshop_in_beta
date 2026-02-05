package webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends BasePage {

    private final By checkoutButton = By.id("checkout-button");
    private final By cartItems = By.cssSelector("div[data-test='inventory-item']");
    private final By itemName = By.cssSelector("div[data-test='inventory-item-name']");
    private final By continueShoppingButton =  By.id("continue-shopping");


    public CartPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void removeItemFromCartByName(String itemName){
        String formattedName = itemName.replace(" ", "-").toLowerCase();
        String removeButtonId = "remove-" + formattedName;

        By removeButton = By.id(removeButtonId);
        wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
    }

    public void clearCart() {
        List<WebElement> items = driver.findElements(cartItems);

        if(items.size()>0)
        {
            for (WebElement item : items) {
                String name = item.findElement(itemName).getText();
                removeItemFromCartByName(name);
            }
        }
        wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton)).click();
    }

    public boolean checkIfItemIsInCart(String name) {
        List<WebElement> items = driver.findElements(cartItems);

        for (WebElement item : items) {
            String currentName = item.findElement(itemName).getText();
            if (currentName.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public double getCartTotal() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(cartItems));
        double total = 0.0;
        List<WebElement> items = driver.findElements(cartItems);

        for (WebElement item : items) {
            String priceText = item.findElement(By.cssSelector("[data-test='inventory-item-price']")).getText();
            priceText = priceText.replace("$", "");
            total += Double.parseDouble(priceText);
        }
        return total;
    }





}
