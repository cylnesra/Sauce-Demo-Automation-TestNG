package org.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.example.utilities.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportListener implements ITestListener {
    private ExtentReports extent;

    @Override
    public void onStart(ITestContext context) {
        String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String fileName = "target/test-output/MyExtentReport" + date + ".html";
        ExtentSparkReporter htmlReport = new ExtentSparkReporter(fileName);

        htmlReport.config().setReportName("Automation Test Results");
        htmlReport.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReport);

        extent.setSystemInfo("Browser", System.getProperty("browser", "defaultBrowser"));
        extent.setSystemInfo("OS", System.getProperty("os.name"));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.FAIL, "Test Failed");
        test.fail(result.getThrowable());

        if(result.getStatus() == ITestResult.FAILURE){
            if(driver instanceof TakesScreenshot){
                TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
                String base64ScreenShot = takesScreenshot.getScreenshotAs(OutputType.BASE64);
                String failedMethodName = result.getMethod().getMethodName();
                test.addScreenCaptureFromBase64String(base64ScreenShot,failedMethodName);
            }
        }
    }
    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        test.log(Status.SKIP, "Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}