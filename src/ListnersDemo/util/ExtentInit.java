package ListnersDemo.util;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

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
}
