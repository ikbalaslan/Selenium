package practice;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q05 {
    ////      User goes https://phptravels.com/demo
    ////      User fill the form with Faker
    ////      User check the question and fill in the blank with correct answer
    ////      User click the submit button
    WebDriver driver;
    @Before
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/demo");
    }
    @Test
    public void s() throws InterruptedException {
        Faker faker = new Faker();
       String firstname = faker.name().firstName();
       driver.findElement(By.name("first_name")).sendKeys(firstname);
       String lastname = faker.name().lastName();
        driver.findElement(By.name("last_name")).sendKeys(lastname);
        String businessName = faker.company().name();
        driver.findElement(By.name("business_name")).sendKeys(businessName);
        String mail = faker.internet().emailAddress();
        driver.findElement(By.name("email")).sendKeys(mail);
       String numb1 = driver.findElement(By.id("numb1")).getText();
       String numb2 = driver.findElement(By.id("numb2")).getText();
     int result =(Integer.valueOf(numb1) + Integer.valueOf(numb2));
     driver.findElement(By.id("number")).sendKeys("" + result + "");
     Thread.sleep(5000);
     driver.findElement(By.id("demo")).click();

    }
}
