package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class loginPage {

    @FindBy(xpath = "//input[@id='user-name']" )
    public static WebElement textBox_userName;

    @FindBy(xpath = "//input[@id='passw']")
    public static WebElement textBox_password;

    @FindBy(xpath = "//input[@id='login-button']" )
    public static WebElement login_button;
}
