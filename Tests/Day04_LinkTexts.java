package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day04_LinkTexts {
   WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }
    /*
    Linktext and partialLinkText are case sensitive
     */
    @Test
    public void LMSpage(){
        driver.get("https://techproeducation.com/");
        //Click on LMS LOGIN
        driver.findElement(By.linkText("LMS LOGIN")).click();
        //Verify lms page is visible
        String expectedURL = "https://lms.techproeducation.com/";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(expectedURL,actualURL);
    }

    @Test
    public void LMSPagePartialLinkText(){
        driver.get("https://techproeducation.com/");
        //Click on LMS LOGIN
        driver.findElement(By.partialLinkText("LMS LOGIN")).click();
   //ALTERNATIVELY WE CAN LOCATE A CORE ELEMENT ON LMS PAGE AND CHECK IF THAT ELEMENT IS DISPLAYED IN THE PAGE
      WebElement loginElement =  driver.findElement(By.linkText("Login/Register"));
        Assert.assertTrue(loginElement.isDisplayed());


    }
    @Test
    public void xpathAbsolute(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
       driver.findElement(By.xpath("html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input")).sendKeys("admin");

        ///html/body/div/div/div/div/div/div[2]/div[2]/form/div/div/div[2]/input
    }
    @Test
    public void xpathRelative(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
  driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
  driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
  driver.findElement(By.xpath("//button[@type='submit']")).click();

    }

}
