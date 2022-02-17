package student;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/*import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;*/

public class PropDev3 {

	public static WebDriver driver;
	public static JavascriptExecutor js;
	//@Test
	@Test
	public void setUp() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		 
		  
		  System.out.println(" chrome browser is launched successfully");
		  
		  driver.get("https://www.google.com");
		 // Thread.sleep(6000);
		  driver.manage().window().maximize();
		//  Thread.sleep(6000);
		  
	
		  driver.navigate().to("https://www.propscience.com/");
		  //Thread.sleep(6000);
		  
		  takeScreenshot();
		  driver.findElement(By.xpath("//a[text()='Projects']")).click();
		//  Thread.sleep(6000);

		  takeScreenshot();

		//closing the webdriver
		driver.close();
 }
    
  //  @AfterMethod
    public void takeScreenshot()
    {
	
	       //Take the screenshot
	        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	        
	       
	        String filename = "IMG_"+new SimpleDateFormat("ddMMyyyy_hhmmss").format(new Date())+".png";	        //Copy the file to a location and use try catch block to handle exception
	        try {
	            FileUtils.copyFile(screenshot, new File("d:\\"+filename));
	        } catch (IOException e) {
	            System.out.println(e.getMessage());
	        }
	        
	       

			  
		   
	} 
	}
