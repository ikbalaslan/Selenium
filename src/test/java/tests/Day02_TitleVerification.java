package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_TitleVerification {
    public static void main(String[] args) {
       //	1.Create a new class: VerifyTitleTest
        //	2.Navigate to techproeducation homepage
        //	3.Verify if google title is “Techpro Education | Online It Courses & Bootcamps”
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
         driver.manage().window().maximize();
         driver.get("https://www.techproeducation.com");
          //Get the title
      String actualData =  driver.getTitle();
      String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
      if (actualData.equals(expectedTitle)){
          System.out.println("Pass");
      }else{
          System.out.println("Fail");
      }
    }
}
