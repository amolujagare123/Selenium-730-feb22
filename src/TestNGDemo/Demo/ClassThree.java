package TestNGDemo.Demo;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassThree {

    @Parameters({"myUrl","username","password"})
    @Test
    public void classThreeTest1(String url1,String user1,String pass1 )
    {
        String url = url1;
        String user = user1;
        String password = pass1;

        System.out.println("Url="+url);
        System.out.println("user="+user);
        System.out.println("password="+password);
        System.out.println("classThreeTest1");
    }

    @Test (groups = {"email","xyyz"} )
    public void classThreeTest2()
    {
        System.out.println("classThreeTest2");
    }

    @Test
    public void classThreeTest3()
    {
        System.out.println("classThreeTest3");
    }
}
