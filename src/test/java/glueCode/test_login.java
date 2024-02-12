package glueCode;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import pageObjects.loginPage;
import utility.generateLog;
import utility.readDataFromJson;
import java.io.IOException;

public class test_login {

        public static WebDriver driver;  //declared as static for accessing to other methods


        public test_login(WebDriver driver){
            test_login.driver = driver;
            PageFactory.initElements(driver, loginPage.class); //while creating the object, constructor is called and this step helps to initialize all the elements in the page
        }

        public static void launchBrowser() throws IOException, ParseException {
            driver.get(readDataFromJson.readData("url"));
            generateLog.log("info", "Launched the URL, customer is on homepage");

        }

        public static void enterUsername(String username) throws Exception {
            try {
                loginPage.textBox_userName.sendKeys(username);
            }
            catch (Exception e){
                throw new Exception(e);
            }
        }

        public static void enterPassword(String password) throws Exception {
            try{
                loginPage.textBox_password.sendKeys(password);
//                org.testng.Assert.assertEquals(2.1,21);
            }catch (Exception e){
                throw new Exception(e);
            }

            }

        public static void clickLoginButton() throws Exception {
            try{
                loginPage.login_button.click();
                generateLog.log("info", "Clicked login button");
            }catch (Exception e){
                throw new Exception("Element not found");
            }

        }

        public static void verify(){
            Assert.assertEquals(driver.getTitle(), "Swag Labs");
        }

        public static void enterUsernameAndPassword(String username, String password){
            loginPage.textBox_userName.sendKeys(username);
            loginPage.textBox_password.sendKeys(password);
            generateLog.log("info", "Entered username and password");
        }

}




