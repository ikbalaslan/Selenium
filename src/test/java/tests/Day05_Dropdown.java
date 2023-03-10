package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Day05_Dropdown {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));//15 seconds wait in case needed
        driver.manage().window().maximize();
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    @Test
    public void selectByIndexTest(){
        //Select Option 1 by index from the dropdown
        //1.Locate the dropdown
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        //2.Create Select Object cause dropdown is in the select tag. this is for only dropdowns
        Select select = new Select(dropdown);
        //3.Select any option using the select object
        select.selectByIndex(1);

    }
    //2.Create method selectByValueTest Select Option 2 by visible text
    @Test
    public void selectByVisibleTextTest(){
WebElement dropdown = driver.findElement(By.id("dropdown"));
Select select = new Select(dropdown);
select.selectByVisibleText("Option 2");

    }
    //3.Create method selectByValueTest Select Option 1 value by value
    @Test
    public void selectByValueTest(){
      WebElement dropdown = driver.findElement(By.id("dropdown"));
      Select select = new Select(dropdown);
      select.selectByValue("1");

    }
    //4.Create method printAllTest Print all dropdown value
    @Test
    public void printAllTest() throws InterruptedException {
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
      Thread.sleep(5000);
        //This getOptions method returns a list.
       List<WebElement> allOptions =  select.getOptions();
       for (WebElement eachOption : allOptions){
          //getText() returns the text of the webelements
           System.out.println(eachOption.getText());
      //Print all elements
        //1.Way
          if (eachOption.getText().equals("Option2")){
               Assert.assertTrue(true);

           }
       }
         //2.Way
boolean isOption2Exists=false;
       for (WebElement eachOption : allOptions){
           if (eachOption.getText().equals("Option 2")){
               isOption2Exists=true;
           }
       }
        Assert.assertTrue(isOption2Exists);


    }
    //6.Create method printFirstSelectedOptionTest Print first selected option

    @Test
    public void printFirstSelectedOptionTest(){
        WebElement dropdown = driver.findElement(By.id("dropdown"));
        Select select = new Select(dropdown);
        select.selectByIndex(2);
        System.out.println("Selected Option " + select.getFirstSelectedOption().getText());
    }

    //7.Find the size of the dropdown, Print "Expected Is Not Equal Actual" if there are not 3 elements in the dropdown.
  @Test
  public void sizeTest(){
      WebElement dropdown = driver.findElement(By.id("dropdown"));
      Select select = new Select(dropdown);
      List<WebElement> allOptions =  select.getOptions();
      if (allOptions.size()!=3){
          System.out.println("Expected Is Not Equal Actual");
      }
      //2.Way
      int numberOfOptions = select.getOptions().size();
      int expectedNumberOfOptions = 3;
      //Assertion will print expected is not equal actual only if this assertion fails
      Assert.assertEquals("Expected Is Not Equal Actual",expectedNumberOfOptions,numberOfOptions);

    }
    @After
    public void tearDown(){
        driver.quit();
    }
    /*
    -What is a dropdown ?
     ---Dropdown is a webelement. It has list of options
    -How do you handle dropdown ?
     ---Dropdowns are created using Select class.So we first locate the dropdown element, then use select class
     to interact with dropdown elements.
    -How do you select dropdown elements ?
     ---We actually have 3 options to select a dropdown(index,value,visibleText)
     */


}









