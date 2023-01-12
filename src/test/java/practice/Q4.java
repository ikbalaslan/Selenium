package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q4 {
    //1-http://https://www.hurriyet.com.tr/  sayfasina gidin
    //2-sirasiyla gelen uyarailari kapatin
    //3-en ust menudeki Spor Arena'ya gidin.
    //4-Burda istediginiz takimin amblemine tiklayin.
    //5-gelen sayfada orta kisimdaki haberlerden birinin acilmaisni sgalayin.
 WebDriver driver;
    @Before
    public void setUP(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.get("https://www.hurriyet.com.tr/");
    }
    @Test
    public void s(){
//onclick="nmWorker.onAskLaterClicked();"
        driver.findElement(By.xpath(("//p[@class='fc-button-label']"))).click();
        System.out.println("izin vere tiklandi");



        driver.findElement(By.xpath(("//div[@class='btn-notification btn-secondary']"))).click();
        System.out.println("daha sonraya tiklandi");

        driver.findElement(By.linkText("SPOR ARENA")).click();
        driver.findElement(By.linkText("Fenerbahçe")).click();   //

        driver.findElement(By.xpath(("//span[@class='swiper-pagination-bullet'][4]"))).click();    }
}
