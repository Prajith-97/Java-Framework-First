//package utility;
//
//import glueCode.test_login;
//import glueCode.test_productlisting;
//import io.cucumber.java.*;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//public class webDriverManager {
//
//    public static WebDriver driver;
//    static test_login login;
//    static test_productlisting plp;
//
//
//    @BeforeAll
//    public static void launchDriver(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//    }
//
//    @Before
//    public static void pageObjects(){
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//         login = new test_login(driver);
//         plp = new test_productlisting(driver);
//    }
//}
