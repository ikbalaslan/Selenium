package practices_with_group.Practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Q04 extends TestBase {
    @Test
    public void test(){
        /*
    Given
        Go to https://testpages.herokuapp.com/
    When
        Click on File Downloads
    And
        Click on Server Download
    Then
        Verify that file is downloaded
     */
        driver.get("https://testpages.herokuapp.com/");
        driver.findElement(By.id("download")).click();
        driver.findElement(By.id("server-download")).click();



        String homeDirectory = System.getProperty("user.home"); //=> Gives you the user folder
        String filePath = homeDirectory + "\\Downloads\\textfile.txt";
        wait_for(2);
        boolean isDownloaded = Files.exists(Paths.get(filePath));//This will return if downloaded succesful
        Assert.assertTrue(isDownloaded);

    }
}
