package practices_with_group.Practice01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01 {
   static WebDriver driver;
    public static void main(String[] args) throws InterruptedException {
        // ...Practice 1...
        // Set Driver Path
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        // Create chrome driver object
        // Maximize the window
        // Open google home page https://www.google.com/
        driver.get("https://www.google.com/");
        Thread.sleep(1000);
        // Navigate to techproeducation home page https://techproeducation.com/
        driver.navigate().to("https://techproeducation.com/");
        Thread.sleep(1000);
        // Navigate back to google
        driver.navigate().back();
        Thread.sleep(1000);
        // Navigate forward to techproeducation
        driver.navigate().forward();
        // Refresh the page
        driver.navigate().refresh();
        // Close/Quit the browser
        driver.quit();
        // And last step : print "ALL OK" on console
        System.out.println("All ok");
    }
}
