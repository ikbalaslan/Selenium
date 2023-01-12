package practices_with_group.Practice02;



import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q02 extends TestBase {
    /*
    Given
        Go to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    When
        Click on the "Animals and Nature" emoji
    And
        Click all the "Animals and Nature"  emoji elements
    And
        Fill the form
    And
        Press the apply button
    Then
        Verify "code" element is displayed
     */
    @Test
     public void q02(){
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
   // Click on the "Animals and Nature" emoji
     WebElement emojisIframe = driver.findElement(By.id("emoojis"));
     driver.switchTo().frame(emojisIframe);
        //Second way of switching I frame
        //  driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();
      //   Click all the "Animals and Nature"  emoji elements
        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        for (WebElement w : emojis){
            w.click();
        }
        //Using lambda is recommended
       // emojis.stream().forEach(t->t.click());

        // Fill the form
        driver.switchTo().parentFrame();
        List<WebElement> inputs = driver.findElements(By.xpath("//input")); //inputs
        List<String> words = new ArrayList<>(Arrays.asList("123","123","1","1","1","1","1","1","1","1","1"));
int counter = 0;
        for (WebElement w : inputs){
            w.sendKeys(words.get(counter));
            counter++;
        }
        // Press the apply button
        driver.findElement(By.id("send")).click();
        //Verify "code" element is displayed
     WebElement code =   driver.findElement(By.id("code"));
        Assert.assertTrue(code.isDisplayed());





    }
}
