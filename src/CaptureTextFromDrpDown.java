import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class CaptureTextFromDrpDown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/amol.html");

        List<WebElement> optionList = driver.findElements(By.xpath("//select[@id='seltext']/option"));

        ArrayList<String> drpList = new ArrayList<>();

        for (int i=0;i<optionList.size();i++)
            drpList.add(optionList.get(i).getText());

        System.out.println(drpList);
    }
}
