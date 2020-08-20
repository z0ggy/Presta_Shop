package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Page {

    public Home_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "article")
    List<WebElement> products;
}
