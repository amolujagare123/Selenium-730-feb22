package xpathDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BillingDemo {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://billing.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@name='email']"));
        txtUsername.sendKeys("amolujagare@gmail.com");

        WebElement txtPassword = driver.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys("admin123");

        WebElement btnLogin = driver.findElement(By.xpath("//input[@name='btn_login']"));
        btnLogin.click();

       driver.findElement(By.xpath("//span[text()='Clients']")).click();
        driver.findElement(By.xpath("//a[text()='View Clients']")).click();

        String name = "Ajay Mathur";

        driver.findElement(By.xpath("//tr[td/a[text()='"+name+"']]//div")).click();

            //tr[td/a[text()='Ajay Mathur']]//li[2]

         //tr[td/a[text()='Ajay Mathur']]//i[contains(@class,'edit ')]

        //tr[td/a[text()='Ajay Mathur']]//div//a[contains(@href,'form')]

        //driver.findElement(By.xpath("//tr[td/a[text()='"+name+"']]//li[2]")).click();

       // driver.findElement(By.xpath("//tr[td/a[text()='"+name+"']]//i[contains(@class,'edit')]")).click();

        driver.findElement(By.xpath("//tr[td/a[text()='"+name+"']]//div//a[contains(@href,'form')]")).click();



    }
}
