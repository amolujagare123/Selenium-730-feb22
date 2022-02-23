package TestNGDemo.Demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassTwo {

    @Parameters({"myUrl","username","password"})
    @Test
    public void classTwoTest1(String url1,String user1,String pass1 )
    {
        String url = url1;
        String user = user1;
        String password = pass1;

        System.out.println("Url="+url);
        System.out.println("user="+user);
        System.out.println("password="+password);

        System.out.println("classTwoTest1");
    }

    @Test (groups = "email")
    public void classTwoTest2()
    {
        System.out.println("classTwoTest2");
    }

    @Test
    public void classTwoTest3()
    {
        System.out.println("classTwoTest3");
    }
}
