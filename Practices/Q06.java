package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.awt.*;

public class Q06 extends TestBase {
     /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click 'Signup / Login' button
    5. Fill all details in Signup and create account
    6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
    7. Verify ' Logged in as username' at top
    8. Add products to cart
    9. Click 'Cart' button
    10. Verify that cart page is displayed
    11. Click Proceed To Checkout
    12. Verify Address Details and Review Your Order
    13. Enter description in comment text area and click 'Place Order'
    14. Enter payment details: Name on Card, Card Number, CVC, Expiration date
    15. Click 'Pay and Confirm Order' button
    16. Verify success message 'Your order has been placed successfully!'
    17. Click 'Delete Account' button
    18. Verify 'ACCOUNT DELETED!' and click 'Continue' button
     */

    @Test
    public void test() throws InterruptedException, AWTException {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
       WebElement logo =  driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(logo.isDisplayed());
        //4. Click 'Signup / Login' button
        driver.findElement(By.xpath("//*[@href='/login']")).click();
        //5. Fill all details in Signup and create account
        driver.findElement(By.xpath("//input[@data-qa='signup-name']")).sendKeys("ali");
        driver.findElement(By.xpath("//input[@data-qa='signup-email']")).sendKeys("aslaaaaassan@gmail.com");
        driver.findElement(By.xpath("//button[@data-qa='signup-button']")).click();

        //Second part
        driver.findElement(By.id("password")).sendKeys("aslan");
        WebElement dropdown = driver.findElement(By.id("days"));
        WebElement dropdown2 = driver.findElement(By.id("months"));
        WebElement dropdown3 = driver.findElement(By.id("years"));
        Select select = new Select(dropdown);
        Select select1 = new Select(dropdown2);
        Select select2 = new Select(dropdown3);

        select.selectByVisibleText("1");
        select1.selectByVisibleText("January");
        select2.selectByVisibleText("2021");



       // driver.findElement(By.id("newsletter")).click();
       // driver.findElement(By.id("optin")).click();

//        Robot robot = new Robot();
//        robot.mouseWheel(10);

        driver.findElement(By.xpath("//input[@data-qa='first_name']")).sendKeys("Emily");
        driver.findElement(By.xpath("//input[@data-qa='last_name']")).sendKeys("Emily Saly");
        driver.findElement(By.xpath("//input[@data-qa='company']")).sendKeys("EBB");
        driver.findElement(By.xpath("//input[@data-qa='address']")).sendKeys("Haraldsgata 2A");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("Karmsund");
        driver.findElement(By.xpath("//input[@data-qa='address2']")).sendKeys("Karmsund");

        WebElement country = driver.findElement(By.id("country"));
        Select select4 = new Select(country);
        select4.selectByValue("Canada");
        WebElement state = driver.findElement(By.xpath("//*[@data-qa='state']"));
        Actions actions = new Actions(driver);
        actions.click(state).sendKeys("asla")
                .sendKeys(Keys.TAB)
                .sendKeys("asam")
                .sendKeys(Keys.TAB)
                .sendKeys("bom")
                .sendKeys(Keys.TAB)
                .sendKeys("asa").build().perform();

        driver.findElement(By.xpath("//*[.='Create Account']")).submit();


        //  6. Verify 'ACCOUNT CREATED!' and click 'Continue' button
       Assert.assertTrue(driver.findElement(By.xpath("(//b)")).getText().contains("ACCOUNT CREATED!"));


       driver.findElement(By.xpath("//a[@data-qa='continue-button']")).click();
        //7. Verify ' Logged in as username' at top
     Thread.sleep(2000);
      WebElement close =  driver.findElement(By.xpath("//*[@d='M38 12.83L35.17 10 24 21.17 12.83 10 10 12.83 21.17 24 10 35.17 12.83 38 24 26.83 35.17 38 38 35.17 26.83 24z']"));
      Actions actions1 = new Actions(driver);
      actions1.click(close).perform();


//       driver.findElement(By.xpath("//"))
// fill="#5F6368"
    }
}
