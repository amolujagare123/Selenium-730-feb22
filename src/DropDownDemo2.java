import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownDemo2 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.lifepartner.in/");

       WebElement brideGroom = driver.findElement(By.name("bg"));
       Select selBrideGroom = new Select(brideGroom);

       Thread.sleep(4000);
       selBrideGroom.selectByIndex(1);

       WebElement ofAge = driver.findElement(By.id("sel1"));
       Select selOfAge = new Select(ofAge);

       Thread.sleep(4000);
       selOfAge.selectByVisibleText("35");

        WebElement toAge = driver.findElement(By.id("sel2"));
        Select selToAge = new Select(toAge);
        Thread.sleep(4000);
        selToAge.selectByVisibleText("40");

        WebElement community = driver.findElement(By.name("cm"));
        Select selCommunity = new Select(community);
        Thread.sleep(4000);
        selCommunity.selectByIndex(12);

    }
}
