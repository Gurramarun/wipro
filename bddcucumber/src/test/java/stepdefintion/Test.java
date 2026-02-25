package stepdefintion;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;

public class Test {

    WebDriver driver;

    @Given("I launch the browser")
    public void i_launch_the_browser() {
        System.out.println("Launching browser...");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @When("I open Google website")
    public void i_open_google_website() {
        System.out.println("Opening Google...");
        driver.get("https://www.google.com");
    }

    @Then("I should see Google homepage")
    public void i_should_see_google_homepage() {

        String title = driver.getTitle();
        System.out.println("Page title is: " + title);

        Assert.assertTrue(title.toLowerCase().contains("google"),
                "Google page not opened");

        driver.quit();
        System.out.println("Test completed successfully");
    }
}