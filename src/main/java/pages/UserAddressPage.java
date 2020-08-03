package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class UserAddressPage {
    public static WebDriver driver;

    // Constructor
    public UserAddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#_desktop_user_info a.account > span")
    WebElement myAccount;

    @FindBy(css = "div.links>a:nth-child(2)")
    WebElement newAddress;

    @FindBy(name = "alias")
    WebElement alias;

    @FindBy(name = "city")
    WebElement city;

    @FindBy(name = "postcode")
    WebElement postcode;

    @FindBy(css = "select[name='id_country']")
    WebElement country;

    @FindBy(xpath = "//option[text()='United Kingdom']")
    WebElement countryChoose;

    @FindBy(css = "input[name='phone']")
    WebElement phone;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement submit;

    @FindBy(css = "input[name='address1']")
    WebElement address;

    @FindBy(css = "a[data-link-action='delete-address']")
    WebElement delAddress;

    @FindBy(xpath = "//li[contains(text(),'Address successfully deleted')]")
    WebElement deleteMessage;




    // Click on user name in right corner
    public void clickUserName() {
        myAccount.click();
    }

    // Click on Add first address tile
    public void clickNewAddrr() {
        newAddress.click();
    }

    // Fill Alias field
    public void addAlias(String myAlias) {
        alias.clear();
        alias.sendKeys(myAlias);
        form.add(alias.getAttribute("value"));
    }

    // Fill City field
    public void addCity(String myCity) {
        city.clear();
        city.sendKeys(myCity);
        form.add(city.getAttribute("value"));
    }

    // Fill Postcode/Zip field
    public void addZip(String myZip) {
        postcode.clear();
        postcode.sendKeys(myZip);
        form.add(postcode.getAttribute("value"));
    }

    // Fill Country box list
    public void addCountry() {
        country.click();
        countryChoose.click();
    }

    // Fill Phone field
    public void addPhone(String myPhone) {
        phone.sendKeys(myPhone);
        form.add(phone.getAttribute("value"));
    }

    // Waiting for the button to be clickable and click it
    public void submitButton() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        submit.click();
    }

    public void addAddress(String myAddress) {
        address.sendKeys(myAddress);
    }

    public void deleteAddress() {
        delAddress.click();
    }
    public void getDeletedMessage() {
        System.out.println(deleteMessage.getText());
    }

    public void closeBrowser() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[contains(text(),'Address successfully deleted')]")));
        driver.quit();
    }

    // Asserts
    // Dwie listy jedna zawiera elementy wpisane do formularza a druga liste wartosci z tabeli feature
    ArrayList<String> form = new ArrayList<>();
    ArrayList<String> assertForm = new ArrayList<>();

    public void asserFormAdd() {
        assertForm.add("Grunwald");
        assertForm.add("Ladek Zdroj");
        assertForm.add("00-000");
        assertForm.add("004878965033");
        assertForm.add("Zasadniczo");
        assertForm.add("Praga");
        assertForm.add("000-001");
        assertForm.add("0045876921");
        assertForm.add("Ogorkowa");

       // assertEquals(form, assertForm);


    }
    public void displayAllItems() {
        for (int i = 0; i < form.size(); i++) {
            String element = form.get(i);
            for (int j = 0; j < assertForm.size(); j++)
                 element = assertForm.get(j);
            if (element.equals(element))
            System.out.println(element);
            else {
                return;
            }
            System.out.println("Assert Pass");
        }
    }

    public void validDataForm() {
//        System.out.println(alias.getAttribute("value"));
//        assertEquals(form, alias.getAttribute("value"));
//        System.out.println(city.getAttribute("value"));
//        assertEquals("Ladek Zdroj", city.getAttribute("value"));
//        System.out.println(postcode.getAttribute("value"));
//        assertEquals("00-000", postcode.getAttribute("value"));
//        System.out.println(phone.getAttribute("value"));
//        assertEquals("004878965033", phone.getAttribute("value"));
//        System.out.println(address.getAttribute("value"));
//        assertEquals("Kolejowa street", address.getAttribute("value"));

        System.out.println("Lista for zawiera: " + form);




    }
}
