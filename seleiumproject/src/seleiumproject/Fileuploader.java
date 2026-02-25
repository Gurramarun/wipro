package seleiumproject;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class Fileuploader {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.manage().window().maximize();
            driver.get("https://the-internet.herokuapp.com/upload");

            // File path (Change this to your system file path)
            String filePath = "C:\\Users\\Arun\\Desktop\\testfile.txt";

            // Upload file
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id("file-upload")))
                    .sendKeys(filePath);

            // Click Upload button
            driver.findElement(By.id("file-submit")).click();

            // Verify upload success
            WebElement uploadedText = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.tagName("h3"))
            );

            System.out.println("Upload Status: " + uploadedText.getText());

        } finally {
            try { Thread.sleep(50000); } catch (Exception e) {}
            driver.quit();
        }
    }
}
