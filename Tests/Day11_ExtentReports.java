package tests;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.text.SimpleDateFormat;
import java.util.Date;
public class Day11_ExtentReports extends TestBase {
    protected static ExtentReports extentReports;
    protected static ExtentHtmlReporter extentHtmlReporter;
    protected static ExtentTest extentTest;
    @BeforeClass
    public static void extentReportsSetUp(){
        //      REPORT  PATH
        String currentTime = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String path = System.getProperty("user.dir")+"/test-output/reports/"+currentTime+"html_report.html";
//        creating HTML report in the path
        extentHtmlReporter = new ExtentHtmlReporter(path);
//        creating extent reports object for generating the Entire reports with configuration
        extentReports = new ExtentReports();
//        ***************
//        adding custom System Info
        extentReports.setSystemInfo("Test Environment","Regression");
        extentReports.setSystemInfo("Application","TechProEd");
        extentReports.setSystemInfo("Browser","Chrome");
        extentReports.setSystemInfo("Team","Eagles");
        extentReports.setSystemInfo("SQA","John Fox");
//        adding more custom info
        extentHtmlReporter.config().setReportName("TechProEd home page");
        extentHtmlReporter.config().setDocumentTitle("TechProEd extent reports");
//        ********************
//        DONE WITH CONFIGURATION
        extentReports.attachReporter(extentHtmlReporter);
//SUMMARY : Extent Reports and Extent HTML Reporter is used to add custom information
        //on the report and create the report in a PATH

        //        REPORT IS DONE. NOW CREATING EXTENT TEST TO LOG INFO IN THE TEST CASE
//        Creating extent test
        extentTest= extentReports.createTest("My Extent Reporter","Regression Test Report");


    }
    @Test
    public void extentReportsTest(){
        extentTest.pass("Going to the App home page");
        driver.get("https://www.techproeducation.com");
        //Click on LMS
        extentTest.pass("Clicking on LMS Login button");
        driver.findElement(By.linkText("LMS LOGIN")).click();
        //Verify the URL
        extentTest.pass("Verify the LMS URL");
        String expectedURL ="https://lms.techproeducation.com/";
        String actualURL=driver.getCurrentUrl();
        Assert.assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED",expectedURL,actualURL);
        extentTest.pass("TEST IS COMPLETE ");
    }
    @Test
    public void extendReportsTest2(){
       //Pass is used to mark the step as PASSED
        extentTest.pass("PASS");
        //info is used to just give an information for that step.
        extentTest.info("INFO");
        //Fail is used to mark the step as  FAILED
        extentTest.fail("FAILED");
        //skip is used to mark the step as SKIPPED
        extentTest.skip("SKIPPED");
        //Warning is used to give warning information
        extentTest.warning("WARNING");
    }



    @AfterClass
    public static void extentReportsTearDown(){
        extentReports.flush();
    }
}
/*
How do you get the report?
When I do manual testing, I capture the screenshot manually and save on a word doc, then upload the document to JIRA.
When I automate the user story, I use extent reports for generation the test reports
Extent reports is customizable
I can configure the extent reports based on the project information
In my project , we customized extent report in a way that it takes the screenshot automatically, when test case fails.
 + What are the advantages of extent reports ?
Open source
Works with different browsers and platform
It works with different frameworks like junit, testng, cucumber
We can log each step
It is customizable
 + How extent reports generates reports ? How extent reports work ?
We are using maven , and I have to extent reports dependency
I have a reusable class. In that class I have extent reports configuration
           i) Extent reports ii) Extent Html Reporter ===>>> are user for generation the reports
           iii)Extents Test
It is a dependecy I use extent report on my framework for generating custom reports .
**For example, Extent reports and extent html reporter can be used for adding custom information such as platform ,
 + Where do you get that dependency ?
We have company internal repository. I check the repo and get the dependency(Jar file's are risky for security reason thats why we dont go to direct maven)
 + What if the dependency is not in your company repository, then what question ?
I need to raise a request for the dependency so the company can add. I ask the test lead , tech lead , manager...

 */
