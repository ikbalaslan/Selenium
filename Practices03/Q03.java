package practices_with_group.Practice04;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q03 extends TestBase {
    @Test
    public void test(){
       driver.get("https://testpages.herokuapp.com/styled/events/javascript-events.html");

        driver.findElement(By.id("onblur")).click();
        driver.findElement(By.xpath("//h1")).click();

        driver.findElement(By.id("onclick")).click();

        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(By.id("oncontextmenu"))).perform();

        actions.doubleClick(driver.findElement(By.id("ondoubleclick"))).perform();

        driver.findElement(By.id("onfocus")).click();

        driver.findElement(By.id("onkeydown")).click();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        driver.findElement(By.id("onkeyup")).click();
        actions.sendKeys(Keys.ARROW_UP).perform();

    driver.findElement(By.id("onkeypress")).click();

        actions.sendKeys(Keys.ENTER).perform();

        driver.findElement(By.id("onmouseover")).click();

        driver.findElement(By.id("onmouseleave")).click();
        actions.moveToElement(driver.findElement(By.id("onfocus"))).perform();

        driver.findElement(By.id("onmousedown")).click();
    }
}
