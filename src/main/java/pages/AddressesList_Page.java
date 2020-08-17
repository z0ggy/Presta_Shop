package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressesList_Page {
    public AddressesList_Page(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "a[data-link-action='delete-address']")
    List<WebElement> deleteAddressesList;

    @FindBy(css = "a[href*='delete']")
    WebElement lastAddress;

    @FindBy(css = ".addresses-footer>a")
    WebElement createNewAddress;


    public void deleteAddress() {
        for (int i = deleteAddressesList.size(); i > 0; i--) {
            lastAddress.isDisplayed();
            lastAddress.click();
        }
    }

    public void checkAddress() {
        boolean isAddressPage = deleteAddressesList.size() > 0;
        if (isAddressPage) {
            createNewAddress.isDisplayed();
            createNewAddress.click();
        }
        return;
    }


    public void existedAddressCheck() {
        if (!deleteAddressesList.isEmpty()) {
            createNewAddress.isDisplayed();
            createNewAddress.click();
        } else {
            return;
        }
    }

    public void jebaneAdressy() {
        for (int i = deleteAddressesList.size(); i > 0; i--) {
            WebElement element = deleteAddressesList.get(i - 1);
            element.isDisplayed();
            element.click();

        }
    }
    public int getDeleteAddressesList(){
        return deleteAddressesList.size();
    }

}

