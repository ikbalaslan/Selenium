package tests;

import org.junit.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Day08_Actions3 extends TestBase {
@Test
    public void pageDownTest() throws InterruptedException {
    driver.get("https://www.techproeducation.com");
    Actions actions = new Actions(driver);
//        sendKeys(Keys.PAGE_DOWN) is used to scroll the page
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    Thread.sleep(2000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    Thread.sleep(2000);
    actions.sendKeys(Keys.PAGE_DOWN).perform();
    Thread.sleep(2000);
    //        CHAIN METHOD. SCROLLING 3 TIMES
//        .build() is recommended to be used when we chain multiple commends to make sure the connection is strong.
//        .perform() is used when there is single or multiple commends to execute the action

    actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
    //        ARROW DOWN = scroll down a little bit. This scrolls less than page down
actions.sendKeys(Keys.ARROW_DOWN).perform();
    //      PAGE_UP = scroll up
    actions.sendKeys(Keys.PAGE_UP).sendKeys(Keys.PAGE_UP).build().perform();
    //      ARROW_UP = scroll up a little bit. This scrolls less than page up
actions.sendKeys(Keys.ARROW_UP).perform();



}




}
