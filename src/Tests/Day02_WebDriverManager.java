package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_WebDriverManager {
    public static void main(String[] args) {
        // System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
       //We no longer need to use System.setProperty. We can use WebDriverManager Api
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        
    }
}