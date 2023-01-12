package practices_with_group.Practice03;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class Q04 extends TestBase {
    /*
    Given
      Go to  https://www.saucedemo.com/
    When
      Enter the username  as "standard_user"
    And
      Enter the password as   "secret_sauce"
    And
      Click on login button
    And
      Order products by "Price (low to high)"
    Then
      Assert that last product costs $49.99, first product costs $7.99
     */
    @Test
    public void test(){
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
      WebElement dropdown = driver.findElement(By.xpath("//*[@class='product_sort_container']"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Price (low to high)");

       List<WebElement> listOfProduct = driver.findElements(By.xpath("//*[@class='inventory_item_price']"));
       String first=  listOfProduct.get(0).getText();
       String last=  listOfProduct.get(5).getText();
        Assert.assertEquals("$7.99",first);
        Assert.assertEquals("$49.99",last);


        //*[@class='inventory_item_price']
    }
}
