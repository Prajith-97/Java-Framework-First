package utility;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class reporterListener implements ITestListener {


       private ExtentReports extentReports;
       private ExtentTest scenario;

        @Override
        public void onStart(ITestContext context) {
            File file = new File("C:\\JavaIntellij\\SeleniumBasics\\report.html");
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
            extentReports.attachReporter(sparkReporter);
        }

        @Override
        public void onTestStart(ITestResult result) {
            // Create a new ExtentTest instance for the scenario
            scenario = extentReports.createTest(result.getMethod().getMethodName());
        }

        @Override
        public void onTestSuccess(ITestResult result) {
            scenario.log(Status.PASS,"Test passed");
        }

        @Override
        public void onTestFailure(ITestResult result) {
            scenario.log(Status.FAIL, "Test failed");
            // Capture and attach screenshots or other details as needed
        }

        @Override
        public void onFinish(ITestContext context) {
            // Flush ExtentReports to generate the report
            extentReports.flush();
        }

        // Additional methods to handle features and other details
    }

