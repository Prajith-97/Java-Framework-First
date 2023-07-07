package glueCode;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.loginPage;
import utility.generateLog;
import utility.readDataFromJson;
import java.io.IOException;

public class test_login {

        public static WebDriver driver;  //declared as static for accessing to other methods


        public test_login(WebDriver driver){
            test_login.driver = driver;
        }
        public static void launchBrowser() throws IOException, ParseException {
            driver.get(readDataFromJson.readData("url"));
            generateLog.log("info", "Launched the URL, customer is on homepage");

        }

        public static void enterUsername(String username){
            WebElement element = driver.findElement(By.xpath(loginPage.textBox_userName));
            element.sendKeys(username);
        }

        public static void enterPassword(String password){
            WebElement element = driver.findElement(By.xpath(loginPage.textBox_password));
            element.sendKeys(password);
        }

        public static void clickLoginButton(){
            WebElement element = driver.findElement(By.xpath(loginPage.login_button));
            element.click();
        }

        public static void verify(){
            Assert.assertEquals(driver.getTitle(), "Swag Labs");
        }

        public static void enterUsernameAndPassword(String username, String password){
            driver.findElement(By.xpath(loginPage.textBox_userName)).sendKeys(username);
            driver.findElement(By.xpath(loginPage.textBox_password)).sendKeys(password);
        }
}




