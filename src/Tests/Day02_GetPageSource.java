package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_GetPageSource {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // Test if amazon contains "Registry" on the homepage
        driver.get("https://www.amazon.com");
       String pageSource = driver.getPageSource();

        if (pageSource.contains("Registry")){
            System.out.println("Pass");
        }else{
            System.out.println("FAIL");
            System.out.println("Page source :" + pageSource);
            System.out.println("expected word  :" + "Registry");


        }
        driver.quit();
    }
}
