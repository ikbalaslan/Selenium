package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class QWork05 extends TestBase {
    //When user goes to https://jqueryui.com/toggle/
    //Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    //Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    //Then click on Run Effect button
    //Then print the text and verify it is empty.
    //Eg: System.out.println(element); -> NO TEXT
    //Then click on Run Effect button one more time
    //Print the text that should be : Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    //Eg: System.out.println(element); -> Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.
    //You can use hard wait if needed.
    @Test
    public void test(){
        driver.get("https://jqueryui.com/toggle/ ");
        driver.switchTo().frame(0);
       WebElement element = driver.findElement(By.xpath("//*[@id='effect']//p"));
       String text = element.getText();
        Assert.assertEquals("Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.",text);
       driver.findElement(By.id("button")).click();
wait_for(2);
WebElement element1 = driver.findElement(By.xpath("//*[@id='effect']//p"));
String text1 = element1.getText();
Assert.assertEquals("",text1);
        driver.findElement(By.id("button")).click();
        wait_for(2);
        WebElement element2 = driver.findElement(By.xpath("//*[@id='effect']//p"));
        String text2 = element2.getText();
        Assert.assertEquals("Etiam libero neque, luctus a, eleifend nec, semper at, lorem. Sed pede. Nulla lorem metus, adipiscing ut, luctus sed, hendrerit vitae, mi.",text2);


    }
}
