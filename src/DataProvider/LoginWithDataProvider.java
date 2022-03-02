package DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginWithDataProvider {

    @Test (dataProvider = "getData")
    public void loginTest(String username , String password)
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        WebElement txtUsername = driver.findElement(By.xpath("//input[@type='text']"));
        txtUsername.sendKeys(username);

        WebElement txtPassword = driver.findElement(By.xpath("//input[@type='password']"));
        txtPassword.sendKeys(password);

        WebElement btnLogin = driver.findElement(By.xpath("//input[@value='LOG IN']"));
        btnLogin.click();
    }

    @DataProvider /*(name = "myDataProvider")*/
    public Object[][] getData()
    {
        Object[][] data= new Object[4][2]; // row x col
                                           // records x inputs
        data[0][0] = "admin";
        data[0][1] = "admin"; // 1st row

        data[1][0] = "abc";
        data[1][1] = "xyz"; // 2nd row

        data[2][0] = "aaa";
        data[2][1] = "bbb"; // 3rd row

        data[3][0] = "";
        data[3][1] = ""; // 4th row

        return data;
    }
}
