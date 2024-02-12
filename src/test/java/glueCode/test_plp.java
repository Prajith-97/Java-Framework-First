package glueCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pageObjects.plp;

public class test_plp {

    public static WebDriver driver;

    public test_plp(WebDriver driver) {   //constructor
        test_plp.driver = driver;
    }

    public static void selectDropdown() {
        driver.findElement(By.className(plp.dropdown)).click();
    }

    public static void dropDownDisplayed(){
        System.out.println("dropdown displayed  ");
    }

    public static void mouseover() {
        Select dropdown = new Select(driver.findElement(By.className(plp.dropdown)));
        dropdown.selectByIndex(2);
    }
    public static void selectProduct(){
        driver.findElement(By.xpath(plp.product_name)).click();
    }
    public static void validatePdp(){
        System.out.println("Passed");
    }

    public static void addToCart(){
        driver.findElement(By.xpath(plp.addToCart)).click();
    }
    public static void checkCart(){
        System.out.println("Added to the cart");
    }
}