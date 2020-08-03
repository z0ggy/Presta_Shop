package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class SetUp_Page {
    String url = "https://prod-kurs.coderslab.pl/index.php?controller=authentication";
    String chrome = "webdriver.chrome.driver";
    String pathToDriversFile ="src/main/resources/drivers/chromedriver";

    public static WebDriver driver;

    public SetUp_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void fireBrowser() {
        System.setProperty(chrome,pathToDriversFile);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(url);


    }
}
