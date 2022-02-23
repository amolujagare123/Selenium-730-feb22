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

    @Parameters({"myUrl","username","password"})
    @Test
    public void classOneTest1(String url1,String user1,String pass1 )
    {
        String url = url1;
        String user = user1;
        String password = pass1;
        System.out.println("Url="+url);
        System.out.println("user="+user);
        System.out.println("password="+password);
        System.out.println("classOneTest1");
    }

    @Test (groups = "email")
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
