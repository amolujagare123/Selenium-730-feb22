package TestNGDemo.Demo;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BeoreAfterClass {

    @BeforeTest
    public void beforeMyTest()
    {
        System.out.println("beforeMyTest");
    }

    @AfterTest
    public void afterMyTest()
    {
        System.out.println("afterMyTest");
    }

    @BeforeSuite
    public void beforeMySuite()
    {
        System.out.println("beforeMySuite");
    }

    @AfterSuite
    public void afterMySuite()
    {
        System.out.println("afterMySuite");
    }

}
