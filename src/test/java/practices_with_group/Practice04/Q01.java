package practices_with_group.Practice04;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
 /*
  Given
    Go to  https://www.saucedemo.com/
  When
    Enter the username  as "standard_user"
  And
    Enter the password as "secret_sauce"
  And
    Click on login button
  And
    Add al products to cart
  And
    Go to cart
  And
    Click on checkout
  And
    Fill your information
  And
    Click on continue
  Then
    Assert that total price is $140.34
  When
    Click on finish
  Then
    Assert that CHECKOUT: COMPLETE!
   */

public class Q01 extends TestBase {
   @Test
    public void test(){
       driver.get("https://www.saucedemo.com/");
driver.findElement(By.id("user-name")).sendKeys("standard_user");
driver.findElement(By.id("password")).sendKeys("secret_sauce");
driver.findElement(By.id("login-button")).click();
// Add al products to cart
List<WebElement> listOfProducts = driver.findElements(By.xpath("//*[.='Add to cart']"));
for (WebElement w : listOfProducts){
    w.click();
}
//  Go to cart
     driver.findElement(By.id("shopping_cart_container")).click();
//    Click on checkout
      scrollIntoViewJS(driver.findElement(By.id("checkout")));
       driver.findElement(By.id("checkout")).click();
//       Fill your information
       Faker faker = new Faker();
     String firstName =  faker.name().firstName();
      String lastName = faker.name().lastName();
      String zipCode = faker.address().zipCode();
      driver.findElement(By.id("first-name")).sendKeys(firstName);
      driver.findElement(By.id("last-name")).sendKeys(firstName);
      driver.findElement(By.id("postal-code")).sendKeys(firstName);
   //    Click on continue
      driver.findElement(By.id("continue")).click();
//    Assert that total price is $140.34
     String amount = driver.findElement(By.xpath("//*[@class='summary_total_label']")).getText();
       Assert.assertEquals("Total: $140.34",amount);
//       Click on finish
       driver.findElement(By.id("finish")).click();
//       Assert that CHECKOUT: COMPLETE!
String complete = driver.findElement(By.xpath("//*[@class='title']")).getText();
Assert.assertEquals("CHECKOUT: COMPLETE!",complete);

   }

}
