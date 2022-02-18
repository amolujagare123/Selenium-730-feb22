package TestNGDemo.AllSites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TutorialsSite {

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


    @Test
    public void javatpoint()
    {
        driver.get("http://javatpoint.com");
    }

    @Test
    public void scriptinglogic()
    {
        driver.get("http://scriptinglogic.com");
    }

    @Test
    public void w3schools()
    {
        driver.get("https://w3schools.com/");
    }

    @Test
    public void geeksforgeeks()
    {
        driver.get("https://geeksforgeeks.org/");
    }

}
