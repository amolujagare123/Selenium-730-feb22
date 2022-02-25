package ListnersDemo.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentInit {

    public static ExtentReports initExtentObject()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Report2\\report.html");
        ExtentReports extent = new ExtentReports();

        reporter.config().setReportName("Regression tests");
        reporter.config().setDocumentTitle("All sites");

        extent.attachReporter(reporter);

        extent.setSystemInfo("Developers Name","Kiran");
        extent.setSystemInfo("Testers Name","Ashok");
        extent.setSystemInfo("Project Name","Stock Management system");
        extent.setSystemInfo("Start Date","23-03-22");
        extent.setSystemInfo("Deadline","23-04-22");

        return extent;
    }

    public static String webScreenshotForListeners(WebDriver driver) throws IOException {


        // 1. create an object reference of TakesScreenshot --> say ts
        // assign driver to it ,typecast driver into TakesScreenshot
        TakesScreenshot ts = (TakesScreenshot) driver;

        // 2. using the object reference ts call the method getScreenshotAS()
        File srcFile = ts.getScreenshotAs(OutputType.FILE);

        String timeStamp = new SimpleDateFormat("_yyyyddMM_hhmmss").format(new Date());
        String fileName = "IMG"+timeStamp+".png";

        // 3. copy file object into a real image file
        FileUtils.copyFile(srcFile,new File("Report2\\screenshots\\"+fileName));

        return fileName;
    }
}
