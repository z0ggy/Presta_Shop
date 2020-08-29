package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order_Page {

    public Order_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    @FindBy(name = "address1")
    WebElement address;

    public void addAddress(String myAddress) {
        address.click();
        address.sendKeys("Upper lane");
    }
}
