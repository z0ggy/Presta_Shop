package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header_Page {
    public static WebDriver driver;

    // Constructor
    public Header_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // View my customer account
    @FindBy(css = "a.account") WebElement myAccount;
    public void goToMyAccountPage() { myAccount.click();}
}