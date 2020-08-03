package steps;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.Header_Page;
import pages.Login_Page;
import pages.My_Account_Page;

import java.util.concurrent.TimeUnit;

public class JunitZadanie2 {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver(); // Uruchomienie przegladarki chrome

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://prod-kurs.coderslab.pl/index.php?controller=authentication");
        Login_Page loginPage = new Login_Page(driver);
        loginPage.loginAs("dvxmvgmxleffsbttcw@awdrt.org", "12345");
    }

    @Test
    public void doSomeShopping() {
//        List<WebElement> article = driver.findElements(By.className("product-miniature"));
//        article.get(1).isDisplayed();
//        article.get(1).click();
        Header_Page header_page = new Header_Page(driver);
        header_page.goToMyAccountPage();
        My_Account_Page my_account_page = new My_Account_Page(driver);
        //Choose Tile from My account 0 -INFORMATION, 1 -ADDRESS, 2 -ORDER HISTORY, 3 -CREDIT SLIPS
        my_account_page.setMyAccountTile(0);


    }
}
