package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class My_Account_Page {
    public static WebDriver driver;

    // Constructor
    public My_Account_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // List WebElements of tiles from My account
    @FindBy(css = ".col-lg-4.col-md-6") List<WebElement> myAccountTile;

    public void clickUserInformationTile() {
        myAccountTile.get(1).click();
    }

}

