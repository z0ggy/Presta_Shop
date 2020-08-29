package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Order_Page {

    public Order_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "address1")
    WebElement address;
    @FindBy(name = "postcode")
    WebElement postcode;
    @FindBy(name = "city")
    WebElement city;
    @FindBy(css = "div.col-md-6 > select > option")
    List<WebElement> countries;

    public void fillAddressOrderPage() {
        address.click();
        address.sendKeys("Upper lane");
        postcode.click();
        postcode.sendKeys("013542");
        city.click();
        city.sendKeys("London");
        countries.get(1).click();

    }
}