import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownDemo {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/amol.html");

       WebElement drpText = driver.findElement(By.id("seltext"));

        Select selText = new Select(drpText);

        Thread.sleep(4000);
       // selText.selectByVisibleText("text 3");
        //selText.selectByIndex(3);
        selText.selectByValue("v13");
    }
}
