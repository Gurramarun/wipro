package seleiumproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class InstagramLogin {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            // Open Instagram
            driver.get("https://www.instagram.com/");

            // Wait for username field
            WebElement username = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.name("username")));
            username.sendKeys("gurramarun199@gmail.com");

            // Enter password
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("ArunGurram1911");

            // Click login button
            driver.findElement(By.xpath("//button[@type='submit']")).click();

            // Wait for homepage (URL change)
            wait.until(ExpectedConditions.urlContains("instagram.com"));

            System.out.println("Login Attempted");

        } catch (Exception e) {
            e.printStackTrace();
        }

        // driver.quit();
    }
}
