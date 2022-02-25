package TestNGDemo.AllSites;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites extends OpenCloseBrowser{



    @Test
    public void naukri()
    {
        driver.get("http://naukri.com");
    }

    @Test
    public void monster()
    {
        driver.get("http://monster.com");
    }

    @Test (enabled = false)
    public void shine()
    {
        driver.get("http://shine.com");
    }

    @Test
    public void timesjob()
    {
        driver.get("http://timesjobs.com");
    }

}
