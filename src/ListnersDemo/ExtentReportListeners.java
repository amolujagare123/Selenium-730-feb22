package ListnersDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static ListnersDemo.util.ExtentInit.initExtentObject;

public class ExtentReportListeners implements ITestListener {

    static ExtentReports extent;
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart");
        test = extent.createTest(result.getMethod().getMethodName());

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess");
        test.pass("This is passed");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure");
        test.info("This is fail");
        test.fail(result.getThrowable());

    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped");
        test.info("This is skipped");
        test.skip(result.getThrowable());
    }

   // before test tag in testng.xml
    public void onStart(ITestContext context) {

        if (extent==null)
           extent = initExtentObject();

    }

    // after test tag in testng.xml
    public void onFinish(ITestContext context) {
        //System.out.println("onFinish");

        extent.flush();
    }
}
