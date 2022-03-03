package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CRMAddCutomer {

    WebDriver driver;

    @BeforeClass
    public void doLogin()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("http://localhost/crm");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebElement txtUsername = driver.findElement(By.cssSelector("#field-userName"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.cssSelector("#field-password"));
        txtPassword.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.xpath("//button[@id='btn-login']"));
        btnLogin.click();
    }

    @Test
    public void addCustomerTest()
    {
        driver.findElement(By.cssSelector("span.fa-id-badge")).click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.cssSelector("span.fa-plus")).click();

    }

}
