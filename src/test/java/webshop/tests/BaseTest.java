package webshop.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webshop.utils.EnvReader;

import java.time.Duration;

public abstract class BaseTest {

    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final String BASE_URL = EnvReader.get("BASE_URL", "https://www.saucedemo.com/");

    protected final String VALID_USERNAME = EnvReader.get("VALID_USERNAME", "standard_user");
    protected final String VALID_PASSWORD = EnvReader.get("VALID_PASSWORD", "secret_sauce");

    protected BaseTest() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void tearDown() {
        driver.quit();
    }

    protected void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    protected void type(By locator, String text) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        element.sendKeys(text);
    }
}
