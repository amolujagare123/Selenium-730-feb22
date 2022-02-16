package xpathDemos;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenClinicStaffList {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("http://openclinic.sourceforge.net/openclinic/admin/staff_list.php");

        String name="Hayan";

      //  driver.findElement(By.xpath("//tr[td[text()='"+name+"']]/td/a/img[@alt='edit']")).click();
        driver.findElement(By.xpath("//tr[td[text()='"+name+"']]//img[@alt='edit']")).click();

    }
}


