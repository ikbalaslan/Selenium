package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class QWork04 extends TestBase {
    //When user goes to https://jqueryui.com/datepicker/
    //And select the next date of the current date
    //EG if today is August 30, 2022 -> select August 31, 2022
    @Test
    public void test(){
        driver.get("https://jqueryui.com/datepicker/ ");
        driver.switchTo().frame(0);
      WebElement element = driver.findElement(By.id("datepicker"));
        element.click();
       String currentDate = driver.findElement(By.xpath("//a[.='5']")).getText();
     WebElement afterCurrentDay = driver.findElement(By.xpath("//a[.='"+(Integer.valueOf(currentDate)+1)+"']"));

        clickByJS(afterCurrentDay);


    }

}
