package runner;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\JavaIntellij\\Framework\\src\\test\\resources\\features",
        glue = {"stepdefs"},
        plugin = {"html:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.html",
                "json:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.json",
                "junit:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:C:\\JavaIntellij\\Framework\\target\\rerun.txt"})


public class testRunner {

}
