import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileButtonForFileSelection {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/amol.html");

        WebElement fileElement = driver.findElement(By.xpath("/html/body/input[1]"));
        fileElement.sendKeys("D:\\amol.txt");

        Thread.sleep(4000);
        //fileElement.sendKeys("D:\\chatserver1.json");

        driver.navigate().refresh();



    }
}
