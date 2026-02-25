package seleiumproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Seleiumwebsite {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/");

            // Login
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name")))
                    .sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();

            // Wait for products page
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_list")));

            // Scroll
            Actions a = new Actions(driver);
            for (int i = 0; i < 3; i++)
                a.sendKeys(Keys.PAGE_DOWN).perform();

            // Add to cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("add-to-cart-sauce-labs-backpack"))).click();

            // Print cart count
            System.out.println("Cart Items: " +
                    wait.until(ExpectedConditions.visibilityOfElementLocated(
                            By.className("shopping_cart_badge"))).getText());

            // Open cart
            driver.findElement(By.className("shopping_cart_link")).click();

        } finally {
            try { Thread.sleep(50000); } catch (Exception e) {}
            driver.quit();
        }
    }
}