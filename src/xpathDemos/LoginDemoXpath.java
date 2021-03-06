package xpathDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginDemoXpath {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys("admin");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys("admin");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();

       // WebElement lnkAddCustomer = driver.findElement(By.xpath("//a[@href='add_customer.php']"));
        WebElement lnkAddCustomer = driver.findElement(By.xpath("//a[text()='Add Customer']"));


        lnkAddCustomer.click();

        WebElement txtName = driver.findElement(By.xpath("//input[@name='name']"));
        txtName.sendKeys("Karthick");

        WebElement txtAddress = driver.findElement(By.xpath("//textarea"));
        txtAddress.sendKeys("xyz");

        WebElement txtContact1 = driver.findElement(By.xpath("//input[@name='contact1']"));
        txtContact1.sendKeys("78787878");

        WebElement txtContact2 = driver.findElement(By.xpath("//*[@name='contact2']"));
        txtContact2.sendKeys("1278787");

        WebElement btnAdd = driver.findElement(By.xpath("//input[@value='Add']"));
        btnAdd.click();


        driver.findElement(By.xpath("//a[text()='Log out']")).click();




    }
}
