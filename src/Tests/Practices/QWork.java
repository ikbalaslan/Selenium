package practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class QWork {


    //Create A Class: AmazonDropdown
    //Create A Method dropdownTest
    //Go to https://www.amazon.com/
    //Find the element of the dropdown element. HINT: By.id(“searchDropdownBox")
    //Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
    //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need to use get first selected option method). If it fails, then comment that code out and continue rest of the test case.
    //Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
    //Print the the total number of options in the dropdown
    //Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
    //BONUS: Assert if the dropdown is in Alphabetical Order
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
    public void s(){
      WebElement dropdown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdown);
        //Print the first selected option and assert if it equals “All Departments”.If it fails, then comment that code out and continue rest of the test case.
     WebElement firstSelectedOption =   select.getFirstSelectedOption();
        System.out.println(firstSelectedOption.getText());
        Assert.assertTrue(firstSelectedOption.getText().equals("All Departments"));
        //Select the 4th option by index (index of 3) and assert if the name is “Amazon Devices”.(after you select you need
        //to use get first selected option method).
        // If it fails, then comment that code out and continue rest of the test case.
        select.selectByIndex(3);
        WebElement thirdSelected =   select.getFirstSelectedOption();
        System.out.println(thirdSelected.getText());
        //Assert.assertEquals("Amazon Devices",thirdSelected.getText());
        //Print all of the dropdown options-getOptions(); method returns the List<WebElement>. Using loop, print all options.
       List<WebElement> list = select.getOptions();
       for (WebElement w : list){
           System.out.println(w.getText());
       }
        //Print the the total number of options in the dropdown
        System.out.println(list.size());


        //Assert if ‘Appliances’ is a drop down option. Print true if “Appliances” is an option. Print false otherwise.
        boolean x =false;
        for (WebElement w : list){
            if (w.getText().equals("Appliances")){
                x=true;
            }
        }
         //Assert.assertTrue(x);
        System.out.println("Appliances is an option ? " + x );
        //BONUS: Assert if the dropdown is in Alphabetical Order

       boolean isItAlphabetical = false;
        char element = '1';
        int counter = 0;
        for (WebElement w : list){
            if (w.getText().charAt(0)>=element && counter<list.size()){
               element= w.getText().charAt(0);
               counter++;
               if (counter +1 == list.size()){
                   isItAlphabetical =true;
               }
            }
        }
        System.out.println("Is options alphabetical ? " + isItAlphabetical);

        //2nd WAY
        //      List<Double> result = list1.stream().distinct().filter(t->t>5).map(t-> t/2.0).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
//       List<WebElement> list2 = list.stream().sorted().collect(Collectors.toList());
//       if (list==list2){
//           System.out.println("It ıs alhabetical" );
//       }else{
//           System.out.println("It is not alhabetical");
//       }



    }

}
