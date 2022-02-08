import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsDemo {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://stock.scriptinglogic.net");

      /*  WebElement txtElement = driver.findElement(By.tagName("input"));
        txtElement.sendKeys("abdcefg");*/

        List<WebElement> wbList = driver.findElements(By.tagName("input"));

        System.out.println(wbList.size()); //3

        wbList.get(0).sendKeys("admin"); // username
        wbList.get(1).sendKeys("admin");
        wbList.get(2).click();


    }
}
