package stepdefs;

import glueCode.test_login;
import io.cucumber.java.en.*;
import org.json.simple.parser.ParseException;

import java.io.IOException;



public class loginStepDefs {

//    public static WebDriver driver;
//    static test_login login;
//    static test_productlisting plp;
//
//    @BeforeAll
//    public static void pageObjects(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        login = new test_login(driver);
//        plp = new test_productlisting(driver);
//    }
        @Given("user is on homepage")
        public void user_is_on_homepage() throws IOException, ParseException {
            test_login.launchBrowser();
        }
        @And("user enter valid username {string}")
        public void user_enter_valid_username(String Username) {
            test_login.enterUsername(Username);
        }
        @And("user enter valid password {string}")
        public void user_enter_valid_password(String Password) {
            test_login.enterPassword(Password);
        }
        @When("user clicks on the login button")
        public void user_clicks_on_the_login_button() {
            test_login.clickLoginButton();
        }
        @Then("user should redirected to the customer page")
        public void user_should_redirected_to_the_customer_page() {
            test_login.verify();
        }
        @And("user enter valid username {string} and {string}")
        public void userEnterValidUsernameAnd(String username, String password) {
               test_login.enterUsernameAndPassword(username, password);
        }

}

