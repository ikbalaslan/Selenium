package tests;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;
public class Day14_NoSuchElementException extends TestBase {
    @Test
    public void noSuchElementTest(){
        driver.get("https://techproeducation.com/");

//        Wrong locator
        driver.findElement(By.id("wrong-id"));// org.openqa.selenium.NoSuchElementException:

    }
}
/*
INTERVIEW ALERT !!!
Tell me 5 exception that you get.
-NoSuchElementException.
i)Locator may not be correct
ii)Element is not on the page because of the iframe or pop-up or new-window
iii)Loading issue-synchronization issue. Implicit wait is not enough
iv)Element is hidden.
SOLUTION:
i)Make sure locator is correct. Double check syntax.
ii)DO manual testing to make sure there is no frame , popups , or any other blocked on page.
iii)If locator is correct and if we used correct switch(iframe,new window...)then apply wait. Maybe element is hidden
iv)Sometimes implicit wait may not be enough to handle spesific issues .
v)Try using explicit wait . If that doesn't work. then try thread.sleep as a last resort.

-TimeOutException
i)When we use explicit wait and after if locator cannot find a element it will throw a timeoutexception
-NullPointerException
i)When a variable is created, but not instantiated when pointer does not show any value then we get NullPointerException
-StaleElementReferenceException
i)Stale(Old) element means the element is no longer fresh. It is old and no longer available. When the element is removed
  after session. Fx: driver.navigate.refresh() if you type it after some elements were used. Those elements will be stale.
ii)Solution:Relocate the same element again. You can use
-JavaScriptException
-WebDriverException
What type of exceptions do you get in selenium ?
What is your solution?


 */