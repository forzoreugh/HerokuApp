import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.time.Duration;

public class HoversTest {

    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void CheckProfile(){
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        WebElement user1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/img"));
        action.moveToElement(user1).moveToElement(driver.findElement
                (By.xpath("//*[@id=\"content\"]/div/div[1]/img"))).click().build().perform();
        WebElement nameUser1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        Assert.assertEquals(nameUser1.getText(), "name: user1");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a")).click();
        WebElement errorTextUser1 = driver.findElement(By.xpath("/html/body/h1"));
        Assert.assertTrue(errorTextUser1.isDisplayed());

        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement user2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/img"));
        action.moveToElement(user2).moveToElement(driver.findElement
                (By.xpath("//*[@id=\"content\"]/div/div[2]/img"))).click().build().perform();
        WebElement nameUser2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
        Assert.assertEquals(nameUser2.getText(), "name: user2");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/a")).click();
        WebElement errorTextUser2 = driver.findElement(By.xpath("/html/body/h1"));
        Assert.assertTrue(errorTextUser2.isDisplayed());

        driver.get("http://the-internet.herokuapp.com/hovers");
        WebElement user3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/img"));
        action.moveToElement(user3).moveToElement(driver.findElement
                (By.xpath("//*[@id=\"content\"]/div/div[3]/img"))).click().build().perform();
        WebElement nameUser3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
        Assert.assertEquals(nameUser3.getText(), "name: user3");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/a")).click();
        WebElement errorTextUser3 = driver.findElement(By.xpath("/html/body/h1"));
        Assert.assertTrue(errorTextUser3.isDisplayed());
    }

    @AfterMethod(alwaysRun = true)
    public void quitBrowser(){
        driver.quit();
    }
}
