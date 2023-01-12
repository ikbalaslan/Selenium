package practices_with_group.Practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q01 extends TestBase {
    //Calculate the total amount on the table
    //https://testpages.herokuapp.com/styled/tag/table.html
    @Test
    public void test(){
        driver.get("https://testpages.herokuapp.com/styled/tag/table.html");
        List<WebElement> listOfNumeros = driver.findElements(By.xpath("//*[@id='mytable']//tbody//td[2]"));

        Double count = 0.0;
      for (WebElement w : listOfNumeros){
         count += Double.valueOf(w.getText());
      }
        System.out.println(count);
    }
}
