package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q2 {
    //a.amazon web sayfasına gidin. https://www. amazon.com/
//b. Search(ara) "city bike"
//c. Amazon'da görüntülenen ilgili sonuçların sayısını yazdırın
//d. "Shopping" e tıklayın.
//e. Sonra karşınıza çıkan ilk sonucun resmine tıklayın.


    WebDriver driver;
    @Before
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
    }
    @Test
    public void q2(){
        //a.amazon web sayfasına gidin. https://www. amazon.com/

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("city bike");
        driver.findElement(By.id("nav-search-submit-button")).click();
        String result = driver.findElement(By.xpath("//*[contains(text(),'results for')]")).getText();
        System.out.println(result);
        driver.findElement(By.xpath("//*[contains(text(),'EB-12 City')]")).click();
        driver.findElement(By.id("imgTagWrapperId")).click();
    }

}


