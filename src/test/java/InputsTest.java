import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class InputsTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void CheckInputEntry(){
        driver.get("https://the-internet.herokuapp.com/inputs");
        WebElement inputField = driver.findElement(By.tagName("input"));
        inputField.sendKeys("AaЮю_=:/");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        Assert.assertEquals("1", inputField.getAttribute("value")); // not correct + arrow up
        driver.findElement(By.tagName("input")).clear();
        inputField.sendKeys("AaЮю_=:/");
        driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        Assert.assertEquals("-1", inputField.getAttribute("value")); // not correct + arrow down
        driver.findElement(By.tagName("input")).clear();
        inputField.sendKeys("50");
        for (int x = 0; x < 10; x++){
            driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_UP);
        }
        Assert.assertEquals("60", inputField.getAttribute("value")); // correct + arrow up
        for (int y = 0; y < 10; y++){
            driver.findElement(By.tagName("input")).sendKeys(Keys.ARROW_DOWN);
        }
        Assert.assertEquals("50", inputField.getAttribute("value")); // correct + arrow down
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
