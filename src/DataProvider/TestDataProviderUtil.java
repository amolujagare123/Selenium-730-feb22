package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static DataProvider.util.DataProviderUtil.getMyData;

public class TestDataProviderUtil {

    WebDriver driver;

    @BeforeClass
    public void doLogin()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();
    }

    @Test(dataProvider = "getData")
    public void addCustomerTest(String name,String add,String con1,String con2)
    {
        WebElement lnkAddCustomer = driver.findElement(By.linkText("Add Customer"));
        lnkAddCustomer.click();

        WebElement txtName = driver.findElement(By.name("name"));
        txtName.sendKeys(name);

        WebElement txtAddress = driver.findElement(By.name("address"));
        txtAddress.sendKeys(add);

        WebElement txtContact1 = driver.findElement(By.name("contact1"));
        txtContact1.sendKeys(con1);

        WebElement txtContact2 = driver.findElement(By.name("contact2"));
        txtContact2.sendKeys(con2);

        WebElement btnAdd = driver.findElement(By.name("Submit"));
        //  btnAdd.click();

    }

    @DataProvider
    public Object[][] getData() throws IOException {

     return  getMyData("Data/LoginData.xls","Add Customer 2");

    }
}
