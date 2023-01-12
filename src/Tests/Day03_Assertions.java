package tests;

import org.junit.Assert;
import org.junit.Test;

public class Day03_Assertions {
    @Test
    public void assertions(){
        /*
        What is assertion in testing ?
        Assertion is done to check if expected result is equal to actual result.
        -expected == actual -> pass
        -expected != actual -> fail
        ---------------
        assertEquals("expected","actual");
        assertTrue(true); -> pass
        assertTrue(false); -> fail
        assertFalse(false); -> pass
        assertFalse(true); -> fail
         */
        Assert.assertEquals(5,5);
        Assert.assertEquals("java","java");
        Assert.assertEquals("java".contains("j"),true);
       // ------------------------------
        Assert.assertTrue("java".contains("j")); //-> pass
        //TEST EXECUTION STOPS IF ONE OF THE ASSERTION FAILS, THIS IS CALLED HARD ASSERTION

        //TEST EXECUTION CONTINUES EVEN IF TEST VERIFICATION FAILS .VERIFICATIONS MEANS LIKE IF STATEMENT .

        //What is difference between VERIFICATION and ASSERTION ?
        //-Assertion stops after assertion fails , Verification continues even after verification fails.
        //Junit assertions are hard assertion. If statement is verification .
        //Note: TEstNG has soft assertion as well. We will learn it in TestNG



    }
}
