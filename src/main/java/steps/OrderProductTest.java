package steps;

import CoreTest.SetupBrowser;
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
    }

    @When("^User click on product$")
    public void userClickOnProduct() {
        home_page.clickProduct();
    }
}
