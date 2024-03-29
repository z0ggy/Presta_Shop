package steps;

import CoreTest.SetupBrowser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JunitAddAddressTest {
    private static final WebDriver driver = SetupBrowser.getDriver();
    SetupBrowser setupBrowser;
    Login_Page login_page;
    Header_Page header_page;
    My_Account_Page my_account_page;
    AddressesList_Page addressesList_page;
    AddressForm_Page addressForm_page;
    @Before
    public void Before() {
        setupBrowser = new SetupBrowser(driver);
        setupBrowser.setUp();
        login_page = new Login_Page(SetupBrowser.getDriver());
        header_page = new Header_Page(SetupBrowser.getDriver());
        my_account_page = new My_Account_Page(SetupBrowser.getDriver());
        addressesList_page = new AddressesList_Page(SetupBrowser.getDriver());
        addressForm_page = new AddressForm_Page(SetupBrowser.getDriver());
    }
    @Test
    public void prestaAddressFormFill() {
        login_page.loginAs("dvxmvgmxleffsbttcw@awdrt.org", "12345");
        header_page.goToMyAccountPage();
        my_account_page.clickUserInformationTile();
        // Check to create new address or add another address to exists addresses
        addressesList_page.checkAddress();

        addressForm_page.inputAlias("John");
        assertEquals("John", addressForm_page.getMyAlias());

        addressForm_page.inputAddress("ul. Zielona");
        assertEquals("ul. Zielona",addressForm_page.getMyAddress());

        addressForm_page.inputPostcode("002-222");
        assertEquals("002-222", addressForm_page.getMyPostcode());

        addressForm_page.inputCity("London");
        assertEquals("London", addressForm_page.getMyCity());

        addressForm_page.chooseCountry();
        assertEquals("United Kingdom",addressForm_page.getMyCountry());

        addressForm_page.clickSubmitButton();

        // Delete all addresses and checking to all addresses are deleted
        addressesList_page.deleteAddress();
        assertEquals(0, addressesList_page.getDeleteAddressesList());
    }
    @After
    public void tearDown() {
        SetupBrowser.getDriver().quit();
    }
}
