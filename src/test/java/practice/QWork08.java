package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class QWork08 extends TestBase {
    //Create a class:Synchronization3. Create a method: synchronization1
    //Go to https://the-internet.herokuapp.com/dynamic_controls
    //Click on remove button
    //And verify the message is equal to “It's gone!”
    //Then click on Add button
    //And verify the message is equal to “It's back!”
    @Test
    public void sync(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[.='Remove']")).click();
       WebElement itsGone = waitForVisibility(driver.findElement(By.id("message")),10);
        Assert.assertEquals("It's gone!",itsGone.getText());
driver.findElement(By.xpath("//*[.='Add']")).click();
        WebElement itsBack = waitForVisibility(driver.findElement(By.id("message")),10);
        Assert.assertEquals("It's back!",itsBack.getText());
    }
}
