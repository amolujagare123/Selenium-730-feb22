package TestNGDemo.AllSites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialSites {

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
        Thread.sleep(2000);
        driver.close();
    }


    @Test (priority = 1)
    public void twitter()
    {
        driver.get("http://twitter.com");
        Assert.assertEquals(true,false,"this test is failed");
    }

    @Test  (priority = 2)
    public void linkedIn()
    {
        driver.get("http://linkedIn.com");
    }

    @Test  (priority = 3)
    public void facebook()
    {
        driver.get("http://facebook.com");
    }

    @Test  (priority = 4)
    public void instagram()
    {
        driver.get("http://instagram.com");
    }

}
