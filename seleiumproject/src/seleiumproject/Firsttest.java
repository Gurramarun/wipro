package seleiumproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Firsttest {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        try {
            driver.manage().window().maximize();
            driver.get("https://www.google.com");

            System.out.println("Title: " + driver.getTitle());
        } 
        finally {
            driver.quit();   // Properly closes all browser windows
        }
    }
}
