package TestNGDemo.Demo2;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ClassTwo {


    @Test
    public void classTwoTest1( )
    {


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
