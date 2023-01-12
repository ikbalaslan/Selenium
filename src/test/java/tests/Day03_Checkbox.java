package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Day03_Checkbox {
  WebDriver driver;
    @Before
    public void SetUP(){
        //user goes to http://a.testaddressbook.com/sign_in
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        //IMPLICIT WAIT
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.get("https://testcenter.techproeducation.com/index.php?page=checkboxes");

    }
    @Test
    public void checkBox(){
        WebElement checkbox1 = driver.findElement(By.id("box1"));
        WebElement checkbox2 = driver.findElement(By.id("box2"));

       //Click on the checkbox 1 if it is not already selected
        if (!checkbox1.isSelected()){
            checkbox1.click();
        }
        //Then click on checkbox2 if box is not selected
        if (!checkbox2.isSelected()){
            checkbox2.click();
        }


    }
    @After
    public void tearDown(){
        driver.quit();
    }
}

/*
Create a class : CheckBox
Create test method and complete the following task. 
Go to https://testcenter.techproeducation.com/index.php?page=checkboxes  
Locate the elements of checkboxes 
Then click on checkbox1 if box is not selected 
Then click on checkbox2 if box is not selected
Homework: Then verify that checkbox1 is checked.
 */