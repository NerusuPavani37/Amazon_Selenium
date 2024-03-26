package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.baseClass.base;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;
import static com.baseClass.base.driver;

public class ExtentReportManager implements ITestListener
{
    public ExtentSparkReporter sparkReporter;
    public ExtentReports extent;
    public ExtentTest test;

    String repName;
    base b;


    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
        repName="Test-Report-"+timeStamp+".html";

        sparkReporter=new ExtentSparkReporter("./report/"+repName);//specify location of the report

        sparkReporter.config().setDocumentTitle("Selenium_Auntomation"); // Title of report
        sparkReporter.config().setReportName("amazon website"); // name of the report
        sparkReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(sparkReporter);
        extent.setSystemInfo("Application", "Amazon");
        extent.setSystemInfo("Operating System", System.getProperty("os.name"));
        extent.setSystemInfo("User Name", System.getProperty("user.name"));
        extent.setSystemInfo("Environemnt","QA");
        extent.setSystemInfo("user","pavani");
    }


    public void onTestSuccess(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.createNode(result.getName());
        b = new base();
        b.captureScreenshot();
        test.log(Status.PASS, "Test Passed");
    }

    public void onTestFailure(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.FAIL, "Test Failed");
        test.log(Status.FAIL, result.getThrowable().getMessage());
        b = new base();
        b.captureScreenshot();
    }

    public void onTestSkipped(ITestResult result)
    {
        test=extent.createTest(result.getName());
        test.createNode(result.getName());
        test.assignCategory(result.getMethod().getGroups());
        test.log(Status.SKIP, "Test Skipped");
        test.log(Status.SKIP, result.getThrowable().getMessage());
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }

}