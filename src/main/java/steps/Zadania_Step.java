package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.util.concurrent.TimeUnit;

public class Zadania_Step {

    String url = "https://prod-kurs.coderslab.pl/index.php?controller=authentication";
    String chrome = "webdriver.chrome.driver";
    String pathToWindowsDriversFile ="src/main/resources/drivers/chromedriver.exe";
    String pathToLinuxDriverFile ="src/main/resources/drivers/chromedriver";
    UserAddressPage addressPage;
    SetUp_Page setUp_page;
    Login_Page login_page;
    Header_Page header_page;
    AddressForm_Page addressForm_page;
    WebDriver driver;
    @Given("Log in to CodersLab shop")
    public void userIsLoggedInToCodersLabShop() {
        // Checking os
        if (System.getProperty("os.name").toLowerCase().contains("windows")) {
            System.setProperty(chrome,pathToWindowsDriversFile);
        }else { System.setProperty(chrome, pathToLinuxDriverFile); }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);
        login_page = new Login_Page(driver);
        login_page.loginAs("dvxmvgmxleffsbttcw@awdrt.org", "12345");
        header_page = new Header_Page(driver);

    }

    @When("^User click on user name$")
    public void userGoesToAddressPage() {
        header_page.goToMyAccountPage();

    }
    @And("^User click on Addresses tile$")
    public void userClickOnAddressesTile() {
        addressPage =  new UserAddressPage(driver);
        addressPage.clickNewAddrr();
    }

    @And("^User set following alias \"(.*)\"$")
    public void userSetFollowingAlias(String alias) {
        addressForm_page = new AddressForm_Page(driver);
        addressForm_page.formFiller(alias);
    }

    @And("^User set following city \"([^\"]*)\"$")
    public void userSetFollowingCity(String city) {
        addressPage.addCity(city);
    }

    @And("^User set following post code \"([^\"]*)\"$")
    public void userSetFollowingPostCode(String postCode) {
       addressPage.addZip(postCode);
    }

    @And("^User set following country \"([^\"]*)\"$")
    public void userSetFollowingCountry(String arg0)  {
        addressPage.addCountry();
    }

    @And("^User set following phone \"([^\"]*)\"$")
    public void userSetFollowingPhone(String phone)   {
        addressPage.addPhone(phone);
    }
    @Then("^User submits add new address form$")
    public void userSubmitsAddNewAddressForm() throws InterruptedException {
        addressPage.submitButton();
    }
    @And("^User set following address \"([^\"]*)\"$")
    public void userSetFollowingAddress(String address)   {
        addressPage.addAddress(address);
    }
    @And("^User delete address$")
    public void userDeleteAddress() {
        addressPage.deleteAddress();
    }

    @And("^User check the address is deleted$")
    public void userCheckTheAddressIsDeleted() {
        addressPage.getDeletedMessage();
    }

    @And("^print value of all form field$")
    public void printValueOfAllFormField() {
        addressPage.displayAllItems();
    }


    @And("^close driver$")
    public void closeDriver() {     driver.quit();
   }
}
