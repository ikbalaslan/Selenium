package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.sahibinden.com/");
    }
    @Test
    public void q1() throws InterruptedException {
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


     WebElement sear = driver.findElement(By.xpath("//*[@id='i21']")); ////*[@id='i9']
        sear.click();
        sear.click();
//
//        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchText']"));
//
//       searchBox.sendKeys("Audi");
//
//       WebElement search = driver.findElement(By.xpath("//button[@type='submit']"));////button[@type='submit']
//
//        search.click();
    }
}
