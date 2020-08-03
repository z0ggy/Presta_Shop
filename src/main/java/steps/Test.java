package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Login_Page;
import pages.ZadanieWar_1_Page;

import java.util.concurrent.TimeUnit;

public class Test {
    ZadanieWar_1_Page addressPage;
    WebDriver driver;
    @Given("^Log in to CodersLab shopex$")
    public void userLoggedToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        Login_Page loginPage = new Login_Page(driver);
        loginPage.loginAs("dvxmvgmxleffsbttcw@awdrt.org", "12345");
    }

    @When("^User goes to AddressPage xxx$")
    public void userGoesToAddressPage() {
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=addresses");
        addressPage = new ZadanieWar_1_Page(driver);
        addressPage.doSkasowania();

    }

    @And("User set following address xxx \"([^\"]*)\"$")
    public void userSetFollowingAddress(String address) {
        addressPage.addAddress(address);
    }
//
//    @And("^User set following city \"([^\"]*)\"$")
//    public void userSetFollowingCity(String city) {
//        addressPage.addCity(city);
//    }

//    @And("^User set following post code \"([^\"]*)\"$")
//    public void userSetFollowingPostCode(String postCode) {
//        addressPage.addZip(postCode);
//    }
//
//    @And("^User submits add new address form$")
//    public void userSubmitsAddNewAddressForm() {
//        addressPage.submitButton();
//    }
//
//    @Then("^Address was submitted correctly xxx$")
//    public void addressWasSubmittedCorrectly() {
//        addressPage.getUpdateInformation();
//    }

    @And("^closed driver$")
    public void closeDriver() {
        driver.quit();
    }



}
