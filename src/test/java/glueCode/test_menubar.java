package glueCode;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.menubar;
import utility.readDataFromJson;

import java.io.IOException;
import java.lang.invoke.CallSite;
import java.time.Duration;

public class test_menubar {
    public static WebDriver driver = null;
    public static String fontWeight;

    public test_menubar(WebDriver driver){
       test_menubar.driver = driver;
       PageFactory.initElements(driver, menubar.class);
    }

    public static void launchWebPage() throws IOException, ParseException {
        try{
            WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get(readDataFromJson.readData("url"));
            JavascriptExecutor js = (JavascriptExecutor)driver;
            wait.until(webDriver -> js.executeScript("return document.readyState").equals("complete"));
            String url = driver.getCurrentUrl();
            Assert.assertEquals(url, readDataFromJson.readData("url"));
        }catch (Exception e){
            throw e;
        }

    }
    public static void clickLogo(){
        try{
            menubar.logo.click();
        }catch (Exception e){
            throw e;
        }
    }
    public static void verifyHomepage(){
        try{
            String title = driver.getTitle();
            Assert.assertEquals(title, "Cole Haan | Shoes, Bags and Accessories for Men and Women");
        }catch (Exception e){
           throw e;
        }
    }
    public static void  mouseHover(String menuNav){
        try{
            for(WebElement ele:menubar.topMenuNav){
                if(ele.getText().equalsIgnoreCase(menuNav)){
                    Actions act = new Actions(driver);
                    act.moveToElement(ele).perform();
                }
            }
        }catch (Exception e){
            throw e;
        }
    }
    public static void verifyDropdown(){
        try{
            menubar.dropdown.isDisplayed();
        }catch (Exception e){
            throw e;
        }
    }
    public static void checkDropdown(){
        try{
            menubar.dropdown.isDisplayed();
        }catch (Exception e){
            throw e;
        }
    }
    public static void mouseHoverElement(String categoryName){
        try{
            JavascriptExecutor js = (JavascriptExecutor) driver;
            for (WebElement e: menubar.level2Dropdown){
                if(e.getText().equalsIgnoreCase(categoryName)){
                    Actions act = new Actions(driver);
                    act.moveToElement(e).perform();
                    fontWeight = js.executeScript("return getComputedStyle(arguments[0]).fontWeight;", e).toString();
                }
            }
        }catch (Exception e){
            throw e;
        }
    }
    public static void verifyFont(String font) throws Exception {
        try {
           Assert.assertEquals(fontWeight, font);
        }catch (Exception e){
           throw new Exception(e);
        }
    }
    public static void clickCategory(String categoryName){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            for (WebElement e: menubar.level2Dropdown) {
                if (e.getText().equalsIgnoreCase(categoryName)) {
                    wait.until(ExpectedConditions.elementToBeClickable(e));
                    e.click();
                    break;
                }
            }
        }catch (Exception e){
            throw e;
        }
    }
    public static void verifyPlpPage(String plpPageHeader){
        try{
            String pageHeader = menubar.plpHeader.getText();
            Assert.assertEquals(pageHeader, plpPageHeader);
        }catch (Exception e){
            throw e;
        }
    }
}
