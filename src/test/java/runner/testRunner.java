package runner;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import glueCode.test_login;
import glueCode.test_menubar;
import glueCode.test_plp;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.it.Data;
import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.TestNGCucumberRunner;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import utility.testDataProvider;
import utility.webDriverManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static utility.webDriverManager.driver;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\JavaIntellij\\Framework\\src\\test\\resources\\features\\login.feature",
        glue = {"stepDefs"},
        plugin = {"html:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.html",
                "json:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.json",
                "junit:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})
//                "rerun:C:\\JavaIntellij\\Framework\\target\\rerun.txt"})


public class testRunner extends AbstractTestNGCucumberTests {

    static test_login login;
    static test_plp plp;

    static test_menubar menu;
//    ExtentReports extentReport;
//    ExtentSparkReporter sparkReporter;



    @BeforeTest
    @Parameters({"browser-name"})
    void setUp(String browserName) {
//        String featurePath="C:\\JavaIntellij\\Framework\\src\\test\\resources\\features\\login.feature";
//        System.setProperty("cucumber.features", featurePath);
        webDriverManager.launchDriver(browserName);
//        extentReport = new ExtentReports();
//        File file = new File("C:\\JavaIntellij\\Framework\\src\\test\\reports\\Report.html");
//        sparkReporter = new ExtentSparkReporter(file);
//        extentReport.attachReporter(sparkReporter);

    }

    @BeforeClass
    public void beforeClass() {
        login = new test_login(driver);
        plp = new test_plp(driver);
        menu = new test_menubar(driver);

    }

//     @AfterTest
//     public void afterTest(){
//       extentReport.createTest("Test1")
//                       .log(Status.SKIP, "Skipped")
//                       .log(Status.FAIL, "Failed")
//                        .log(Status.PASS, "Passed");
//
//
//        extentReport.flush();
//     }
    @BeforeSuite

    public void beforeSuite(){
        String logFilePath = "C:\\JavaIntellij\\Framework\\src\\test\\reports\\Log.log";

        // Create a File object for the log file
        File logFile = new File(logFilePath);

        // Check if the log file exists
        if (logFile.exists()) {
            // Delete the log file
            if (logFile.delete()) {
                System.out.println("Log file deleted successfully.");
            } else {
                System.err.println("Failed to delete the log file.");
            }
        } else {
            System.out.println("Log file does not exist.");
        }
    }


//    @Test(dataProvider = "featureFilePath", dataProviderClass = testDataProvider.class)
//    public void runCucumber(String featureName){
//        if(Objects.equals(executionFlag, "Y")){

//            String featurePath="C:\\JavaIntellij\\Framework\\src\\test\\resources\\features\\login.feature";
//            System.setProperty("cucumber.features", featureName);
//        }

//    }
//    @Test(dataProvider = "featureFileDetails", dataProviderClass = testDataProvider.class)
//    public void runCucumber(String featureFilePath, String executionFlag){

//         String[] argv = {
//                "--glue", "stepdefs",
//                "--plugin", "html:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.html",
//                "--plugin", "json:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.json",
//                "--plugin", "junit:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.xml",
//                "--plugin","com.cucumber.listener.ExtentCucumberFormatter:target/reports\\extentReport.xml",
//                "--plugin", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
//                "--plugin", "rerun:C:\\JavaIntellij\\Framework\\target\\rerun.txt",
//                "--tags","@smoke",
//                featureFilePath
//        };
//        io.cucumber.core.cli.Main.run(argv, Thread.currentThread().getContextClassLoader());
//    }





//    public  void setExtent(){
//        ExtentReports extentReporter = new ExtentReports();
//        File file = new File("C:\\JavaIntellij\\Framework\\src\\test\\reports\\Report.html");
//        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
//        extentReporter.attachReporter(sparkReporter);
//        extentReporter.createTest("screenshot Test", "First").info("info");
//    }
}

