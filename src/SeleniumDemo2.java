import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumDemo2 {

    public static void main(String[] args) throws InterruptedException {

         System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
         WebDriver driver = new ChromeDriver();

         driver.manage().window().maximize();

        driver.get("http://facebook.com");

        driver.navigate().to("http://google.com");
       // Thread.sleep(2000);
        driver.navigate().back();

      //  Thread.sleep(2000);

        driver.navigate().forward();
     //   Thread.sleep(2000);
        driver.navigate().refresh();

    }


}
