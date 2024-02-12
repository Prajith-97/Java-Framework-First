package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class menubar {
    @FindBy(xpath = "//div[@class='logo float-md-none text-center']//child::img")
    public static WebElement logo;

    @FindBy(xpath = "//div[@class='main-nav nav-desktop']//ul[@class='menu-category level-1 d-flex justify-content-center clearfix float-md-left float-lg-none']//li//a//div")
    public static List<WebElement> topMenuNav;

    @FindBy(xpath = "//div[@class='main-nav nav-desktop']//ul[@class='menu-category level-1 d-flex justify-content-center clearfix float-md-left float-lg-none']//li//a//div//span[@class='d-none d-md-inline']")
    public static WebElement dropdown;

    @FindBy(xpath="//div[@class='main-nav nav-desktop']//ul[@class='menu-category level-1 d-flex justify-content-center clearfix float-md-left float-lg-none']//li//a/following-sibling::div//child::ul[@class='level-2']/child::li//div[@class='level-3']/child::ul[@class='level-3']//li/child::a")
    public static List<WebElement> level2Dropdown;

    @FindBy(xpath = "//div[@class='container header-container']//h1")
    public static WebElement plpHeader;
}
