package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class QWork09 extends TestBase {
      //Create a class:Synchronization4. Create a method: isEnabled
    //Go to https://the-internet.herokuapp.com/dynamic_controls
    //Click enable Button
    //And verify the message is equal to “It's enabled!”
    //And verify the textbox is enabled (I can type in the box)
    //And click on Disable button
    //And verify the message is equal to “It's disabled!”
    //And verify the textbox is disabled (I cannot type in the box)
    //NOTE: .isEnabled(); is used to check if an element is enabled or not
    @Test
    public void sync4(){
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//*[.='Enable']")).click();
        WebElement enable = waitForClickablility(driver.findElement(By.xpath("//input[@type='text']")),10);
        Assert.assertTrue(enable.isEnabled());

        driver.findElement(By.xpath("//*[.='Disable']")).click();
      WebElement disableText = waitForVisibility(driver.findElement(By.id("message")),10);
        Assert.assertTrue(disableText.isDisplayed());
        WebElement textBox1 = driver.findElement(By.xpath("//form[@id='input-example']//input"));
        Assert.assertFalse(textBox1.isEnabled());


    }
}
