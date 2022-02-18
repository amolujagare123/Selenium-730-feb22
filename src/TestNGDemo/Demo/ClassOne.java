package TestNGDemo.Demo;

import org.testng.annotations.*;

public class ClassOne {

    @BeforeSuite
    public void beforeMySuite1()
    {
        System.out.println("beforeMySuite1");
    }

    @AfterSuite
    public void afterMySuite1()
    {
        System.out.println("afterMySuite1");
    }

    @Test
    public void classOneTest1()
    {
        System.out.println("classOneTest1");
    }

    @Test
    public void classOneTest2()
    {
        System.out.println("classOneTest2");
    }

    @Test
    public void classOneTest3()
    {
        System.out.println("classOneTest3");
    }
}
