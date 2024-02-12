package utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;


public class webDriverManager {

    public static WebDriver driver;

    public static void launchDriver(String browser){
        if (browser.toUpperCase().equals("CHROME")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
            driver.manage().window().maximize();

        } else if (browser.toUpperCase().equals("EDGE")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();

        }
    }
}
