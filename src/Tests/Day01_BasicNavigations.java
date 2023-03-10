package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day01_BasicNavigations {
    public static void main(String[] args) {
        //Step 1: Set up
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        //Step 2: Create
        WebDriver driver = new ChromeDriver();
        //Step 3: Write Test Scripts
        //Maximize the window
        driver.manage().window().maximize();
        //Open google home page https://www.walmart.com
        driver.get("https://www.walmart.com");
        //On the same class Navigate to amazon home page https://www.amazon.com
        //Option 1
        //driver.get("https://www.amazon.com"); WORKS
        //Option 2
        driver.navigate().to("https://www.amazon.com");
        //Navigate back to walmart
        driver.navigate().back();
        //Navigate forward to amazon
        driver.navigate().forward();
        //Refresh the page
        driver.navigate().refresh();
        //Close the browser
        //driver.close();
        driver.quit();




        







    }
}
