import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;
import java.util.List;

public class CheckboxesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void сheckingTheInstallationOfCheckboxes(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("[type=checkbox]"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(checkboxes.get(0).isSelected());
        checkboxes.get(0).click();
        softAssert.assertTrue(checkboxes.get(0).isSelected());
        softAssert.assertTrue(checkboxes.get(1).isSelected());
        checkboxes.get(1).click();
        softAssert.assertFalse(checkboxes.get(1).isSelected());
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
