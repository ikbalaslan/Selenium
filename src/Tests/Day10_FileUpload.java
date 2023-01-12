package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import static org.junit.Assert.assertTrue;

public class Day10_FileUpload extends TestBase {
@Test
    public void fileUploadTest() throws InterruptedException {
    //When user goes to https://the-internet.herokuapp.com/upload
    driver.get("https://the-internet.herokuapp.com/upload");

    //1. Locate choose file and Click choose File
   //<input type="file"
    WebElement chooseAFileButton = driver.findElement(By.id("file-upload"));


    //2 Select a file from your computer
   String userHome = System.getProperty("user.home"); //=> Gives you the user folder
    String pathOfFile = userHome + "\\Onedrive\\Masaüstü\\logo.jpeg";
   //Sending the path of the file that I want to upload.
    //We can use send keys cause the input type file combination.
    chooseAFileButton.sendKeys(pathOfFile);

    //3. Then locate a click upload
    driver.findElement(By.id("file-submit")).click();
    //Then verify the File Uploaded!  Message displayed
   boolean isDisplayed = driver.findElement(By.xpath("//h3")).getText().equals("File Uploaded!");
    assertTrue(isDisplayed);
    /*
    How do you upload a file with selenium ?
     -First selenium has limitation automation of files.But file upload can be done with selenium.
      We locate the choose file button then use sendkeys() function to send the path of the file.
      Then we click upload button to upload the file
      Path of the file should be dynamic - use System.getProperty("user.home");

     LIMITATION:
     Selenium has limitation automation DESKTOP APPS
     For example, we can not find path of files, or verify if file exists on out machines with selenium
     Instead we use java File libraries
     */

}
}
