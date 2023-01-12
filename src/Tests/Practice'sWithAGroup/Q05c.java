package practices_with_group.Practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q05 extends TestBase {
    /*
    Given
        Go to http://webdriveruniversity.com/To-Do-List/index.html
    When
        Add todos: (Prepare breakfast, Wash the dishes, Take care of baby, Help your kid's homework, Study Selenium, Sleep)
    And
        Strikethrough all todos.
    And
        Delete all todos.
    Then
        Assert that all todos deleted.
     */
    @Test
    public void t() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/To-Do-List/index.html");
       WebElement source = driver.findElement(By.xpath("//*[@type='text']"));
       source.sendKeys("Prepare breakfast");
       source.sendKeys(Keys.ENTER);
        source.sendKeys("Take care of baby");
        source.sendKeys(Keys.ENTER);
        source.sendKeys("Help your kid's homework");
        source.sendKeys(Keys.ENTER);
        source.sendKeys("Study Selenium");
        source.sendKeys(Keys.ENTER);
        source.sendKeys("Sleep");
        source.sendKeys(Keys.ENTER);
//  Strikethrough all todos.

       List<WebElement> listOfTodos = driver.findElements(By.xpath("//ul//li"));
       for (WebElement w : listOfTodos){
           w.click();

       }
        //Delete all todos.
        Thread.sleep(2000);
        List<WebElement> deleteButtons = driver.findElements(By.xpath("//i[@class='fa fa-trash']"));
        for(WebElement w : deleteButtons){
            w.click();
        }

        //Assert that all todos deleted.
        Thread.sleep(2000);
        List<WebElement> allTodosAfterDelete =  driver.findElements(By.xpath("//li"));
        assertEquals(0, allTodosAfterDelete.size());

    }
}
