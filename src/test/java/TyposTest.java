import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class TyposTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void checkValueEntry() {
            driver.get("http://the-internet.herokuapp.com/typos");
            String text = driver.findElements(By.tagName("p")).get(1).getText();
            while (!text.equals("Sometimes you'll see a typo, other times you won't.")){
                driver.navigate().refresh();
                text = driver.findElements(By.tagName("p")).get(1).getText();
            }
            Assert.assertEquals(text, "Sometimes you'll see a typo, other times you won't.");


    }

    @AfterMethod (alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
