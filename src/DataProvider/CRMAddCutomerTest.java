package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class CRMAddCutomerTest {

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
        driver.findElement(By.cssSelector("span.fa-id-badge")).click(); // contact


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       // driver.findElement(By.xpath("//a[@class='btn btn-default action']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Create Contact']")).click();
        // add contact //a[normalize-space()='Create Contact']


        WebElement name =driver.findElement(By.xpath("//select[@data-name='salutationName']"));
        Select selName = new Select(name);
        selName.selectByVisibleText("Dr.");


        WebElement firstName =driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys("Amol");

        WebElement lastName =driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys("Ujagare");

        WebElement email =driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("amol@gmail.com");

        WebElement mobile =driver.findElement(By.xpath("//input[@type='input']"));
        mobile.sendKeys("989898");

        WebElement street =driver.findElement(By.xpath("//textarea[@placeholder='Street']"));
        street.sendKeys("xyz road");

        WebElement city =driver.findElement(By.xpath("//input[@placeholder='City']"));
        city.sendKeys("xyz");

        WebElement state =driver.findElement(By.xpath("//input[@placeholder='State']"));
        state.sendKeys("MH");

        WebElement postalCode =driver.findElement(By.xpath("//input[@placeholder='Postal Code']"));
        postalCode.sendKeys("411001");

        WebElement country =driver.findElement(By.xpath("//input[@placeholder='Country']"));
        country.sendKeys("India");

        WebElement textArea =driver.findElement(By.xpath("//textarea[@class='main-element form-control auto-height']"));
        textArea.sendKeys("xyz nagar");

        WebElement btnSave =driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        //btnSave.click();
    }

}
