package stepdefs;

import glueCode.test_login;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.core.gherkin.Step;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.extentReportListener;
import utility.generateLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static stepdefs.loginStepDefs.exception;

public class hooks extends extentReportListener {

    private static List<String> scenarioTags = new ArrayList<>();
    @Before
    public void beforeScenario(Scenario scenario){
//        this.scenario = scenario;
        // Store scenario tags as context

//        test.assignCategory(String.valueOf(scenario.getSourceTagNames()));
        scenarioTags.clear();
    }

    @After
    public static void afterScenario(Scenario scenario) {
        scenarioTags.clear();
        // Add scenario tags to the extent test
        scenarioTags.addAll(scenario.getSourceTagNames());
        // Set the categories for the extent test
        for (String tag : scenarioTags) {
            test.assignCategory(tag);
        }
        System.out.println(scenario.getStatus());
//        if (scenario.isFailed()) {
//            String e = Arrays.toString(exception.getStackTrace());
//            String logLevel = String.valueOf(generateLog.logger.getContext().getConfiguration().getLoggerConfig(generateLog.logger.getName()).getLevel());
//            System.out.println(logLevel);
//            generateLog.log(logLevel, e);
//
//        }


    }
//   @AfterStep
//    public static void afterStep(Step step){
//        if(exception.getStackTrace()==null){
//            System.out.println("passed");
//        }else {
//            System.out.println("failed");
//            String e = Arrays.toString(exception.getStackTrace());
//            String logLevel = String.valueOf(generateLog.logger.getContext().getConfiguration().getLoggerConfig(generateLog.logger.getName()).getLevel());
//            System.out.println(logLevel);
//            generateLog.log(logLevel, e);
//       }
//   }
    }


