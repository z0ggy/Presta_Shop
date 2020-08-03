package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ZadanieWar_1_Page {
    public static WebDriver driver;

    // Constructor
    public ZadanieWar_1_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//*[@id='content']/div/div/form/section/div[6]/div[1]/input")
    WebElement country;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "postcode")
    WebElement postcode;

    @FindBy(xpath = "//*[@id='content']//footer/button")
    WebElement submit;

    @FindBy(xpath = "//article[@class='alert alert-success'and @role='alert']/ul")
    WebElement successInformation;

    @FindBy(xpath = "//*[@class='addresses-footer']/a")
    WebElement newAddressClick;

    @FindBy(css = "#_desktop_user_info a.account > span")
    WebElement doskasowania;


    public void doSkasowania() {
        doskasowania.click();
    }




    public void addAddress(String address) {
        country.clear();
        country.sendKeys(address);
    }

    public void addCity(String myCity) {
        city.clear();
        city.sendKeys(myCity);
    }

    public  void addZip(String myZip) {
        postcode.clear();
        postcode.sendKeys(myZip);
    }

    public void submitButton() {
        submit.click();
    }
    public void getUpdateInformation() {
        System.out.println(successInformation.getText());
    }

    public void clickNewAddrr() {
        newAddressClick.click();
    }

}

