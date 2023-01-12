package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class QWork02 {
    //Create a new class : GoogleSearchTest 
    //Create main method and complete the following task. 
    //When user goes to https://www.google.com/
    //Search for “porcelain teapot”
    //And print how many related results displayed on Google
  WebDriver driver;
    @Before
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    @Test
    public void t(){
        driver.get("https://www.google.com/");
        driver.findElement(By.xpath("//*[@maxlength='2048']")).sendKeys("porcelain teapot");
        driver.findElement(By.xpath("//*[@name='btnK']")).click();
       String x = driver.findElement(By.id("result-stats")).getText();
        System.out.println(x);

    }
}
