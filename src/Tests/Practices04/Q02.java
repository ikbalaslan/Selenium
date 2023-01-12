package practices_with_group.Practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q02 extends TestBase {
    ///*
    //    Given
    //        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    //    When
    //        Click on Ajax Loader
    //    And
    //        Click on "Click Me!" button
    //    Then
    //        Assert that button is clicked
    //    And
    //        Take screenshot after each step
    //     */
    @Test
    public void test() {
        //        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");
        Actions actions = new Actions(driver);

        clickByJS(driver.findElement(By.xpath("//a[.='CLICK ME!']")));

        WebElement click = waitForClickablility(driver.findElement(By.xpath("//p[.='CLICK ME!']")), 10);
        click.click();

       WebElement close = waitForClickablility(driver.findElement(By.xpath("//button[.='Close']")),10);
        close.click();


    }
}
