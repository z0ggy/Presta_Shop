package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;

public class Product_Page {

    public Product_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "regular-price")
    WebElement regularPrice;

    @FindBy(className = "current-price")
    WebElement currentPrice;

    public double checkDiscount(double percent) {
        double priceBeforeDiscount = Double.parseDouble(regularPrice.getText().substring(1));
        return priceBeforeDiscount - priceBeforeDiscount * (percent / 100);
    }

    public void checkProductIsOnDiscount(double percent) {
        double priceAfterDiscount = Double.parseDouble(currentPrice.getText().substring(1, 7));
        if (checkDiscount(percent) == priceAfterDiscount) {
            System.out.println("Price is on " + percent + " % " + "discount");
        } else {
            Assert.fail("Price is not on discount");
        }
    }
}
