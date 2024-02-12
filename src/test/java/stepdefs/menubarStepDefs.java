package stepdefs;

import com.aventstack.extentreports.ExtentTest;
import glueCode.test_menubar;
import io.cucumber.java.en.*;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.interactions.Actions;
import pageObjects.menubar;

import java.io.IOException;

import static glueCode.test_login.driver;
import static utility.extentReportListener.testStepHandle;

public class menubarStepDefs {

    ExtentTest logInfo = null;
    @Given("user is on the homepage of the site")
    public void user_is_on_the_homepage() throws IOException, ParseException {
        test_menubar.launchWebPage();
    }
    @When("user clicks on the logo")
    public void user_clicks_on_the_logo() {
      test_menubar.clickLogo();
    }
    @Then("user should get redirected to homepage")
    public void user_should_get_redirected_to_homepage() {
        test_menubar.verifyHomepage();
    }
    @When("user mouse hover {string} on the menu bar")
    public void user_mouse_hover_on_the_menu_bar(String topNav) {
        test_menubar.mouseHover(topNav);
    }
    @Then("corresponding dropdown should be displayed")
    public void corresponding_dropdown_should_be_displayed() {
        test_menubar.verifyDropdown();
    }
    @Given("dropdown is displayed")
    public void dropdown_is_displayed() {
      test_menubar.checkDropdown();
    }
    @When("mouse hover the elements {string} in the dropdown")
    public void mouseHoverTheElementsInTheDropdown(String element) {
      test_menubar.mouseHoverElement(element);
    }
    @Then("element should appear in light color {string}")
    public void element_should_appear_in_bold_color(String font) throws Exception {
        try{
            Exception e = null;
            test_menubar.verifyFont(font);
            testStepHandle("FAIL", driver, logInfo, null);
        }catch (Exception e){
            testStepHandle("FAIL", driver, logInfo, e);
        }

    }
    @When("user clicks on the particular element {string} in the dropdown")
    public void userClicksOnTheParticularElementInTheDropdown(String categoryName) {
        test_menubar.clickCategory(categoryName);
    }

    @Then("user should redirected to corresponding PLP page {string}")
    public void userShouldRedirectedToCorrespondingPLPPage(String plpPageName) {
        test_menubar.verifyPlpPage(plpPageName);
    }
}
