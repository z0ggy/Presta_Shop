package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmation_Page {

    public OrderConfirmation_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
