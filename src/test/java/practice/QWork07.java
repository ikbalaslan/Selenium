package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class QWork07 extends TestBase {
    //Create a class:Synchronization2.
    //Create a method: synchronization2
    //Go to https://the-internet.herokuapp.com/dynamic_loading/2
    //When user clicks on the Start button
    //Then verify the ‘Hello World!’ Shows up on the screen
    @Test
    public void synchronization2(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        driver.findElement(By.xpath("//div[@id='start']//button")).click();
       WebElement helloWorld = waitForVisibility(driver.findElement(By.id("finish")),10);
        Assert.assertTrue(helloWorld.getText().contains("Hello World!"));
    }
}
