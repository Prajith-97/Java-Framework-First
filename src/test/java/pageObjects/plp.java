package pageObjects;

import org.json.simple.parser.ParseException;
import utility.readDataFromJson;
import java.io.IOException;

public class plp {

    static String  productName;
    static String cartProductName;

    static {
        try {
            productName = readDataFromJson.readData("name");
            cartProductName = readDataFromJson.readData("cartProductName");
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String dropdown = "product_sort_contai";
    public static String product_name = "//div[@class='inventory_item_label']//a//div[text()="+productName+"]";
    public static String addToCart = "//button[contains(@name,"+cartProductName+")]";
}
