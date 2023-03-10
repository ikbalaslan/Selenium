package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day09_Actions4 extends TestBase {
    @Test
    public void dragAndDropTest(){
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to destination(Drop here)
  //   Below elements are in the iframes so switch iframe first
       WebElement source = driver.findElement(By.id("draggable"));
       WebElement target = driver.findElement(By.id("droppable"));
       //user Actions class to move source into target
        Actions actions = new Actions(driver);
        actions.dragAndDrop(source,target).perform();
        driver.switchTo().parentFrame();

    }
    @Test
    public void clickAndHoldTest(){
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        //   Below elements are in the iframes so switch iframe first
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        //user Actions class to move source into target
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).
                moveToElement(target).
                build()
                .perform();//holding the source and moving into target

    }
    @Test
    public void moveByOffSetTest(){
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        //   Below elements are in the iframes so switch iframe first
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        //user Actions class to move source into target
        Actions actions = new Actions(driver);
        actions.clickAndHold(source).moveByOffset(156,21).build().perform();


    }
    @Test
    public void dragAndDropBy(){
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        //And user moves the target element(Drag me to my target) in to destination(Drop here)
        //   Below elements are in the iframes so switch iframe first
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        //user Actions class to move source into target
        Actions actions = new Actions(driver);
         actions.dragAndDropBy(source,160,30).perform(); // -> This is also works
    }

}
/*
When test fails:
1.Check locator
2.Wait issue or synchronization issue
3.Iframe -->> THIS WAS THE ISSUE
 */