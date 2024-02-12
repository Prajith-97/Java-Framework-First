package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.gherkin.model.Feature;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Arrays;

public class iTestListenerImpl extends extentReportListener implements ITestListener {
    static ExtentReports extentreport;

    public void onStart(ITestContext context) {
        System.out.println("onStart method started");
        try {
           extentreport = extentReportListener.setUp();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void onFinish(ITestContext context) {
        System.out.println("onFinish method started");
        extentreport.flush();
//        System.out.println("e");
    }

    public void onTestStart(ITestResult result) {
        String associatedPath = Arrays.toString(result.getParameters());
        String path = associatedPath.substring(associatedPath.indexOf("features\\"), associatedPath.indexOf(".feature"));
        test = extent.createTest(Feature.class, path);
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess Method");
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure Method");
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped Method");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("onTestFailedButWithinSuccessPercentage");
    }

}
