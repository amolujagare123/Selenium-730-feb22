package xpathDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomerList {

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

        driver.findElement(By.xpath("//a[text()='Add Customer']")).click();
        driver.findElement(By.xpath("//a[text()='View Customers']")).click();

        String name="Prerna";

      //  driver.findElement(By.xpath("//tr[td[text()='"+name+"']]//a[contains(@class,'edit')]")).click();
        driver.findElement(By.xpath("//tr[td[text()='"+name+"']]//input")).click();


    }
}


