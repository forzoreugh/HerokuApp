import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class DropdownTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void CheckAttributesArePresentInDropdownList(){
        driver.get("https://the-internet.herokuapp.com/dropdown");
        driver.findElement(By.id("dropdown")).click();
        List<WebElement> dropdown = driver.findElements(By.tagName("option"));
        Assert.assertTrue(dropdown.get(0).isDisplayed());
        Assert.assertTrue(dropdown.get(1).isDisplayed());
        Assert.assertTrue(dropdown.get(2).isDisplayed());
        dropdown.get(1).click();
        Assert.assertTrue(dropdown.get(1).isSelected());
        dropdown.get(2).click();
        Assert.assertTrue(dropdown.get(2).isSelected());
    }

    @AfterMethod
    public void quitBrowser(){
        driver.quit();
    }
}
