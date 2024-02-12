package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class extentReportListener {
    public static ExtentReports extent=null;

    public static ExtentSparkReporter reporter=null;
//    public static ExtentHtmlReporter reporter=null;
    public static ExtentTest test=null;

    public static ExtentReports setUp() throws IOException {
        String reportLocation = "C:\\JavaIntellij\\Framework\\src\\test\\reports\\extent_report.html";
//        reporter = new ExtentHtmlReporter(reportLocation);
        reporter = new ExtentSparkReporter(reportLocation);
        reporter.loadJSONConfig(new File("C:\\JavaIntellij\\Framework\\src\\test\\resources\\extentReport_config.json"));
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setReportUsesManualConfiguration(true);
        return extent;
    }
    public static void testStepHandle(String testStatus, WebDriver driver,ExtentTest extentTest, Throwable throwable) throws IOException {
        switch (testStatus){
            case "FAIL":
                extentTest.fail(MarkupHelper.createLabel("Test case failed", ExtentColor.RED));
                extentTest.fail(throwable.fillInStackTrace());
                String logLevel = String.valueOf(generateLog.logger.getContext().getConfiguration().getLoggerConfig(generateLog.logger.getName()).getLevel());
                generateLog.log(logLevel, String.valueOf(throwable));
                try{
                    extentTest.addScreenCaptureFromPath(captureScreenshot(driver));
                }catch (IOException e){
                    e.printStackTrace();
                }

                if(driver!= null) {
                    driver.quit();
                }
                break;
            case "PASS":
               extentTest.pass(MarkupHelper.createLabel("Test case passed", ExtentColor.GREEN));
               break;
            default:
                break;
        }
    }
    public static String captureScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("C:\\JavaIntellij\\Framework\\src\\test\\java\\utility\\screenshots\\"+getCurrentDateAndTime()+".png");
        FileUtils.copyFile(source,target);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(25));
        System.out.println(source.getAbsolutePath());
        return target.getAbsolutePath();
    }
    public static String getCurrentDateAndTime(){
        String str=null;
        try{
            DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
            Date date = new Date();
            str = dateFormat.format(date);
            str = str.replace(" ","").replaceAll("/","").replaceAll(":","");
        }catch (Exception e){
            System.out.println(e);
        }
        return str;

    }
}
