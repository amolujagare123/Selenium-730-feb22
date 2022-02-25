package ExtentReportDemo.screenshotDemo;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtility {

    public static String webScreenshot(WebDriver driver) throws IOException {


        // 1. create an object reference of TakesScreenshot --> say ts
        // assign driver to it ,typecast driver into TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. using the object reference ts call the method getScreenshotAS()
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";

        // 3. copy file object into a real image file
        FileUtils.copyFile(srcFile,new File("Report\\screenshots\\"+fileName));

        return fileName;
    }
}
