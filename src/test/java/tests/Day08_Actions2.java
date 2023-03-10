package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions2 extends TestBase {
    @Test
    public void hoverOverTest(){
        //        Given user is on the https://www.amazon.com/
                   driver.get("https://www.amazon.com");
        //        When use click on “Account” link
        WebElement accountList =driver.findElement(By.id("nav-link-accountList"));
        Actions actions = new Actions(driver);
        actions.moveToElement(accountList).perform();
        driver.findElement(By.xpath("//span[.='Account']")).click();
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Your Account"));

                   //        Then verify the page title contains “Your Account”
    }
}
