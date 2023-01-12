package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.concurrent.ThreadFactory;

public class Day14_ExplicitWait extends TestBase {
    @Test
    public void explicitWaitTest(){
        //Create a class:ExplicitWait
        //Create a method: explicitWait
        //Go to https://the-internet.herokuapp.com/dynamic_loading/1
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        //When user clicks on the Start button
        driver.findElement(By.xpath("//*[.='Start']")).click();
        //Then verify the ‘Hello World!’ Shows up on the screen

        //This piece of code fails cause implicit wait is not able to handle the element
        //Solution: Try Explicit wait or Fluent Wait
//        WebElement helloElement = driver.findElement(By.id("finish"));
//        Assert.assertEquals("Hello World!",helloElement.getText());
//      1.Create webdriver wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       2.Use wait object to handle synchronization issue(wait issue)
      // waits for the xpath to be visible UP TO 10 Seconds
        //returns web element
        //If the element is not found withing 10 seconds, then throw TimeOutException
      WebElement helloElement =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//h4")));
       Assert.assertEquals("Hello World!",helloElement.getText());

    }
    @Test
    public void explicitWaitReusable() {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[.='Start']")).click();
        WebElement helloElement = waitForVisibility(By.xpath("//div[@id='finish']//h4"),10);
Assert.assertEquals("Hello World!",helloElement.getText());

    }
}
/*
Interview ALERT!!!
What are the selenium waits ?
-Implicit wait
-Explicit wait
-Fluent wait
2.Which one do you prefer ?
-I already use implicit wait in my driver class. But explicit wait works better. So I prefer explicit wait in some cases.
for example , when I work with dynamically loaded elements , then explicit wait works better for waiting and locating the elements
3.What might be the reason of test case failure ?
-Wrong locator type, wrong values ... DOUBLE CHECK THE LOCATOR
-Not synchronized. Timing issue... ADD MORE TIME OR USE EXPLICIT WAIT
           i)fx: Page is too slow, internet is slow, database is slow, hosting problem...
-Element may not be visible... PUT MORE TIMEOUT IT LOADING ISSUE, REVISE YOUR SCRIPT
-iframe...SWITCH TO IFRAME
-Multiple window... SWITCH TO CORRECT WINDOW USING WINDOW HANDLERS
-Alert... SWITCH, pop-ups...,cookies...
-Captcha code... SELENIUM CANNOT HANDLE CAPTCHA. NOTE:WITH JAVA+SELENIUM , WE CAN HANDLE LIMITED CAPTCHA
4.What do you do when your test case fails ?
-Read error message on the console . I see the error message and the line of the error. Then I can read which part of the
 code is fails . Error message gives me which class ,which line , what error...
-Check the locators, time issue , element visibility ,iframe , pop-ups...
-Manuel testing again to see my automation logic is correct. To also check the functional is working . Check you flow as well.
5.Can you use implicit wait and explicit wait together ?
-Yes,Implicit wait is in driver class. When implicit in not enough, then I can use explicit wait . I have reusable methods for
 explicit wait.
6.What is the difference between implicit and explicit wait ?
-Implicit is global(applies wait to the driver whenever drives is used), explicit is local(I have to call explicit wait every time for new element)
-Explicit wait works with the expected condition. We have to create Webdriver wait object. Has more option such as visibility ,clickibility
7)What is the difference between explicit and fluent wait?
-In fact they are similar, but there is a few differences:
 i)Fluent wait does polling and can ignore exceptions.


 */