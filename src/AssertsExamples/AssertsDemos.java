package AssertsExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class AssertsDemos {

    @Test (enabled = false)
    public void logintest1()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("admin1");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

       /* String expected = "https://stock.scriptinglogic.net/dashboard.php1";
        String actual = driver.getCurrentUrl();*/


     /*   String expected ="POSNIC - Dashboard";
        String actual = driver.getTitle();*/

        String expected = "Dashboard";
        String actual="";
        try {
            actual = driver.findElement(By.cssSelector(".active-tab")).getText();
        }
        catch (Exception e)
        {

        }
      /*  String expected = "Log out";
        String actual="";

        try {
            actual = driver.findElement(By.cssSelector(".menu-logoff")).getText();
        }
        catch (Exception e)
        {

        }*/
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"This is not a dashboard");
    }

    @Test (enabled = false)
    public void logintest2()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("dsdsd");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("dsdsds");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

        String expected = "Wrong Username or Password";
        String actual = "";

        try {
            actual = driver.findElement(By.cssSelector(".error-box")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect error message or error message absent");

    }

    @Test (enabled = false)
    public void logintest3()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

        String expected = "PLEASE ENTER A USERNAME";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//label[@for='login-username' and @class='error']")).getText();
        }
        catch (Exception e)
        {

        }

        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect error message or error message absent");

    }

    @Test (enabled = true)
    public void logintest4()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

       // String expected = "PLEASE ENTER A USERNAME";


      //  String[] expected = {"PLEASE ENTER A USERNAME","PLEASE PROVIDE A PASSWORD"};

       ArrayList<String> expected = new ArrayList<>();
        expected.add("PLEASE ENTER A USERNAME");
        expected.add("PLEASE PROVIDE A PASSWORD");

       /* ArrayList<String> expected = new ArrayList<>(){{
            add("PLEASE ENTER A USERNAME");
            add("PLEASE PROVIDE A PASSWORD");
        }};*/

        List<WebElement> errorList = null;
      
        try {

           errorList = driver.findElements(By.xpath("//label[@class='error']"));

          
        }
        catch (Exception e)
        {

        }
        
        ArrayList<String> actual = new ArrayList<>();
        actual.add(errorList.get(0).getText());
        actual.add(errorList.get(1).getText());


        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);

        Assert.assertEquals(actual,expected,"incorrect error message or error message absent");

    }
}
