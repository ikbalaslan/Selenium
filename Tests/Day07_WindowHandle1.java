package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.util.Set;

public class Day07_WindowHandle1 extends TestBase {

@Test
    public void windowHandleTest() throws InterruptedException {

    //Given user is on the https://the-internet.herokuapp.com/windows
    driver.get("https://the-internet.herokuapp.com/windows");
    //Then user verifies the text : “Opening a new window”
    String window1Text = driver.findElement(By.xpath("//h3")).getText();
    Assert.assertEquals("Opening a new window",window1Text);
    //Then user verifies the title of the page is “The Internet”
    String title = driver.getTitle();
    Assert.assertEquals("The Internet",title);
    //Getting the window 1 handle(Unique page id)
    String window1Handle = driver.getWindowHandle();//Returns the current window id
    System.out.println(window1Handle);
    //When user clicks on the “Click Here” button
      driver.findElement(By.linkText("Click Here")).click();
    //Then user verifies the new window title is “New Window”
    //WE DO TESTING IN A NEW WINDOW , SO WE MUST SWITCH TO THAT WINDOW
    //AS OF NOW 2 WINDOWS OPEN. USE getWindowHandles() to  GET BOTH IDs
    Set<String> allWindowHandles = driver.getWindowHandles();
    System.out.println(allWindowHandles);
    for (String eachHandle : allWindowHandles){
        if (!eachHandle.equals(window1Handle)){
            driver.switchTo().window(eachHandle);
        }
    }

     //AT THIS POINT DRIVER SWITCHED TO WINDOW2
     String window2Handle = driver.getWindowHandle();//WINDOW 2 ID
    //Then user verifies the text:  “New Window”
    String window2Text = driver.findElement(By.xpath("//h3")).getText();
    Assert.assertEquals("New Window",window2Text);
Thread.sleep(3000);
    //When user goes back to the previous window and then verifies the title : “The Internet”
driver.switchTo().window(window1Handle);//Switch's to window 1
    Thread.sleep(3000);
   String title1 = driver.getTitle();
   Assert.assertEquals("The Internet",title1);
   Thread.sleep(3000);
   //Switch back to window 2
    driver.switchTo().window(window2Handle);
    Thread.sleep(3000);
    //Switch back to window 1
    driver.switchTo().window(window1Handle);



}


}
