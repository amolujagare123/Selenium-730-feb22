import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class MultiSelectList1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/amol.html");

        WebElement multiSelect = driver.findElement(By.id("multiSel"));

        Select selMultiSelect = new Select(multiSelect);

        Thread.sleep(4000);

        selMultiSelect.selectByVisibleText("text 1");
        selMultiSelect.selectByVisibleText("text 3");
        selMultiSelect.selectByVisibleText("text 4");

        Thread.sleep(4000);
      /*  selMultiSelect.deselectByVisibleText("text 3");
        Thread.sleep(4000);
        selMultiSelect.deselectByVisibleText("text 4");*/

        selMultiSelect.deselectAll();
    }
}
