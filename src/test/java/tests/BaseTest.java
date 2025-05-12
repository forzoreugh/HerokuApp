package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.BasePage;
import java.time.Duration;
import java.util.HashMap;

public class BaseTest {

    WebDriver driver;
    BasePage basePage;
    SoftAssert softAssert;
    WebDriverWait webDriverWait;

    @BeforeMethod
    public WebDriver setup() {
        ChromeOptions options = new ChromeOptions();
        HashMap<String, Object> chromePrefs = new HashMap<>();
        chromePrefs.put("credentials_enable_service", false);
        chromePrefs.put("profile.password_manager_enabled", false);
        options.setExperimentalOption("prefs", chromePrefs);
        options.addArguments("--incognito");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--disable-infobars");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        basePage = new BasePage(driver);
        softAssert  = new SoftAssert();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return driver;
    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
