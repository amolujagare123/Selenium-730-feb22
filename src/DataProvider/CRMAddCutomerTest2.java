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

public class CRMAddCutomerTest2 {

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
    public void addCustomerTest(String Title,String FirstName,String LastName,
                                String Email,String Mobile,String Street ,
                                String City,String State,String PostalCode,
                                String Country,String Discription)
    {
        driver.findElement(By.cssSelector("span.fa-id-badge")).click();

    /*    try {
           // if(driver.findElement(By.xpath("//button[normalize-space()='Yes']")).isDisplayed())
             driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        }
        catch (Exception e)
        {

        }*/

        /*boolean flag=false;

        try {

            flag=driver.findElement(By.xpath("//button[normalize-space()='Yes']")).isDisplayed();
        }
        catch (Exception e)
        {

        }

        if (flag)
            driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();*/

        try {

            if (count!=0)
                driver.findElement(By.xpath("//button[normalize-space()='Yes']")).click();
        }
        catch (Exception e)
        {

        }

        count++;


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.findElement(By.xpath("//a[@class='btn btn-default action']")).click();

        WebElement name =driver.findElement(By.xpath("//select[@data-name='salutationName']"));
        Select selName = new Select(name);
        selName.selectByVisibleText(Title);

        WebElement firstName =driver.findElement(By.xpath("//input[@placeholder='First Name']"));
        firstName.sendKeys(FirstName);

        WebElement lastName =driver.findElement(By.xpath("//input[@placeholder='Last Name']"));
        lastName.sendKeys(LastName);

        WebElement email =driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys(Email);

        WebElement mobile =driver.findElement(By.xpath("//input[@type='input']"));
        mobile.sendKeys(Mobile);

        WebElement street =driver.findElement(By.xpath("//textarea[@placeholder='Street']"));
        street.sendKeys(Street);

        WebElement city =driver.findElement(By.xpath("//input[@placeholder='City']"));
        city.sendKeys(City);

        WebElement state =driver.findElement(By.xpath("//input[@placeholder='State']"));
        state.sendKeys(State);

        WebElement postalCode =driver.findElement(By.xpath("//input[@placeholder='Postal Code']"));
        postalCode.sendKeys(PostalCode);

        WebElement country =driver.findElement(By.xpath("//input[@placeholder='Country']"));
        country.sendKeys(Country);

        WebElement description =driver.findElement(By.xpath("//textarea[@class='main-element form-control auto-height']"));
        description.sendKeys(Discription);

        WebElement btnSave =driver.findElement(By.xpath("//button[normalize-space()='Save']"));
       // btnSave.click();


    }


    @DataProvider
    public Object[][] getData() throws IOException {

        return  getMyDataXLSX("Data/LoginDataXLS.xlsx","Sheet1");

    }

}
