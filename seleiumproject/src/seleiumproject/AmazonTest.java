package seleiumproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class AmazonTest {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            driver.manage().window().maximize();
            driver.get("https://www.amazon.in/");

            System.out.println("Please search product manually...");
            
            // Give time to search manually
            Thread.sleep(15000);   // 15 seconds for manual search

            // Wait until search results appear
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.cssSelector("div.s-search-results")));

            // Scroll
            Actions a = new Actions(driver);
            for (int i = 0; i < 5; i++)
                a.sendKeys(Keys.PAGE_DOWN).perform();

            // Click first product
            WebElement firstProduct = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.cssSelector("div.s-search-results h2 a"))
            );
            firstProduct.click();

            // Switch to new tab
            for (String tab : driver.getWindowHandles())
                driver.switchTo().window(tab);

            // Add to cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("add-to-cart-button"))).click();

            System.out.println("Product added to cart successfully!");

        } finally {
            Thread.sleep(70000);
            driver.quit();
        }
    }
}
