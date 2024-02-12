package stepdefs;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;
import com.github.dockerjava.api.command.CreateServiceCmd;
import glueCode.test_login;
import io.cucumber.java.en.*;
import org.openqa.selenium.NoSuchElementException;
import utility.extentReportListener;
import utility.generateLog;

import java.io.IOException;

import static glueCode.test_login.driver;


public class loginStepDefs extends extentReportListener {

//    @After
//    public static void afterScenario(Scenario scenario){
//        if (scenario.isFailed()){
//            String e = Arrays.toString(exception.getStackTrace());
//            generateLog.log("info", e);
//        }
//    }

    public static Throwable exception = null;
    ExtentTest logInfo = null;


    @Given("user is on homepage")
        public void user_is_on_homepage() throws Exception {
        try {
//            test = extent.createTest(Feature.class, "" );
            test = test.createNode(Scenario.class, "Validate login with valid credentials");
            logInfo = test.createNode(new GherkinKeyword("Given"), "user is on homepage");
            test_login.launchBrowser();
//            logInfo.pass("user is on homepage- step passed");
        } catch (NoSuchElementException e) {
            testStepHandle("FAIL", driver, logInfo, e);
            exception = e;

//                System.out.println(Arrays.toString(e.getStackTrace()));
        }
    }
        @And("user enter valid username {string}")
        public void user_enter_valid_username(String Username) throws Exception {
            try {
                logInfo = test.createNode(new GherkinKeyword("And"), "user enter valid username");
                test_login.enterUsername(Username);
//                logInfo.pass("user enter valid username- step passed");
            }catch (Exception e){
                testStepHandle("FAIL", driver, logInfo, e);
                exception = e;
//                throw new Exception();

            }
        }

        @And("user enter valid password {string}")
        public void user_enter_valid_password(String Password) throws Exception {
            try{
                logInfo = test.createNode(new GherkinKeyword("And"), "user enter valid password");
                test_login.enterPassword(Password);
//                logInfo.pass("user enter valid password");
            }catch (Exception e){
                testStepHandle("FAIL", driver, logInfo, e);
                exception =e;
                throw e;
            }

        }

        @When("user clicks on the login button")
        public void user_clicks_on_the_login_button() throws Exception {
            try{
                logInfo = test.createNode(new GherkinKeyword("When"), "user clicks on the login button");
                test_login.clickLoginButton();
//                logInfo.pass("user clicks on the login button- step passed");
            }catch (Exception e){
                testStepHandle("FAIL", driver, logInfo, e);
                exception =e;
            }

        }

        @Then("user should redirected to the customer page")
        public void user_should_redirected_to_the_customer_page() throws IOException {
        try{
            logInfo = test.createNode(new GherkinKeyword("Given"), "user should redirected to the customer page");
            test_login.verify();
//            logInfo.pass("user should redirected to the customer page- step passed");
        }catch (Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            generateLog.log("info", String.valueOf(e));
            exception =e;
        }

        }
        @And("user enter valid username {string} and {string}")
        public void userEnterValidUsernameAnd(String username, String password) throws IOException {
        try{
            logInfo = test.createNode(new GherkinKeyword("And"), "user enter valid username and password");
            test_login.enterUsernameAndPassword(username, password);
//            logInfo.pass("user enter valid username- step passed");
        }catch (Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            exception =e;
        }

        }
}

