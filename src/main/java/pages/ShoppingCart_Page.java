package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCart_Page {

    public ShoppingCart_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(css = "a.btn-primary")
    WebElement proceed;

    public void proceedToCheckout() {
        proceed.isDisplayed();
        proceed.click();
    }

}
