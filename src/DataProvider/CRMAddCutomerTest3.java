package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

import static DataProvider.util.DataProviderUtil.getMyData;
import static DataProvider.util.DataProviderUtil.getMyDataXLSX;

public class CRMAddCutomerTest3 {

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

    static int count=0;

    @Test (dataProvider = "getData")
    public void addCustomerTest(String title1,String firstName1,String lastName1,
                                String email1,String mobile1,String street1 ,
                                String city1,String state1,String postalCode1,
                                String country1,String discription1)
    {
        driver.findElement(By.cssSelector("span.fa-id-badge")).click(); // contact

       /* try {
            driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        }
        catch (Exception e)
        {

        }*/

        if (count!=0)
            driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();


        count++;

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       // driver.findElement(By.xpath("//a[@class='btn btn-default action']")).click();
        driver.findElement(By.xpath("//a[normalize-space()='Create Contact']")).click();
        // add contact //a[normalize-space()='Create Contact']


        WebElement name =driver.findElement(By.xpath("//select[@data-name='salutationName']"));
        Select selName = new Select(name);
        selName.selectByVisibleText(title1);


        WebElement firstName =driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys(firstName1);

        WebElement lastName =driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys(lastName1);

        WebElement email =driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(email1);

        WebElement mobile =driver.findElement(By.xpath("//input[@type='input']"));
        mobile.sendKeys(mobile1);

        WebElement street =driver.findElement(By.xpath("//textarea[@placeholder='Street']"));
        street.sendKeys(state1);

        WebElement city =driver.findElement(By.xpath("//input[@placeholder='City']"));
        city.sendKeys(city1);

        WebElement state =driver.findElement(By.xpath("//input[@placeholder='State']"));
        state.sendKeys(state1);

        WebElement postalCode =driver.findElement(By.xpath("//input[@placeholder='Postal Code']"));
        postalCode.sendKeys(postalCode1);

        WebElement country =driver.findElement(By.xpath("//input[@placeholder='Country']"));
        country.sendKeys(country1);

        WebElement textArea =driver.findElement(By.xpath("//textarea[@class='main-element form-control auto-height']"));
        textArea.sendKeys(discription1);

        WebElement btnSave =driver.findElement(By.xpath("//button[normalize-space()='Save']"));
        //btnSave.click();


    }


    @DataProvider
    public Object[][] getData() throws IOException {

        return  getMyDataXLSX("Data/LoginDataXLS.xlsx","Sheet1");

    }
}
