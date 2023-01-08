package practices_with_group.Practice03;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
    /*
    Given
        Go to "https://cgi-lib.berkeley.edu/ex/fup.html"
    When
       Type "My File" into "Notes about the file" input
    And
        Select the file to upload
    And
        Click "Choose File" button
    And
        Click on "Press" button
    Then
        Assert that "Your notes on the file were" equals "My File"
    And
        Assert that file Content contains "Hello, I am uploaded file"
     */
    @Test
    public void q02(){
        driver.get("https://cgi-lib.berkeley.edu/ex/fup.html");
        driver.findElement(By.name("note")).sendKeys("My File");
      WebElement theButton = driver.findElement(By.name("upfile"));
        String userHome = System.getProperty("user.home"); //=> Gives you the user folder
        String pathOfFile = userHome + "\\Downloads\\123.tmp";
               theButton.sendKeys(pathOfFile);
               driver.findElement(By.xpath("//*[@type='submit']")).click();
             String file =  driver.findElement(By.xpath("//blockquote")).getText();
             assertEquals("My File",file);
             assertTrue(driver.findElement(By.xpath("//pre")).getText().contains("junit"));



    }
}
