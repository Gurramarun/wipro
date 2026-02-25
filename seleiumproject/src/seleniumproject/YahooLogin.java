package seleniumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class YahooLogin {

    public static void main(String[] args) {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(options);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            driver.get("https://login.yahoo.com/");

            // Enter email
            WebElement emailField = wait.until(
                    ExpectedConditions.elementToBeClickable(By.id("login-username")));
            emailField.sendKeys("arungurram70@yahoo.com");

            driver.findElement(By.id("login-signin")).click();

            // Enter password
            WebElement passwordField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("login-passwd")));
            passwordField.sendKeys("N4Gt43X4-HZ2fEz");

            driver.findElement(By.id("login-signin")).click();

            // Wait until home page loads (not mail)
            wait.until(ExpectedConditions.urlContains("yahoo.com"));

            // Wait for Mail icon/button on home page
            WebElement mailIcon = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//a[contains(@href,'mail.yahoo.com')]")));

            // Click Mail
            mailIcon.click();

            // Wait until Mail page loads
            wait.until(ExpectedConditions.urlContains("mail.yahoo.com"));

            System.out.println("Successfully navigated to Yahoo Mail!");

        } catch (Exception e) {
            System.out.println("Login failed or verification required.");
            e.printStackTrace();
        }

        // driver.quit();
    }
}
