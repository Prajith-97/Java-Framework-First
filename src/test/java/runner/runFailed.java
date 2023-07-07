package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "@target\\rerun.txt",
        glue = {"stepdefs"},
        plugin = {"html:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.html",
                "json:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.json",
                "junit:C:\\JavaIntellij\\Framework\\src\\test\\reports\\cucumberReport.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "rerun:C:\\JavaIntellij\\Framework\\target\\rerun.txt"})

public class runFailed {
}
