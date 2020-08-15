package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class AddressForm_Page {
    private static WebDriver driver;

    public AddressForm_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "alias") WebElement myAlias;
    public void inputAlias(String alias) {
        myAlias.click();
        myAlias.sendKeys(alias);
    }// Alias field

    @FindBy(name = "address1") WebElement myAddress;
    public void inputAddress(String address) {
        myAddress.click();
        myAddress.sendKeys(address);
    }// Address field

    @FindBy(name = "postcode") WebElement myPostcode;
    public void inputPostcode(String postcode) {
        myPostcode.click();
        myPostcode.sendKeys(postcode);
    }// Zip/Postcode field

    @FindBy(name = "city") WebElement myCity;
    public void inputCity(String city) {
        myCity.click();
        myCity.sendKeys(city);
    }// City field

    @FindBy(name = "id_country") WebElement myCountryField;
    @FindBy(css = "select.form-control > option:nth-child(2)")
    List<WebElement> myCountries;
    public void chooseCountry() {
        myCountryField.click();
        myCountries.get(0).click();
    }// Country Box

    @FindBy(css = "footer.clearfix > button") WebElement submit;
    public void clickSubmitButton() {
        submit.isEnabled();
        submit.isDisplayed();
        submit.click();
    }

    public String getMyAlias()    { return myAlias.getAttribute("value"); }
    public String getMyAddress()  { return myAddress.getAttribute("value"); }
    public String getMyPostcode() { return myPostcode.getAttribute("value"); }
    public String getMyCity()     { return myCity.getAttribute("value"); }
    public String getMyCountry()  { return myCountries.get(0).getText(); }

}

