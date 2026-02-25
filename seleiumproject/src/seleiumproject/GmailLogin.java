package seleiumproject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class GmailLogin {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            // Open Gmail login page
            driver.get("https://accounts.google.com/");

            // Enter Email
            WebElement email = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.id("identifierId")));
            email.sendKeys("gurramarun1911@gmail.com");

            driver.findElement(By.id("identifierNext")).click();

            // Wait for Password field
            WebElement password = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.name("Passwd")));
            password.sendKeys("your_test_password");

            driver.findElement(By.id("passwordNext")).click();

            // Wait for Gmail Inbox
            wait.until(ExpectedConditions.urlContains("mail.google.com"));

            System.out.println("Login Attempted");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // driver.quit();
    }
}
