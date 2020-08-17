package steps;

import CoreTest.SetupBrowser;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.junit.Assert.assertEquals;

public class AddAddressTest {
    private static final WebDriver driver = SetupBrowser.getDriver();
    SetupBrowser setupBrowser;
    Login_Page prestaLogin_page;
    Header_Page prestaHeader_page;
    My_Account_Page prestaMyAccount_page;
    AddressesList_Page prestaAddresses_page;
    AddressForm_Page prestaAddressForm_page;

    @Given("^Log in to CodersLab shop$")
    public void logInToCodersLabShop() {
        setupBrowser = new SetupBrowser(driver);
        setupBrowser.setUp();
        prestaLogin_page = new Login_Page(SetupBrowser.getDriver());
        prestaLogin_page.loginAs("dvxmvgmxleffsbttcw@awdrt.org", "12345");
        prestaHeader_page = new Header_Page(SetupBrowser.getDriver());
        prestaMyAccount_page = new My_Account_Page(SetupBrowser.getDriver());
        prestaAddresses_page = new AddressesList_Page(SetupBrowser.getDriver());
        prestaAddressForm_page = new AddressForm_Page(SetupBrowser.getDriver());
    }

    @When("^User click on user name$")
    public void userClickOnUserName() {
        prestaHeader_page.goToMyAccountPage();
    }

    @And("^User click on Addresses tile$")
    public void userClickOnAddressesTile() {
        prestaMyAccount_page.clickUserInformationTile();
        prestaAddresses_page.checkAddress();
    }

    @And("^User set following alias \"([^\"]*)\"$")
    public void userSetFollowingAlias(String alias) {
        prestaAddressForm_page.inputAlias(alias);
        assertEquals(alias, prestaAddressForm_page.getMyAlias());
    }

    @And("^User set following address \"([^\"]*)\"$")
    public void userSetFollowingAddress(String address) {
        prestaAddressForm_page.inputAddress(address);
    }

    @And("^User set following city \"([^\"]*)\"$")
    public void userSetFollowingCity(String city)  {
        prestaAddressForm_page.inputCity(city);
    }

    @And("^User set following post code \"([^\"]*)\"$")
    public void userSetFollowingPostCode(String postCode)  {
        prestaAddressForm_page.inputPostcode(postCode);
    }

    @And("^User set following country \"([^\"]*)\"$")
    public void userSetFollowingCountry(String country)  {
        prestaAddressForm_page.chooseCountry();
    }

    @And("^User set following phone \"([^\"]*)\"$")
    public void userSetFollowingPhone(String phone)  {
        prestaAddressForm_page.inputPhone(phone);
    }

    @Then("^User submits add new address form$")
    public void userSubmitsAddNewAddressForm() {
        prestaAddressForm_page.clickSubmitButton();
    }

    @And("^User delete address$")
    public void userDeleteAddress() {
        prestaAddresses_page.deleteAddress();
    }

    @And("^User check the address is deleted$")
    public void userCheckTheAddressIsDeleted() {
        assertEquals(0, prestaAddresses_page.getDeleteAddressesList());
    }

    @And("^close driver$")
    public void closeDriver() {
            SetupBrowser.getDriver().quit();
    }
}
