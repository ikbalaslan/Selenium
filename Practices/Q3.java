package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {
    //1. Amazon sayfasina gidelim. https://www.amazon.com/
//2. Sayfa basligini(title) yazdirin
//3. Sayfa basliginin "Amazon" icerdigini test edin
//4. Sayfa adresini(url) yazdirin
//5. Sayfa url'inin "amazon" icerdigini test edin.
//6. Sayfa handle degerini yazdirin
//7. Sayfa HTML kodlarinda "Easy returns" kelimesi gectigini test edin
//8. Sayfayi kapatin.
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
    public void bum(){

    }
}
