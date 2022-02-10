import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioCheckBox2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///D:/amol.html");

        // click on the checkboxes which are not ticked / selected

        WebElement chekBoxJava = driver.findElement(By.id("check0"));
        WebElement chekBoxSelenium = driver.findElement(By.id("check1"));
        WebElement chekBoxCucumber = driver.findElement(By.id("check2"));

    /*    if (chekBoxJava.isSelected()==false)
            chekBoxJava.click();

        if (chekBoxSelenium.isSelected()==false)
            chekBoxSelenium.click();

        if (chekBoxCucumber.isSelected()==false)
            chekBoxCucumber.click();*/

        if (!chekBoxJava.isSelected())
            chekBoxJava.click();

        if (!chekBoxSelenium.isSelected())
            chekBoxSelenium.click();

        if (!chekBoxCucumber.isSelected())
            chekBoxCucumber.click();


    }
}
