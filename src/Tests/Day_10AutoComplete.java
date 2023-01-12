package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day_10AutoComplete  extends TestBase {
    //Given user is on https://testcenter.techproeducation.com/index.php?page=autocomplete
    //When user type “uni” in the search box
    //And select the ‘United Kingdom’ from the suggestions
    //And click on submit button
    //Then verify the result contains ‘United Kingdom’
    @Test
    public void autoCompleteTest(){
        driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        //    When user type “uni” in the search box
        driver.findElement(By.id("myCountry")).sendKeys("uni");
        //    And select the ‘United Kingdom’ from the suggestions
        driver.findElement(By.xpath("//div[@id='myCountryautocomplete-list']//div[.='United Kingdom']")).click();
        //    And click on submit button
        driver.findElement(By.xpath("//input[@type='button']")).click();
        //    Then verify the result contains ‘United Kingdom’
        Assert.assertTrue(driver.findElement(By.id("result")).getText().contains("United Kingdom"));
    }
    @Test
    public void autoCompleteTestByDynamically(){
       driver.get("https://testcenter.techproeducation.com/index.php?page=autocomplete");
        searchAndSelectFromList("u","United Kingdom"); // Test case 1
        searchAndSelectFromList("b","Barbados");       // Test case 2

    }
}
