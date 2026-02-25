package testngproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class LoginTest1 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(dataProvider = "csvData")
    public void loginTest(String username, String password) {

        driver.get("https://practicetestautomation.com/practice-test-login");

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("submit")).click();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @DataProvider(name="csvData")
    public Object[][] getCSVData() throws Exception {
        return CSVUtils.getCSVData(
            "C:\\Users\\hp\\eclipse-workspace1\\SelMavTng\\TestData\\LoginData.csv"
        );
    }
}
