package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Page {

    static int Hummingbird_Printed_Sweater = 1;
    String sweterek = "1";

    public Home_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "article")
    List<WebElement> products;

    @FindBy(className = "regular-price")
    WebElement regularPrice;

    @FindBy(className = "current-price")
    WebElement currentPrice;

    public void clickProduct() {
        products.get(Hummingbird_Printed_Sweater).isEnabled();
        products.get(Hummingbird_Printed_Sweater).click();
    }

    public void chooseItem(int product){
        products.get(product).isEnabled();
        products.get(product).click();
    }
}
