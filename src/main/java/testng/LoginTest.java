package testng;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "csvData")
    public void loginTest(String username, String password) {

        driver.get("https://practicetestautomation.com/practice-test-login");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();

        // VALID CREDENTIAL CHECK
        if (username.equals("student") && password.equals("Password123")) {

            String successMessage =
                    driver.findElement(By.className("post-title")).getText();

            Assert.assertEquals(successMessage, "Logged In Successfully");

            driver.findElement(By.linkText("Log out")).click();
        }

        // INVALID CREDENTIAL CHECK
        else {
            String errorMessage =
                    driver.findElement(By.id("error")).getText();

            Assert.assertTrue(errorMessage.contains("Your username is invalid")
                    || errorMessage.contains("Your password is invalid"));
        }
    }

    @DataProvider(name = "csvData")
    public Object[][] getData() throws Exception {
        return CSVUtils.getCSVData(
                "");
    }
}
