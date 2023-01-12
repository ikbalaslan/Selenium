package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day02_URLVerification {
    public static void main(String[] args) {
       //	1.Create a new class: VerifyURLTest
        //	2.Navigate to TechProEducation homepage
        //	3.Verify if google homepage url is “https://techproeducation.com/”
        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.techproeducation.com");
        //Verify if homepage url is "https://www.techproeducation.com"
       String actualData = driver.getCurrentUrl();
       String expectedData = "https://techproeducation.com/";
       if (actualData.equals(expectedData)){
           System.out.println("Pass");
       }else{
           System.out.println("FAIL");
           System.out.println("Actual Data " + actualData);
           System.out.println("Expected Data  " + expectedData);
       }
       /*
       What is your approach for automation ?
       -I read the acceptance criterias carefully
       -I then create my test cases
       -Then I do my manual testing FIRST
         -If all good, then I start complete my automation script
         -If I find a bug/defect, then I talk to dev. Dev fixes the issue, then I retest.
         -If all is good then I complete my automation
      -Then
         -When the automation is complete, I prepare to report for the user story.
         -In fact, My automation script generates html reports for us. I upload those reports to the jira
        -For my manual test cases, I manually take screenshots and prepare reports and attech them to the JIRA
       ----------------------------------
        WHAT DO YOU DO WHEN YOUR AUTOMATION TEST CASE PASS
        -Prepare report and upload to JIRA
      ------------------------------------
        WHAT DO YOU DO WHEN YOUR TEST CASE FAIL
       -Retest to make sure from the failure. It can be data issue or is can be real bug.
       -If that is a bug, then talk to the dev and let them fix the bug.
       -After the fix, we retest. When test case passes we upload the JIRA

       -----------------------------------
        WHAT DO YOU DO WHEN YOU FIND A BUG
       -Retest to make sure from the failure. It can be data issue or is can be real bug.
       -If that is a bug, then talk to the dev and let them fix the bug.
       -After the fix, we retest. When test case passes we upload the JIRA
       ------------------------------------
       We
        */

    }
}
