package stepdefs;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Scenario;
import glueCode.test_plp;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utility.extentReportListener;

import java.io.IOException;

import static glueCode.test_login.driver;

public class plpStepDefs extends extentReportListener {
    ExtentTest logInfo = null;
    public static Throwable exception = null;
    @When("user clicks on the dropdown box")
    public void userClicksOnTheDropdownBox() throws ClassNotFoundException, IOException {
        try{
//            test = test.createNode(Scenario.class, "Validate mouse-hover sort dropdown");
//            logInfo = test.createNode(new GherkinKeyword("When"), "user clicks on the dropdown box");
            test_plp.selectDropdown();
        }catch(Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            exception = e;
        }

    }
    @Then("dropdown should appear")
    public void dropdownShouldAppear() throws IOException {
        try{
//            logInfo = test.createNode(new GherkinKeyword("Then"), "dropdown should appear");
            test_plp.dropDownDisplayed();
        }catch (Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            exception = e;
        }

    }
    @And("user mouseover through the dropdown")
    public void usermousehoverThroughTheDropdown() throws IOException {
        try {
//            logInfo = test.createNode(new GherkinKeyword("And"), "user mouseover through the dropdown");
            test_plp.mouseover();
        }catch (Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
            exception = e;
        }

    }

    @When("user selects the product")
    public void userSelectsTheProduct() {
        test_plp.selectProduct();
    }

    @Then("user redirects to the pdp page")
    public void userRedirectsToThePdpPage() {
        test_plp.validatePdp();
    }

    @When("user clicks on the add to cart button")
    public void user_clicks_on_the_add_to_cart_button() {
        test_plp.addToCart();
    }
    @Then("product should get added to the cart")
    public void product_should_get_added_to_the_cart() {
        test_plp.checkCart();
    }
}
