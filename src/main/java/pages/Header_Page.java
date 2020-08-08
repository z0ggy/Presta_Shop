package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header_Page {

    public Header_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    // View my customer account
    @FindBy(css = "a.account")
    WebElement myAccount;

    // Click on My Account
    public void goToMyAccountPage() {
        myAccount.click();
    }
}