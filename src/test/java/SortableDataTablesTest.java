import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;

public class SortableDataTablesTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void сheckAvailabilityData(){
        driver.get("http://the-internet.herokuapp.com/tables");
        WebElement lastname = driver.findElement(By.xpath("//table//tr[1]//td[1]"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(lastname.getText(), "Smith");
        WebElement firstname = driver.findElement(By.xpath("//table//tr[1]//td[2]"));
        softAssert.assertEquals(firstname.getText(), "John");
        WebElement email = driver.findElement(By.xpath("//table//tr[2]//td[3]"));
        softAssert.assertEquals(email.getText(), "fbach@yahoo.com");
        WebElement due = driver.findElement(By.xpath("//table//tr[2]//td[4]"));
        softAssert.assertEquals(due.getText(), "$51.00");
        WebElement website = driver.findElement(By.xpath("//table//tr[3]//td[5]"));
        softAssert.assertEquals(website.getText(), "http://www.jdoe.com");
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
