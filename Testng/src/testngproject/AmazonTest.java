package testngproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.Set;

public class AmazonTest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {

            driver.get("https://www.amazon.in");

            // Wait for search box
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("twotabsearchtextbox")));

            // Search product
            driver.findElement(By.id("twotabsearchtextbox")).sendKeys("laptop");
            driver.findElement(By.id("nav-search-submit-button")).click();

            // Click first product
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("(//h2[contains(@class,'a-size-mini')]/a)[1]")))
                    .click();

            // Switch to new tab
            String mainWindow = driver.getWindowHandle();
            Set<String> allWindows = driver.getWindowHandles();

            for (String window : allWindows) {
                if (!window.equals(mainWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            // Add to cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("add-to-cart-button"))).click();

            // Go to cart
            wait.until(ExpectedConditions.elementToBeClickable(
                    By.id("nav-cart"))).click();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}