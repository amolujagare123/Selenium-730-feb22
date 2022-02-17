package TestNGDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class TestNGDemo3 {
    WebDriver driver;

    @BeforeClass // method written below this annotation will run before every test method
    public void openBrowser()
    {
        WebDriverManager.chromedriver().setup();
       driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass // method written below this annotation will run after every test method
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(4000);
        driver.close();
    }

    @Test
    public void logintest1()
    {

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
      //  btnLogin.click();
    }

    @Test
    public void logintest2()
    {


        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("dsdsd");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("dsddss");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
      //  btnLogin.click();
    }

    @Test
    public void logintest3()
    {

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
       // btnLogin.click();
    }
}
