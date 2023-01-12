package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class QWork06 extends TestBase {
    //When user goes to https://jqueryui.com/autocomplete/
    //And type Apple
    //Then select Applescript
    @Test
    public void test(){
        //When user goes to https://jqueryui.com/autocomplete/
        //And type Apple
        //Then select Applescript
        driver.get("https://jqueryui.com/autocomplete/");
        driver.switchTo().frame(0);
        driver.findElement(By.id("tags")).sendKeys("Apple");
        driver.findElement(By.id("ui-id-1")).click();


    }
}
