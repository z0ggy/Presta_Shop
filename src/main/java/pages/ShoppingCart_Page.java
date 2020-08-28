package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart_Page {

    public ShoppingCart_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
