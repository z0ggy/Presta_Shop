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
    @FindBy(css = "form > footer > button")
    WebElement continueButton;
    @FindBy(css = ".delivery-option .custom-radio > input")
    List<WebElement> deliveryOption;
    @FindBy(css = "span.custom-radio>input#delivery_option_1")
    WebElement deliveryOptionPresta;
    @FindBy(css = "#js-delivery > button")
    WebElement orderContinueButton;
    @FindBy(css = "input.ps-shown-by-js[type='radio']") List<WebElement> paymentOptions;

    public void fillAddressOrderPage() {
        address.click();
        address.sendKeys("Upper lane");
        postcode.click();
        postcode.sendKeys("013542");
        city.click();
        city.sendKeys("London");
        countries.get(1).click();
    }

    public void clickContinue() {
        continueButton.isDisplayed();
        continueButton.click();
    }

    // .get(0) is for presta shop ; .get(1) courier
    public void choosePrestaShopDelivery() {
        if (deliveryOption.get(0).isSelected()) {
            orderContinueButton.click();
        } else {
            deliveryOption.get(0).click();
        }
    }

}