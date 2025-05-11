package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.time.Duration;

public class DynamicControlsTest extends BaseTest {

    @Test
    public void checkDisplayOfTheDeletedElement() {
        basePage.getUrl("https://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        softAssert.assertEquals(driver.findElement(By.cssSelector("[id=message]")).getText(), "It's gone!");
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='text']"));
        checkbox.isEnabled();
        softAssert.assertFalse(driver.findElement(By.cssSelector("[type=text]")).isEnabled());
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        softAssert.assertTrue(driver.findElement(By.cssSelector("[type=text]")).isEnabled());
        softAssert.assertAll();
    }
}
