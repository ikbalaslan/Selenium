package tests;

import org.junit.*;

public class Day02_JUnitAnnotations {
    /*
    *SO far we kept using main method
    *We no longer need to use main method to create test cases with JUnit
    * -@Test : is used to create test cases
    * Note: All @Test methods  must be void
    * *@Before: Runs before each @Test class
    * @After: Runs after each @Test class
    * -@BeforeClass :Runs before each Class only once
    * -@AfterClass : Runs after each Class only once
    * -@Ignore :is used to skip/ignore Test case
     */
    @BeforeClass
    public static void setUpClass(){
        System.out.println("Before Class runs before the entire class ONCE");

    }
    @AfterClass
    public static void afterClass(){
        System.out.println("After class runs after the entire class ONCE");
    }
    @Before
    public void setUp(){
        System.out.println("Before methods run before each @Test annotation");
    }
    @After
    public void tearDown(){
        System.out.println("After method runs after each @Test annotation");
    }
    @Test
    public void test1(){
        System.out.println("Test 1");
    }
    @Test
    public void test2(){
        System.out.println("Test 2");
    }
    @Test
    public void test3(){
        System.out.println("Test 3");
    }
    @Test
    public void test4(){
        System.out.println("Test 4");
    }
    @Test
    public void test5(){
        System.out.println("Test 5");
    }




}
