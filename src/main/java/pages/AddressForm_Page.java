package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddressForm_Page {
    public static WebDriver driver;

    // Constructor
    public AddressForm_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "alias")
    WebElement alias;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "postcode")
    WebElement postcode;

    @FindBy(css = "select[name='id_country']")
    WebElement country;

    @FindBy(xpath = "//option[text()='United Kingdom']")
    WebElement countryChoose;

    @FindBy(css = "input[name='phone']")
    WebElement phone;

    public void formFiller(String myAlias){
       // alias.isEnabled();
        alias.sendKeys(myAlias);
    }
}


