package practices_with_group.Practice02;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Q05 extends TestBase {
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    // Match the capitals by country.
    @Test
    public void test(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        // Match the capitals by country.
        //Capitals
       WebElement rome = driver.findElement(By.id("box6"));
       WebElement madrid = driver.findElement(By.id("box7"));
       WebElement seoul = driver.findElement(By.id("box5"));
       WebElement copenhagen = driver.findElement(By.id("box4"));
       WebElement washington = driver.findElement(By.id("box3"));
       WebElement stockholm = driver.findElement(By.id("box2"));
       WebElement oslo = driver.findElement(By.id("box1"));
       //Countrys
        WebElement italy = driver.findElement(By.id("box106"));
        WebElement spain = driver.findElement(By.id("box107"));
        WebElement norway = driver.findElement(By.id("box101"));
        WebElement denmark = driver.findElement(By.id("box104"));
        WebElement southkorea = driver.findElement(By.id("box105"));
        WebElement sweden = driver.findElement(By.id("box102"));
        WebElement usa = driver.findElement(By.id("box103"));

        Actions actions = new Actions(driver);
        actions.dragAndDrop(rome,italy).perform();
        actions.dragAndDrop(madrid,spain).perform();
        actions.dragAndDrop(seoul,southkorea).perform();
        actions.dragAndDrop(washington,usa).perform();
        actions.dragAndDrop(oslo,norway).perform();
        actions.dragAndDrop(copenhagen,denmark).perform();
        actions.dragAndDrop(stockholm,sweden).perform();


    }
}
