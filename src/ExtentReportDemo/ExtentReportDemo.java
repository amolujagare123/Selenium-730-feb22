package ExtentReportDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ExtentReportDemo {

    ExtentReports extent;

    @BeforeClass
    public void initExtentObject()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report\\report.html");
        extent = new ExtentReports();

        reporter.config().setReportName("Regression tests");
        reporter.config().setDocumentTitle("Stock Management system");

        extent.attachReporter(reporter);

        extent.setSystemInfo("Developers Name","Kiran");
        extent.setSystemInfo("Testers Name","Ashok");
        extent.setSystemInfo("Project Name","Stock Management system");
        extent.setSystemInfo("Start Date","23-03-22");
        extent.setSystemInfo("Deadline","23-04-22");

    }

    @AfterClass
    public void createReport()
    {
        extent.flush();
    }

    @Test
    public void logintest1()
    {
        ExtentTest test = extent.createTest("Valid Login Test");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("Browser is opened");

        driver.manage().window().maximize();

        test.info("window is maximized");

        driver.get("https://stock.scriptinglogic.net");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("admin");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("admin");
        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();
        test.info("login button is clicked");

        String expected = "https://stock.scriptinglogic.net/dashboard.php1";
        String actual = driver.getCurrentUrl();

        try {

            Assert.assertEquals(actual, expected, "This is not a dashboard");
            test.pass("Test is passed");
        }
        catch (AssertionError e)
        {
            test.fail(e.getMessage());
        }



    }

    @Test
    public void logintest2()
    {
        ExtentTest test = extent.createTest("inValid Login Test");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("Browser is opened");

        driver.manage().window().maximize();

        test.info("window is maximized");

        driver.get("https://stock.scriptinglogic.net");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("sfs");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("sfsf");
        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();
        test.info("login button is clicked");

        String expected = "Wrong Username or Password";
        String actual = "";

        try {
            actual = driver.findElement(By.cssSelector(".error-box")).getText();
        }
        catch (Exception e)
        {

        }

        try {
            Assert.assertEquals(actual, expected, "incorrect error message or error message absent");
            test.pass("Test is passed");
        }
        catch (Exception e)
        {
            test.fail(e.getMessage());
        }
    }

    @Test
    public void logintest3()
    {
        ExtentTest test = extent.createTest("Blank Login Test");

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        test.info("Browser is opened");

        driver.manage().window().maximize();

        test.info("window is maximized");

        driver.get("https://stock.scriptinglogic.net");

        test.info("url is opened");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("");

        test.info("username is entered");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("");
        test.info("password is entered");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();
        test.info("login button is clicked");

        String expected = "PLEASE ENTER A USERNAME";
        String actual = "";
        try {
            actual = driver.findElement(By.xpath("//label[@for='login-username' and @class='error']")).getText();
        }
        catch (Exception e)
        {

        }

        try {
            Assert.assertEquals(actual, expected, "incorrect error message or error message absent");
            test.pass("Test is passed");
        }
        catch (Exception e)
        {
            test.fail(e.getMessage());
        }

    }


}
