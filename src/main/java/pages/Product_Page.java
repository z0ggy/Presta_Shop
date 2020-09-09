package pages;

import CoreTest.SetupBrowser;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Product_Page {

    public Product_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "regular-price")
    WebElement regularPrice;

    @FindBy(className = "current-price")
    WebElement currentPrice;

    @FindBy(css = "#group_1 > option")
    List <WebElement> productsSizes;

    @FindBy(css = "input.input-group") WebElement quantity;
    @FindBy(css = "div.add") WebElement cart;
    @FindBy(css = "a.btn") WebElement proceed;

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
    public void ChooseSize(String size) {
        for (int i = 0; i < productsSizes.size(); i++) {
            String element = productsSizes.get(i).getAttribute("title");
            if (element.equals(size)) {
                productsSizes.get(i).click();
                System.out.println("User selected a size "+ productsSizes.get(i).getAttribute("title"));
            }
        }
    }
    public void chooseQuantity(int total) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(SetupBrowser.getDriver(),10);
        quantity.click();
        quantity.clear();
        wait.until(ExpectedConditions.attributeToBe(quantity,"value","1"));
        quantity.sendKeys(Keys.BACK_SPACE,String.valueOf(total));
    }
    public void printValue(){
        //System.out.println(productsSizes.get(0).getText());
        System.out.println("The number of items selected  "+ quantity.getAttribute("value"));
    }
    public void addToCart() {
        cart.isDisplayed();
        cart.click();
    }
    public void proceedToCheckout() {
        proceed.isDisplayed();
        proceed.click();
    }
}
