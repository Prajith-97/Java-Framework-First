package stepdefs.hooks;

import glueCode.test_login;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class hooks {
    public static WebDriver driver;
    static test_login login;


    @BeforeAll
    public static void pageObjects(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        login = new test_login(driver);
    }
}
