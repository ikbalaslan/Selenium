package practices_with_group.Practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Q04 extends TestBase {
      /*
   Given
        Go to https://www.gmibank.com/
   When
        Hover over "Premium" Deposit Package
   And
        Click on "Book Now"
   Then
        Verify url contains "services"
    */
    @Test
    public void test() throws InterruptedException {
       driver.get("https://www.gmibank.com/");

        Actions actions = new Actions(driver);
     //This is 1st WAY
      /*  actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).
                build().perform();

       */
        //2nd Way to HoverDown
        WebElement target = driver.findElement(By.xpath("//h4[.='Premium']"));
        actions.moveToElement(target).perform();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Book Now")).click();
//   Verify url contains "services"
       String URL = driver.getCurrentUrl();
       assertTrue(URL.contains("services"));

    }

}
