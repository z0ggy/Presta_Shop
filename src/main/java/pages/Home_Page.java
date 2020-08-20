package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

    public Home_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

}
