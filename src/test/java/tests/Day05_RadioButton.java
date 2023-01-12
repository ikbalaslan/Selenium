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

public class Day05_RadioButton {
    WebDriver driver;
    @Before
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons");
    }
    @Test
    public void radioTest(){
     WebElement redBox = driver.findElement(By.xpath("//input[@id='red']"));
        redBox.click();
        Assert.assertTrue(redBox.isSelected());
        WebElement footballBox = driver.findElement(By.xpath("//input[@id='football']"));
        footballBox.click();
        Assert.assertTrue(footballBox.isSelected());

    }

}
