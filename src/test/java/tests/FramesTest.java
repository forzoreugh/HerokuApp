package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FramesTest extends BaseTest {

    @Test
    public void iframeTest(){
        basePage.getUrl("https://the-internet.herokuapp.com/iframe");
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        assertEquals(driver.findElement(By.cssSelector(".mce-content-body.mce-content-readonly")).getText(),
                "Your content goes here.");
    }

    @Test
    public void nestedFramesTest(){
        basePage.getUrl("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
        WebElement middleFrame = driver.findElement(By.id("content"));
        assertEquals(middleFrame.getText(), "MIDDLE");
    }
}
