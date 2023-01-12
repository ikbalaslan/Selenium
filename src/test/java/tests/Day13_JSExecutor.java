package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import utilities.TestBase;

import java.io.IOException;

public class Day13_JSExecutor extends TestBase {
    @Test
    public void scrollIntoViewTest() throws IOException {
        driver.get("https://techproeducation.com");
        wait_for(2);
        //1.Create js executor object
        JavascriptExecutor js = (JavascriptExecutor)driver;
        //2. Execute the comment
        wait_for(2);
      //Scrolling We Offer element
        js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[.='we offer']")));
   takeScreenshotOfPage();
    wait_for(2);
  //Scrolling LMS LOGIN element
    js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
  takeScreenshotOfPage();
   wait_for(2);
   //scrolling WHY US text
   scrollIntoViewJS(driver.findElement(By.xpath("//h3[.='WHY US?']")));
        wait_for(1);
        takeScreenshotOfPage();
  //Scrolling back up to enroll free
        scrollIntoViewJS(driver.findElement(By.xpath("//span[.=' Enroll Free ']")));
        wait_for(1);
        takeScreenshotOfPage();

        //Scroll all the way down
        scrollAllDownByJS();
        wait_for(1);
        takeScreenshotOfPage();
        //Scroll all the way up
        scrollAllUpByJS();
        wait_for(1);
        takeScreenshotOfPage();
    }
    @Test
    public void clickByJSTest(){
        driver.get("https://techproeducation.com");
        clickByJS(driver.findElement(By.linkText("LMS LOGIN")));

    }
    @Test
    public void typeInTheInputTest(){
        driver.get("https://techproeducation.com");
        setValueByJS(driver.findElement(By.xpath("//input[@type='search']")),"QA");

    }

    @Test
    public void getValueOfInputTest(){

        driver.get("https://www.priceline.com/");
        getValueByJS("hotelDates");

    }
    @Test
    public void colorByJSTest(){
        driver.get("https://www.priceline.com/");
        changeBackgroundColorByJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"red");
    addBorderWithJS(driver.findElement(By.xpath("//button[@data-testid='HOTELS_SUBMIT_BUTTON']")),"5px solid green");
    }



}
