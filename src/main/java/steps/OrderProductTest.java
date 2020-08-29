package steps;

import CoreTest.SetupBrowser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

public class OrderProductTest {
    private static final WebDriver driver = SetupBrowser.getDriver();
    SetupBrowser setupBrowser;
    Login_Page prestaLogin_page;
    Header_Page prestaHeader_page;
    My_Account_Page prestaMyAccount_page;
    AddressesList_Page prestaAddresses_page;
    AddressForm_Page prestaAddressForm_page;
    Home_Page home_page;
    Product_Page product_page;
    ShoppingCart_Page shoppingCart_page;
    Order_Page order_page;


    @Given("^User logged in to CodersLab shop$")
    public void userLoggedInToCodersLabShop() {
        setupBrowser = new SetupBrowser(driver);
        setupBrowser.setUp();
        prestaLogin_page = new Login_Page(SetupBrowser.getDriver());
        prestaLogin_page.loginAs("dvxmvgmxleffsbttcw@awdrt.org", "12345");
        prestaHeader_page = new Header_Page(SetupBrowser.getDriver());
        prestaMyAccount_page = new My_Account_Page(SetupBrowser.getDriver());
        prestaAddresses_page = new AddressesList_Page(SetupBrowser.getDriver());
        prestaAddressForm_page = new AddressForm_Page(SetupBrowser.getDriver());
        home_page = new Home_Page(SetupBrowser.getDriver());
        product_page = new Product_Page(SetupBrowser.getDriver());
        shoppingCart_page = new ShoppingCart_Page(SetupBrowser.getDriver());
        order_page = new Order_Page(SetupBrowser.getDriver());
    }

    @When("^User click on product$")
    public void userClickOnProduct() {
        home_page.clickProduct();
    }

    @And("^User check is the product on discount (\\d+)$")
    public void userCheckIsTheProductOnDiscount(double percent) {
        product_page.checkProductIsOnDiscount(percent);
    }

    @And("^User will choose the size (.*) of the product$")
    public void userWillChooseTheSizeMOfTheProduct(String size) {
        product_page.ChooseSize(size);
    }

    @And("^User will choose (\\d+) pieces$")
    public void userWillChoosePieces(int total) throws InterruptedException {
        product_page.printValue();
        product_page.chooseQuantity(total);
        product_page.printValue();
    }

    @And("^User will add item to cart$")
    public void userWillAddItemToCart() {
        product_page.addToCart();
    }

    @And("^User will proceed to checkout$")
    public void userWillProceedToCheckout() {
        product_page.proceedToCheckout();
    }

    @And("^User will proceed to checkout from shopping cart$")
    public void userWillProceedToCheckoutFromShoppingCart() {
        shoppingCart_page.proceedToCheckout();
    }

    @And("^User will fill address form$")
    public void userWillFillAddressForm() {
        order_page.fillAddressOrderPage();
    }
}
