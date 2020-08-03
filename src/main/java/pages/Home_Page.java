package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
    public static WebDriver driver;

    // Constructor
    public Home_Page() {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //
    @FindBy(css = "a.account") WebElement myAccount;}

