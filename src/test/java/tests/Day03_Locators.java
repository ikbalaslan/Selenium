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

import static org.junit.Assert.assertEquals;

public class Day03_Locators {
 static WebDriver driver;
 /*
  * How many locators are there?
  * ---8 locator
  *  * What are they?
  * ---id, name, className, linkText, tagName, partialLinkText, xpath, css
  * Which one do you prefer ? Why ?
  * -First If there is an ID i use id, cause id is unique and faster
  * -If there is no id then i use name if there is a unique name
  * -I also sometime create dynamic xpath. Because some elements do not have stable attributes like id and name. And I can write xpath for any element.
  * -I sometimes even use css selector instead of xpath. But i personally use xpath more than css.
  * What is difference between absolute xpath and relative xpath?
  * Absolute xpath we start from the parent and go child elements one by one
  * -Absolute xpath use /
  *-Absolute xpath may easily be broken when a new element is added on the page
  *-For this reason we should never use absolute xpath. In fact, my team don't let QA's use absolute xpath.
  *--Relative xpath we don't start from parent and go child one by one. We go straight to the element
  * --Relative xpath use //
  *  --Relative xpath is very reliable It doesn't easy brake, because absolute xpath doesn't dependent on other element
  *  --I use absolute xpath in my framework when to locate the elements
  * -First xpath and css are similar. Both are helpful and there are different ways to create xpath or css
  * -Syntax is a little different.
  * --in xpath we use // and @, but in css we don't
  * --css is a little faster than xpath(way less than 1 second). xpath does navigation in the html that takes a little bit time
  *  --there are more ways to write xpath. For example, dynamic xpath has contains, starts-with, ends-with functions

  *   */
    @Before
    public void SetUP(){
     //user goes to http://a.testaddressbook.com/sign_in
     WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
     driver.manage().window().maximize();
     //IMPLICIT WAIT
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
     driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

 }


    @Test
    public void logInTest(){


        //Locating username and typing the username.
       WebElement username = driver.findElement(By.name("username"));
         username.sendKeys("admin");
        //Locating password and typing the password.
         WebElement password = driver.findElement(By.name("password"));
         password.sendKeys("admin123");
        //        Locating the button and clicking
        WebElement button = driver.findElement(By.tagName("button"));
        button.click();

        //        Verifying the log in is successful
//        1. We can use default page URL to do assertion
//        2. Or we can locate a CORE ELEMENT on the default page to assert is that element is displayed on the page
//        Login Page : https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
//        Default Page : https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index

        String actualURL = driver.getCurrentUrl();
        String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        assertEquals("LOGIN FAILED",expectedURL,actualURL);//If login successful PASS, if not FAIL and print message LOGIN FAILED"
//      NOTE : We do not need to use containers. We can use method chain in selenium
//        driver.findElement(By.name("username")).sendKeys("Admin");
//        driver.findElement(By.name("password")).sendKeys("admin123");
//        driver.findElement(By.tagName("button")).click();

    }
    @After
    public void close(){
        driver.quit();
    }
}

