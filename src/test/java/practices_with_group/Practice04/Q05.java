package practices_with_group.Practice04;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Q05 extends TestBase {
    @Test
    public void test(){
        ////Go to https://testpages.herokuapp.com/styled/basic-html-form-test.html
        //    //Fill the username, password and textArea comment:
        //    //Choose a file and upload it
        //    //Select checkbox, radio item and dropdowns
        //    //Click on submit
        //    //Verify that uploaded file name is on the Form Details.
     driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        driver.findElement(By.name("username")).sendKeys("Iko");
        driver.findElement(By.name("password")).sendKeys("Aso");
        driver.findElement(By.name("comments")).sendKeys("ZAM");

        String homeDirectory = System.getProperty("user.home");
        String filePath = homeDirectory + "\\Downloads\\textfile.txt";
        driver.findElement(By.name("filename")).sendKeys(filePath);

        wait_for(2);
        driver.findElement(By.xpath("//*[@value='cb1']")).click();
        driver.findElement(By.xpath("//*[@value='cb2']")).click();

        driver.findElement(By.xpath("//*[@value='rd1']")).click();

        driver.findElement(By.xpath("//*[@value='ms1']")).click();

        wait_for(2);
       WebElement element =driver.findElement(By.name("dropdown"));
        Select select = new Select(element);
        select.selectByIndex(0);
        wait_for(2);

           driver.findElement(By.xpath("//*[@value='submit']")).click();

          String file = driver.findElement(By.id("_valuefilename")).getText();
        Assert.assertEquals("textfile.txt",file);
//7 Principles
        /*
        1. Testing shows the presence of defects, not their absenc
        2. Exhaustive testing is impossible
        3. Early testing saves time and money
        4. Defects cluster together
        5. Beware of the pesticide paradox
        6. Testing is context dependent
        7. Absence-of-errors is a fallacy


 Test planning
 Test monitoring and control
 Test analysis
 Test design
 Test implementation
 Test execution
 Test completion
Checking test results and logs against specified coverage criteria
 Assessing the level of component or system quality based on test results and logs
 Determining if more tests are needed (e.g., if tests originally intended to achieve a certain level of
product risk coverage failed to do so, requiring additional tests to be written and executed)

     During test analysis, the test basis is analyzed to identify testable features and define associated test
conditions. In other words, test analysis determines “what to test” in terms of measurable coverage
criteria.
Analyzing the test basis appropriate to the test level being considered, for example:

During test design, the test conditions are elaborated into high-level test cases, sets of high-level test
cases, and other testware. So, test analysis answers the question “what to test?” while test design
answers the question “how to test?”

So, test design answers the question “how to test?” while test implementation answers the question “do we now have everything in place to run the
tests?”
. Test completion activities occur at project milestones such as when a
software system is released, a test project is completed (or cancelled), an Agile project iteration is
finished (e.g., as part of a retrospective meeting), a test level is completed, or a maintenance release has
been completed.







         */


    }

}
