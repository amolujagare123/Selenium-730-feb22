package AssertsExamples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginButtonScenario {

    @Test
    public void loginButtontest1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

        String expected = "LOG IN";

        String actual = "";

        try {
            actual = driver.findElement(By.name("submit")).getAttribute("value");
        }
        catch (Exception e)
        {

        }
        System.out.println("Expected="+expected);
        System.out.println("Actual="+actual);
        Assert.assertEquals(actual,expected,"wrong text on the login button");

    }
}
