package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;

public class Day08_Actions1 extends TestBase {
    @Test
    public void rightClickTest() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //        When use Right clicks on the box
        Actions action = new Actions(driver);
        //        2. locating the element that I want to right click
        WebElement box = driver.findElement(By.id("hot-spot"));
        //        3. use actions object and appropriate function to right click
        action.contextClick(box).perform();
        //        Then verify the alert message is “You selected a context menu”
       String alert = driver.switchTo().alert().getText();
        Assert.assertTrue(alert.contains("You selected a context menu"));
      Thread.sleep(5000);
        //        Then accept the alert
        driver.switchTo().alert().accept();

    }
}
